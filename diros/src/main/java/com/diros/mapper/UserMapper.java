package com.diros.mapper;

import com.diros.model.User;
import com.diros.util.Imapper;

public interface UserMapper extends Imapper<User> {
	/**
	 * 功能：登录验证
	 * @param user
	 * @return User
	 * @throws Exception
	 */
	User basicLogin(User user) throws Exception;
	
	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	int countsOfGivenName(String name) throws Exception;
	
	/**
	 * 修改用户密码
	 * @param aUser
	 * @throws Exception
	 */
	public int modifyPassword(User aUser) throws Exception;
	
	/**
	 * 通过用户名查找用户对象
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public User findByUserName(String userName)throws Exception;
}
