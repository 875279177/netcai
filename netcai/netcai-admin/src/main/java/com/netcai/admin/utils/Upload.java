package com.netcai.admin.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class Upload extends HttpServlet {
  
    private File imgFile;
    /**
     * 文件名称
     */
    private String imgFileFileName;

    /**
     * 图片宽度
     */
    private String imgWidth;

    /**
     * 图片高度
     */
    private String imgHeight;

    /**
     * 图片对齐方式
     */
    private String align;

    /**
     * 图片标题
     */
    private String imgTitle;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		uploadImg( request,  response);
    
    }
  

    @SuppressWarnings({ "rawtypes", "unused" })
	public String uploadImg(HttpServletRequest request, HttpServletResponse response) {
        String type = request.getParameter("type");
        //文件保存目录路径
    	String savePath  = this.getServletContext().getRealPath("/");
    	//文件保存目录URL
    	String saveUrl = request.getContextPath();
    	//商品图片
        if("1".equals(type)){
        	savePath +=  "upload/product/";
        	saveUrl  += "upload/product/";
        }else if("2".equals(type)){  //品牌分类图片
        	savePath +=  "upload/brand/";
        	saveUrl  += "upload/brand/";
        }else if("3".equals(type)){  //广告图片
        	savePath +=  "upload/advert/";
        	saveUrl  += "upload/advert/";
        }else if("4".equals(type)){  //会员图片
        	savePath +=  "upload/member/";
        	saveUrl  += "upload/member/";
        }else if("5".equals(type)){  //附件及文件
        	savePath +=  "upload/file/";
        	saveUrl  += "upload/file/";
        }
    	

    	//定义允许上传的文件扩展名
    	HashMap<String, String> extMap = new HashMap<String, String>();
    	extMap.put("image", "gif,jpg,jpeg,png,bmp");
    	extMap.put("flash", "swf,flv");
    	extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
    	extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

    	//最大文件大小
    	long maxSize = 1000000;
    	PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e1) {
            //log.error(e1);
        }

    	response.setContentType("textml; charset=UTF-8");

    	if(!ServletFileUpload.isMultipartContent(request)){
    		out.println(getError("请选择文件。"));
    		return null;
    	}
    	//检查目录
    	File uploadDir = new File(savePath);
    	if(!uploadDir.isDirectory()){
    		//out.println(getError("上传目录不存在。"));
    		//return null;
    		uploadDir.mkdirs();
    	}
    	//检查目录写权限
    	if(!uploadDir.canWrite()){
    		out.println(getError("上传目录没有写权限。"));
    		return null;
    	}

    	String dirName = request.getParameter("dir");
    	if (dirName == null) {
    		dirName = "image";
    	}
    	if(!extMap.containsKey(dirName)){
    		out.println(getError("目录名不正确。"));
    		return null;
    	}
    	//创建文件夹
    	savePath += dirName + "/";
    	saveUrl += dirName + "/";
    	File saveDirFile = new File(savePath);
    	if (!saveDirFile.exists()) {
    		saveDirFile.mkdirs();
    	}
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	String ymd = sdf.format(new Date());
    	savePath += ymd + "/";
    	saveUrl += ymd + "/";
    	File dirFile = new File(savePath);
    	if (!dirFile.exists()) {
    		dirFile.mkdirs();
    	}


        FileItemFactory factory = new DiskFileItemFactory();
    	ServletFileUpload upload = new ServletFileUpload(factory);
    	upload.setHeaderEncoding("UTF-8");
    	List items;
		try {
			items = upload.parseRequest(request);
			Iterator itr = items.iterator();
	    	while (itr.hasNext()) {
	    		FileItem item = (FileItem) itr.next();
	    		String fileName = item.getName();
	    		long fileSize = item.getSize();
	    		if (!item.isFormField()) {
	    			//检查文件大小
	    			if(item.getSize() > maxSize){
	    				out.println(getError("上传文件大小超过限制。"));
	    				return null;
	    			}
	    			//检查扩展名
	    			String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
	    			if(!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)){
	    				out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。"));
	    				return null;
	    			}

	    			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
	    			String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
	    			try{
	    				File uploadedFile = new File(savePath, newFileName);
	    				item.write(uploadedFile);
	    			}catch(Exception e){
	    				out.println(getError("上传文件失败。"));
	    				return null;
	    			}
	    			JSONObject obj = new JSONObject();
	    			obj.put("error", 0);
	    			obj.put("url", saveUrl + newFileName);
	    			out.println(obj.toString());
	    		}
	    	}
		} catch (FileUploadException e1) {

			e1.printStackTrace();
		}
    	return null;
      }
  

     private String getError(String message) {
          JSONObject obj = new JSONObject();
          obj.put("error", 1);
          obj.put("message", message);
          //log.debug(obj);
          return obj.toString();
      }

	public File getImgFile() {
		return imgFile;
	}

	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}

	public String getImgFileFileName() {
		return imgFileFileName;
	}

	public void setImgFileFileName(String imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}

	public String getImgWidth() {
		return imgWidth;
	}

	public void setImgWidth(String imgWidth) {
		this.imgWidth = imgWidth;
	}

	public String getImgHeight() {
		return imgHeight;
	}

	public void setImgHeight(String imgHeight) {
		this.imgHeight = imgHeight;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getImgTitle() {
		return imgTitle;
	}

	public void setImgTitle(String imgTitle) {
		this.imgTitle = imgTitle;
	}

      
}

