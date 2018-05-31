package com.netcai.buyer.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.constants.UserStatus;
import com.netcai.buyer.dao.BuyerDao;
import com.netcai.buyer.dao.UsersDao;
import com.netcai.buyer.entity.Buyer;
import com.netcai.buyer.entity.Users;
import com.netcai.buyer.service.BuyerService;
import com.netcai.buyer.utils.PageUtil;
import com.netcai.buyer.vo.CommonListVo;
import com.netcai.buyer.vo.DeliveryCoordinateVo;
import com.netcai.buyer.vo.MyIndexVo;
import com.netcai.sms.gateway.SmsMessageService;
import com.netcai.sms.gatewayImpl.SmsMessageServiceImpl;
import com.netcai.sms.utils.SmsMessage;

/**
 * @author administrator
 */

@Service
public class BuyerServiceImpl implements BuyerService {

	private static final Logger logger = LoggerFactory.getLogger(BuyerServiceImpl.class);
	
	@Autowired
	private BuyerDao buyerDao;
	
	@Autowired
	private UsersDao usersDao;
	
	@Override
	public Buyer getBuyerById(Long id) {
		return buyerDao.getBuyerById(id);
	}

	@Override
	public int insertBuyer(Buyer buyer, Users users) {
		return buyerDao.insertBuyer(buyer);
	}

	@Override
	public PageUtil getPageResult(Buyer buyer, int currentPageNum, int currentPageSize) {
		return null;
	}

	@Override
	public void updateBuyer(Buyer buyer) 
	{
		buyerDao.updateBuyer(buyer);
		usersDao.updateUsersStatus(buyer.getBuyerId(),UserStatus.AUDITED);
	}

	@Override
	public Buyer getBuyerByUserId(Long userId) {
		return buyerDao.getBuyerByUserId(userId);
	}
	
    /**
     * 常用清单
     */
    public List<CommonListVo> getCommonList(Long userId){
    	return buyerDao.getCommonList(userId);
    }
    
    /**
     * 添加收藏
     */
    public int insertBuyerCollect(Long userId,Long goodsId){
    	return buyerDao.insertBuyerCollect(userId, goodsId);
    }
    
    /**
     * 取消收藏
     */
    public int deleteBuyerCollect(Long bcId){
    	return buyerDao.deleteBuyerCollect(bcId);
    }
    
    /**
     * 取消收藏
     */
    public int cancelBuyerCollect(Long userId,Long goodsId){
    	return buyerDao.cancelBuyerCollect(userId, goodsId);
    }
    
    /**
     * 我的收藏列表
     */
    public List<CommonListVo> getCollectList(Long userId){
    	return buyerDao.getCollectList(userId);
    }
    
    /**
     * 我的常用清单
     */
    public List<CommonListVo> getMyCommonList(Long userId){
    	return buyerDao.getMyCommonList(userId);
    }
    
    /**
     * 添加买家常用清单
     */
    public int insertBuyerCommon(Long buyerId,Integer buyerType,Long areaId){
    	return buyerDao.insertBuyerCommon(buyerId, buyerType, areaId);
    }
    
    /**
     * 删除常用清单
     */
    public int deleteBuyerCommon(Long userId,Long goodsId){
    	return buyerDao.deleteBuyerCommon(userId, goodsId);
    }
    
    /**
     * 获取配送人员最新坐标
     */
    public DeliveryCoordinateVo getNewDeliveryCoordinate(Long userId){
    	return buyerDao.getNewDeliveryCoordinate(userId);
    }
    
    /**
     * 变更业务员
     */
	@Override
	public void modifySales() {
		List<Buyer> buyers = buyerDao.modifySales();
		for(Buyer buyer : buyers){
			if(StringUtils.isBlank(buyer.getBossTel())){
				continue ;
			}
			//发送短信通知买家变更业务员
			SmsMessage smsMessage = new SmsMessage();
			smsMessage.setAccount(buyer.getBossTel());
			smsMessage.setName("魔笛食材徐东区");
			SmsMessageService smsService=new SmsMessageServiceImpl();
			
			//模拟生产环境
			String environment="product";
			boolean result = smsService.modifySales(smsMessage, environment);
			logger.info("[短信发送][买家姓名]——>"+buyer.getBossName()+"+++++[联系方式]——>"+buyer.getBossTel() +"[短信发送结果]——>"+result);
		}
	}

	@Override
	public MyIndexVo getMyIndex(Long buyerId) {
		return buyerDao.getMyIndex(buyerId);
	}
}