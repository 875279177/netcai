package com.netcai.admin.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class MultipartFileUtils {
	
	private static final Logger logger =LoggerFactory.getLogger(DateUtil.class);
	// windows
	private static final String PATH = "/webser/storage/";

	private static final String PATH_LINE = "/";
	
	public static List<String> getImgPath(HttpServletRequest request, HttpServletResponse response,MultipartFile[] imgFile) throws Exception{
		response.setCharacterEncoding("utf-8");
		// 文件保存本地目录路径
		String savePath = "";
		String os = System.getProperty("os.name");
		if (os.toLowerCase().startsWith("win")) {
			// windows 下路径
			savePath = request.getSession().getServletContext().getRealPath("/") + PATH;
		} else {
			// linux 下路径
			savePath = PATH;
		}
		// 文件保存目录URL
		String saveUrl = request.getContextPath() + PATH;
		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new Exception("请选择文件");
		}
		// 检查目录
		File uploadDir = new File(savePath);
		if (!uploadDir.isDirectory()) {
			uploadDir.mkdirs();
		}
		// 检查目录写权限
		if (!uploadDir.canWrite()) {
			throw new Exception("上传目录没有写权限。");
		}

		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}

		// 定义允许上传的文件扩展名
		Map<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,xml,txt,zip,rar,gz,bz2");

		if (!extMap.containsKey(dirName)) {
			throw new Exception("目录名不正确。");
		}
		// 创建文件夹
		savePath += dirName + PATH_LINE;
		saveUrl += dirName + PATH_LINE;
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		
		//当前时间的年月日
		String ymd = DateUtil.dateToString(new Date(), DateUtil.FMT_DATE_COMPACT);
		savePath += ymd + PATH_LINE;
		saveUrl += ymd + PATH_LINE;
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		// 最大文件大小
		long maxSize = 1000000;
		// 保存文件
		int i = 0;
		//保存图片路径list
		List<String> imgPathList=new ArrayList<String>();
		for (MultipartFile iFile : imgFile) {
			try {
				//获取文件名称
				String fileName = iFile.getOriginalFilename();
				// 检查文件大小
				if (iFile.getSize() > maxSize) {
					throw new Exception("第" + i + "张图片大小超过限制。");
				}
				// 检查扩展名
				String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
				if (!Arrays.<String> asList(extMap.get(dirName).split(",")).contains(fileExt)) {
					throw new Exception("第" + i + "张图片扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。");
					
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
				File uploadedFile = new File(savePath, newFileName);
				// 写入文件
				FileUtils.copyInputStreamToFile(iFile.getInputStream(), uploadedFile);
				i++;
				// 保存图片路径
				imgPathList.add(saveUrl + newFileName);
			} catch (Exception e) {
				logger.error("[fileupload] " + "第" + i + "张图片上传失败。 exception :", e);
			}
		}
		int j = imgFile.length - i;
		logger.info("成功上传"+i+"张图片，失败"+j+"张");
		return imgPathList;
	}

}
