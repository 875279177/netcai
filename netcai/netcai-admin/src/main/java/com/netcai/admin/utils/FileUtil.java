package com.netcai.admin.utils;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  

public class FileUtil {

	/**
	 * @param src 来源文件地址
	 * @param target 目的文件地址
	 * return stat 0失败 1成功
	 */
	public static int copyFile(String src,String target)  {     
       File srcFile = new File(src);    
       File targetFile = new File(target); 
       int stat = 0;
       try {    
           InputStream in = new FileInputStream(srcFile);     
           OutputStream out = new FileOutputStream(targetFile);    
           byte[] bytes = new byte[1024];    
           int len = -1;    
           while((len=in.read(bytes))!=-1)  
           {    
               out.write(bytes, 0, len);    
           }    
           in.close();    
           out.close();    
           stat = 1;
       } catch (FileNotFoundException e) {    
           e.printStackTrace();    
       } catch (IOException e) {    
           e.printStackTrace();    
       }    
       return stat;  
    }  
	
	public static void main(String[] args)  
    {  
        String src="F:/hw_workspace/netcai-admin/src/main/webapp/webser/storage/image/20170728/20170728182119_172.png";  
        String target="F:/test.png";  
        copyFile(src,target);  
    }      
}
