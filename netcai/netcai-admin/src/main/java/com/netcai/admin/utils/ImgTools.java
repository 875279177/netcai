package com.netcai.admin.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
 
public class ImgTools {
 
    /**
     * 按照 宽高 比例压缩
     * 
     * @param img
     * @param width
     * @param height
     * @param out
     * @throws IOException
     */
    public static void thumbnail_w_h(File img, int width, int height,
            OutputStream out) throws IOException {
        BufferedImage bi = ImageIO.read(img);
        double srcWidth = bi.getWidth(); // 源图宽度
        double srcHeight = bi.getHeight(); // 源图高度
 
        double scale = 1;
 
        if (width > 0) {
            scale = width / srcWidth;
        }
        if (height > 0) {
            scale = height / srcHeight;
        }
        if (width > 0 && height > 0) {
            scale = height / srcHeight < width / srcWidth ? height / srcHeight
                    : width / srcWidth;
        }
 
        thumbnail(img, (int) (srcWidth * scale), (int) (srcHeight * scale), out);
 
    }
 
    /**
     * 按照固定宽高原图压缩
     * 
     * @param img
     * @param width
     * @param height
     * @param out
     * @throws IOException
     */
    public static void thumbnail(File img, int width, int height,
            OutputStream out) throws IOException {
        BufferedImage BI = ImageIO.read(img);
        Image image = BI.getScaledInstance(width, height, Image.SCALE_SMOOTH);
 
        BufferedImage tag = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = tag.getGraphics();
        g.setColor(Color.RED);
        g.drawImage(image, 0, 0, null); // 绘制处理后的图
        g.dispose();
        ImageIO.write(tag, "JPEG", out);
    }
 
    /**
     * 按照宽高裁剪
     * 
     * @param srcImageFile
     * @param destWidth
     * @param destHeight
     * @param out
     */
    public static void cut_w_h(File srcImageFile, int destWidth,
            int destHeight, OutputStream out) {
        cut_w_h(srcImageFile, 0, 0, destWidth, destHeight, out);
    }
 
    public static void cut_w_h(File srcImageFile, int x, int y, int destWidth,
            int destHeight, OutputStream out) {
        try {
            Image img;
            ImageFilter cropFilter;
            // 读取源图像
            BufferedImage bi = ImageIO.read(srcImageFile);
            int srcWidth = bi.getWidth(); // 源图宽度
            int srcHeight = bi.getHeight(); // 源图高度
 
            if (srcWidth >= destWidth && srcHeight >= destHeight) {
                Image image = bi.getScaledInstance(srcWidth, srcHeight,
                        Image.SCALE_DEFAULT);
 
                cropFilter = new CropImageFilter(x, y, destWidth, destHeight);
                img = Toolkit.getDefaultToolkit().createImage(
                        new FilteredImageSource(image.getSource(), cropFilter));
                BufferedImage tag = new BufferedImage(destWidth, destHeight,
                        BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(img, 0, 0, null); // 绘制截取后的图
                g.dispose();
                // 输出为文件
                ImageIO.write(tag, "JPEG", out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// #cut_w_h
    
    
    /**
    * 根据设置的宽高等比例压缩图片文件<br>
    * 先保存原文件，再压缩、上传
    * 
    * @param oldFile
    * 要进行压缩的文件
    * @param newFile
    * 新文件
    * @param width
    * 宽度 //设置宽度时（高度传入0，等比例缩放）
    * @param height
    * 高度 //设置高度时（宽度传入0，等比例缩放）
    * @param quality
    * 质量
    * @return 返回压缩后的文件的全路径
    */
    public static String zipImageFile(File oldFile, File newFile, int width, int height, float quality) {
	    if (oldFile == null) {
	       return null;
	    }
	    try {
		    /** 对服务器上的临时文件进行处理 */
		    Image srcFile = ImageIO.read(oldFile);
		    int w = srcFile.getWidth(null);
		    int h = srcFile.getHeight(null);
		    double bili;
		    if (width > 0) {
		    bili = width / (double) w;
		    height = (int) (h * bili);
	    } else {
		    if (height > 0) {
			    bili = height / (double) h;
			    width = (int) (w * bili);
		    }
	    }
	
	    String srcImgPath = newFile.getAbsoluteFile().toString();
	    // System.out.println(srcImgPath);
	    String subfix = "jpg";
	    subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".") + 1, srcImgPath.length());
	
	    BufferedImage buffImg = null;
	    if (subfix.equals("png")) {
	        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    } else {
	        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    }
	
	    Graphics2D graphics = buffImg.createGraphics();
	    graphics.setBackground(new Color(255, 255, 255));
	    graphics.setColor(new Color(255, 255, 255));
	    graphics.fillRect(0, 0, width, height);
	    graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
	
	    ImageIO.write(buffImg, subfix, new File(srcImgPath));
	
	    } catch (Exception e) {
	       e.printStackTrace();
	    }
	    return newFile.getAbsolutePath();
    }

    /**
    * 按设置的宽度高度压缩图片文件<br>
    * 先保存原文件，再压缩、上传
    * 
    * @param oldFile
    * 要进行压缩的文件全路径
    * @param newFile
    * 新文件
    * @param width
    * 宽度
    * @param height
    * 高度
    * @param quality
    * 质量
    * @return 返回压缩后的文件的全路径
    */
    public static boolean zipWidthHeightImageFile(File oldFile, File newFile, int width, int height, float quality) {
	    if (oldFile == null) {
	        return false;
	    }
	    Image srcFile = null;
	    BufferedImage buffImg = null;
	    try {
		    /** 对服务器上的临时文件进行处理 */
		    srcFile = ImageIO.read(oldFile);
		
		    String srcImgPath = newFile.getAbsoluteFile().toString();
		    // System.out.println(srcImgPath);
		    String subfix = "jpg";
		    subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".") + 1, srcImgPath.length());
		
		    if (subfix.equals("png")) {
		    buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		    } else {
		    buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		    }
		
		    Graphics2D graphics = buffImg.createGraphics();
		    graphics.setBackground(new Color(255, 255, 255));
		    graphics.setColor(new Color(255, 255, 255));
		    graphics.fillRect(0, 0, width, height);
		    graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
		
		    ImageIO.write(buffImg, subfix, new File(srcImgPath));
		    return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	    return false;
	    } finally {
		    if (srcFile != null) {
		       srcFile.flush();
		    }
		    if (buffImg != null) {
		       buffImg.flush();
		    }
	    }
    }
 
    public static void main(String[] args) throws IOException {
        File img = new File("e:\\a\\a.jpg");
        FileOutputStream fos = new FileOutputStream("e:\\a\\b.jpg");
        // ImgTools.thumbnail(img, 100, 100, fos);
        // ImgTools.cut_w_h(img, 230, 200, fos);
        ImgTools.thumbnail_w_h(img, 100, 0, fos);
    }
 
}