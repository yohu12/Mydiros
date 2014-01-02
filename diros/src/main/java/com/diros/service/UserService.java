package com.diros.service;

import com.diros.model.User;
import com.diros.util.IService;

public interface UserService extends IService<User> {
	
	/**
	 * 功能：登录验证
	 * @param user
	 * @return User
	 * @throws Exception
	 */
	public User basicLogin(User user) throws Exception; 
	
	/**
	 * 功能：用户注册
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
	
	/**
	 * 注册激活
	 * @param username
	 * @param validateCode
	 */
	public void registerActivation(String username, String validateCode) throws Exception;
	/**
	 * 修改用户个人信息
	 * @param user
	 * @throws Exception
	 */
	public void modifyUserInfo(User user) throws Exception;
	
	/**
	 * 修改用户密码
	 * @param currentUser 当前用户
	 * @param oldPassword 输入的原密码
	 * @param newPassword 输入的新密码
	 * @throws Exception
	 */
	public void modifyPassword(User currentUser ,String oldPassword , String newPassword) throws Exception;

	/**
	 * 检验用户名是否可用于注册
	 * @param name
	 * @return true：可用；false：不可用
	 */
	public boolean isUserNameAvailable(String name) throws Exception;
	
	/**
	 * 
	 * @param userName 用户名
	 * @throws Exception
	 */
	public void sendEmailForPassword(String userName)throws Exception;

	/**
	 * 
	 * @param username
	 * @param validateCode
	 * @param newPassword
	 * @throws Exception
	 */
	public void findPassword(String username, String validateCode,
			String newPassword)throws Exception;

}
