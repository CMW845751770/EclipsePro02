package cn.edu.tju.service;

import cn.edu.tju.pojo.User;

public interface UserService 
{
	/**
	 * 用于用户登陆查询用户的方法
	 * @param userName
	 * @return
	 */
	User userLogin(String userName) ; 
	
	/**
	 * 用于用户注册判断用户名是否已被占用
	 * @param userName
	 * @return
	 */
	User userRegCheckName(String userName) ; 
	
	/**
	 *用于用户 注册功能
	 * @param userName
	 * @param password
	 * @return
	 */
	int userRegister(String userName , String password) ;
}
