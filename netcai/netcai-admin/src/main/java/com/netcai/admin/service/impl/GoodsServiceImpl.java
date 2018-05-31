package com.netcai.admin.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.GoodsDao;
import com.netcai.admin.dao.GoodsFormatDao;
import com.netcai.admin.dao.GoodsMethodDao;
import com.netcai.admin.dao.GoodsPictureDao;
import com.netcai.admin.dao.PriceReviseDao;
import com.netcai.admin.entity.Goods;
import com.netcai.admin.entity.GoodsFormat;
import com.netcai.admin.entity.GoodsPicture;
import com.netcai.admin.entity.GoodsSeq;
import com.netcai.admin.entity.PriceRevise;
import com.netcai.admin.service.GoodsService;
import com.netcai.admin.utils.FileUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.GoodsListVo;
import com.netcai.admin.vo.GoodsVo;
import com.netcai.admin.vo.SearchGoodsVo;

/**
 * 商品信息serviceimpl
 * @author administrator
 */
@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private GoodsFormatDao goodsFormatDao;
	@Autowired
	private GoodsPictureDao goodsPictureDao;
	@Autowired
	private GoodsMethodDao goodsMethodDao;
	@Autowired
	private PriceReviseDao priceReviseDao;
	
	/**
	 * 分页查询商品信息
	 * @param currentPageNum
	 * @param currentPageSize
	 * @return
	 */
	public List<GoodsListVo> getAllGoods(SearchGoodsVo goods,int currentPageNum,int currentPageSize){
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		return goodsDao.getAllGoods(goods,offset, currentPageSize);
	}

	/**
	 * 查询总记录数
	 * @return PageUtil
	 */
	public PageUtil getPageResult(SearchGoodsVo goods,int currentPageNum,int currentPageSize){
		int size = goodsDao.getPageCount(goods);
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<GoodsListVo> result = goodsDao.getAllGoods(goods,offset, currentPageSize);
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		paginator.setObject(result);
		return paginator;
	}
	
	
	/**
	 * 新增商品信息
	 */
	public long insertGoods(Goods goods){
		int maxSeq = goodsDao.getMaxGoodsSeq(goods.getUserId());
		goods.setGoodsSeq(maxSeq+1);
		long goodsId = goodsDao.insertGoods(goods);
		//批量新增商品规格
		if(null != goods.getFormatList() && goods.getFormatList().size()>0){
			goodsFormatDao.batchInsertGoodsFormat(goods);
		}
		//批量新增商品加工方式
		if(null != goods.getMethodList() && goods.getMethodList().size()>0){
			goodsMethodDao.batchInsertGoodsMethod(goods);
		}
		//批量新增商品图片
		if(null != goods.getPictureList() && goods.getPictureList().size()>0){
			List<GoodsPicture> gpList = new ArrayList<GoodsPicture>();
		    for (int i = 0; i < goods.getPictureList().size(); i++) {
            	GoodsPicture gp = goods.getPictureList().get(i);
            	if(!"".equals(gp.getPicUrl()) && null!=gp.getPicUrl()){
            		gpList.add(gp);
            	}
			}
			//新增商品图片
            if(gpList.size()>0){
            	goods.setPictureList(gpList);
            	goodsPictureDao.batchInsertGoodsPicture(goods);
            }
		}
		return goodsId;
	}

	/**
	 * 更新商品信息
	 */
	@Override
	public int updateGoods(Goods goods,Long sysUserId) {
		int stat = goodsDao.updateGoods(goods);
		if(null != goods.getMethodList() && goods.getMethodList().size()>0){
			//删除商品的加工方式
			goodsMethodDao.deleteGoodsMethod(goods);
			//新增商品的加工方式
			goodsMethodDao.batchInsertGoodsMethod(goods);
		}
		if(null != goods.getPictureList() && goods.getPictureList().size()>0){
			List<GoodsPicture> gpList = new ArrayList<GoodsPicture>();
			//删除商品图片
			goodsPictureDao.deleteGoodsPicture(goods.getGoodsId());
            for (int i = 0; i < goods.getPictureList().size(); i++) {
            	GoodsPicture gp = goods.getPictureList().get(i);
            	if(!"".equals(gp.getPicUrl()) && null!=gp.getPicUrl()){
            		gpList.add(gp);
            	}
			}
			//新增商品图片
            if(gpList.size()>0){
            	goods.setPictureList(gpList);
        		goodsPictureDao.batchInsertGoodsPicture(goods);
            }
		}
		List<GoodsFormat> formatList = goods.getFormatList();
		if(null != formatList && formatList.size()>0){
			//组装本次新增的规格
			List<GoodsFormat> newFormatList = new ArrayList<GoodsFormat>();
			for(GoodsFormat format : formatList){
				if(null == format || null == format.getUnitId()){
					continue;
				}
				if(null == format.getFormatId()){
					//新添加的规格放入到集合中
					newFormatList.add(format);
				} else {
					//修改规格
					this.updateGoodsFormat(format,sysUserId);
				}
			}
			if(newFormatList.size() > 0){
				goods.setFormatList(newFormatList);
				goodsFormatDao.batchInsertGoodsFormat(goods);
			}
		}
		return stat;
	}

	
	/**
	 * 根据id查找商品信息
	 */
	@Override
	public Goods getGoodsById(int goodsId){
		return goodsDao.getGoodsById(goodsId);
	}
	
	/*
	 * 更新商品图片顺序
	 */
	@Override
	public int updatePictureSeq(GoodsPicture goodsPicture){
		return goodsPictureDao.updatePictureSeq(goodsPicture);
	}
	
	/**
	 * 搜索商品信息
	 */
	@Override
	public List<GoodsVo> searchGoods(GoodsVo goodsVo){
		return goodsDao.searchGoods(goodsVo);
	}
	
	/**
	 * 修改商品规格
	 */
	@Override
	public int updateGoodsFormat(GoodsFormat goodsFormat,Long sysUserId){
		int result = goodsFormatDao.updateGoodsFormat(goodsFormat);
		BigDecimal oldPrice = goodsFormat.getOldPrice();
		BigDecimal formatPrice = goodsFormat.getFormatPrice();
		//如果价格有改动保存到价格调整记录表中
		if(oldPrice != null && oldPrice.compareTo(formatPrice) != 0){
			PriceRevise priceRevise = new PriceRevise();
			priceRevise.setFormatId(goodsFormat.getFormatId());
			priceRevise.setOldPrice(oldPrice);
			priceRevise.setRevisePrice(formatPrice);
			priceRevise.setUserId(sysUserId);
			priceReviseDao.insertPriceRevise(priceRevise);
		}
		return result;
	}
	
	/**
	 * 复制商品
	 */
	@Override
	public int copyGoods(Long goodsId,Long sellerId,HttpServletRequest request){
		Goods goods = new Goods();
		goods.setUserId(sellerId);
		goods.setGoodsId(goodsId);
		//复制商品
		int result = goodsDao.copyGoods(goods);
		long newGoodsId = goods.getGoodsId();
		//复制商品规格
		goodsFormatDao.copyGoodsFormat(newGoodsId, goodsId);
		//复制商品的加工方式
		goodsMethodDao.copyGoodsMethod(newGoodsId, goodsId);
		//复制商品图片
		List<GoodsPicture> picList = goodsPictureDao.getGoodsPicture(goodsId);
		List<GoodsPicture> newPicList = new ArrayList<GoodsPicture>();
		if(null != picList && picList.size() > 0){
			//写入文件路
			String writeUrl = "";  
			//保存后路径
			String saveUrl = "";
            String os = System.getProperty("os.name");  
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
            String ymd = sdf.format(new Date());  
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  
            
            if(os.toLowerCase().startsWith("win")){
            	//windows 下路径
            	writeUrl = request.getSession().getServletContext().getRealPath("/") + "/webser/storage/image/"+ymd+"/";
            } else{
            	//linux 下路径
            	writeUrl = "/webser/storage/image/"+ymd+"/";
            } 
            saveUrl = request.getContextPath() + "/webser/storage/image/"+ymd+"/";
            File dirFile = new File(writeUrl);  
            if (!dirFile.exists()) {  
                dirFile.mkdirs();  
            }
            String newPicUrl = "";
            String fileName = "";
            String toUrl = "";
			for (GoodsPicture pic : picList) {
				if(pic.getPicUrl()!=null && !"".equals(pic.getPicUrl())){
					String picUrl = "";
					if(os.toLowerCase().startsWith("win")){
						picUrl = request.getSession().getServletContext().getRealPath("/") + pic.getPicUrl();
					} else {
						picUrl = pic.getPicUrl();
					}
					//检查扩展名  
	                String fileExt = picUrl.substring(picUrl.lastIndexOf(".") + 1).toLowerCase(); 
	                fileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." +fileExt;
	                toUrl = writeUrl + fileName;
	                newPicUrl = saveUrl + fileName;
					int stat = FileUtil.copyFile(picUrl, toUrl);
					if(stat == 1){
						GoodsPicture gp = new GoodsPicture();
						gp.setIsMain(pic.getIsMain());
						gp.setPicSeq(pic.getPicSeq());
						gp.setPicUrl(newPicUrl);
						newPicList.add(gp);
					}
				}
			}
		}
		if(newPicList.size()>0){
			goods.setPictureList(newPicList);
			goodsPictureDao.batchInsertGoodsPicture(goods);
		}
		return result;
	}
	
	
	/**
	 * 判断商品是否可以删除
	 */
	public Integer checkGoods(Long goodsId){
		return goodsDao.checkGoods(goodsId);
	}
	
	/**
	 * 删除商品
	 */
	public int deleteGoods(Long goodsId,HttpServletRequest request){
		int stat = 0;
		Integer check = goodsDao.checkGoods(goodsId);
		if(check != null){
			//不可删除
			stat = 1;
		}else{
			//可删除
			goodsDao.deleteGoods(goodsId);
			String os = System.getProperty("os.name");  
			List<GoodsPicture> picList = goodsPictureDao.getGoodsPicture(goodsId);
			if(null != picList && picList.size() > 0){
				for (GoodsPicture pic : picList) {
					String picUrl = "";
					if(os.toLowerCase().startsWith("win")){
						picUrl = request.getSession().getServletContext().getRealPath("/") + pic.getPicUrl();
					} else {
						picUrl = pic.getPicUrl();
					}
					File file = new File(picUrl);
					if(file.exists()){
						file.delete();
					}
				}
			}
			goodsPictureDao.deleteGoodsPicture(goodsId);
		}
		return stat;
	}
	
	/**
	 * 上架/下架商品
	 */
	public int updateGoodsStatus(String goodsIds,Short goodsStatus){
		return goodsDao.updateGoodsStatus(goodsIds, goodsStatus);
	}
	
	/**
	 * 删除商品规格
	 */
	public int deleteGoodsFormat(Long formatId){
		int stat = 0;
		Integer check = goodsFormatDao.checkGoodsFormat(formatId);
		if (check !=null){
			//不可删除
			stat = 1;
		} else {
			goodsFormatDao.deleteGoodsFormat(formatId);
		}
		return stat;
	}
	
	/**
	 * 删除商品图片
	 */
	public int deleteGoodsPicture(Long picId,String picUrl,HttpServletRequest request){
		int stat = goodsPictureDao.deletePictureById(picId);
		if(stat >0 ){
			String os = System.getProperty("os.name");  
			if(os.toLowerCase().startsWith("win")){
				picUrl = request.getSession().getServletContext().getRealPath("/") + picUrl;
			} 
			File file = new File(picUrl);
			if(file.exists()){
				file.delete();
			}
		}
		return stat;
	}

	@Override
	public PageUtil getPageResultByCommon(SearchGoodsVo goods, int currentPageNum, int currentPageSize) {
		int size = goodsDao.getPageCountByCommon(goods);
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<GoodsListVo> result = goodsDao.getAllGoodsByCommon(goods,offset, currentPageSize);
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		paginator.setObject(result);
		return paginator;
	}
	
	/**
	 * 批量修改商品顺序
	 */
	public int batchUpdateGoodsSeq(List<GoodsSeq> goodsSeqList){
		return goodsDao.batchUpdateGoodsSeq(goodsSeqList);
	}
	
	/**
	 * 根据商家id查询商品信息
	 */
	@Override
	public List<Map<String, Object>> selectGoodsByUserId(Long userId) {
		return goodsDao.selectGoodsByUserId(userId);
	}

	/**
	 * 根据商品id查询规格
	 */
	@Override
	public List<GoodsFormat> getGoodsFormats(Long goodsId) {
		List<GoodsFormat> list = goodsFormatDao.selectGoodsFormat(goodsId);
		Iterator<GoodsFormat> iterator =list.iterator();
		while(iterator.hasNext()){
			GoodsFormat entity = iterator.next();
			if(StringUtils.isBlank(entity.getFormatName())){
				iterator.remove();
			}
		}
		return list;
	}
}
