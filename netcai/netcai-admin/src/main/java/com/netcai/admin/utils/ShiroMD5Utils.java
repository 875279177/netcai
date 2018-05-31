package com.netcai.admin.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class ShiroMD5Utils {
	//散列次数
	public static final int hashIterations = 1;
	//构造方法中：
	//第一个参数：明文，原始密码 
	//第二个参数：盐，通过使用随机数
	//第三个参数：散列的次数，比如散列两次，相当 于md5(md5(''))
	public static String getMd5Password(String password,String salt) {
		Md5Hash md5Hash = new Md5Hash(password, salt, hashIterations);
		return md5Hash.toString();
	}
	public static void main(String[] args) {
		String password = ShiroMD5Utils.getMd5Password("haowai77goodsok", "qwerty");
		System.out.println(password.toString());
	}
	
}
