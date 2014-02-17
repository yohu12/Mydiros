package com.diros.service.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.Assert;

import com.diros.mapper.UserMapper;
import com.diros.model.User;
import com.diros.service.UserService;
//import com.diros.util.EmailSender;
import com.diros.util.MD5Util;
import com.diros.util.ServiceImpl;

//@Scope("prototype")
//@Service
public class UserServiceImpl extends ServiceImpl<User> implements UserService  {
	private final int NO_ACTIVATION = -100;
	private VelocityEngine velocityEngine;
//	@Autowired
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	@Autowired
	public void setMapper(UserMapper userMapper) {
		this.mapper = userMapper;
	}
	
	@Override
	public User basicLogin(User user) throws Exception {
		try {
			user.setPword(MD5Util.encoderByMd5(user.getPword()));
			User tmpUser = ((UserMapper) mapper).basicLogin(user);
			
			Assert.notNull(tmpUser, "登录失败：用户名或密码错误！");

			if (tmpUser.getState() == NO_ACTIVATION) {
				throw new Exception("此帐号未激活，请到注册邮箱中查收注册激活码并激活此帐号");
			}

			// 更新最后登录时间
			User aUser = new User();
			aUser.setUserId(tmpUser.getUserId());
			aUser.setLastLoginDt(new Date());
			this.update(aUser);
			
			return tmpUser;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<User> selectAll() {
		
		try {
			return mapper.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return null;
	}

	@Override
	public User register(User user) throws Exception {
		User u=null;
		try {
			boolean flag = this.isUserNameAvailable(user.getName());
			
			if (!flag) {
				throw new Exception(user.getName()+"已被注册，请更换用户名重新注册！");
			}
			
			user.setRegiestDt(new Date());
			user.setPword(MD5Util.encoderByMd5(user.getPword()));
			user.setState(NO_ACTIVATION);
			this.add(user);
			
			//发送注册激活码
			String tmpValidateCode = MD5Util.encoderByMd5(user.getName()
					+ user.getPword());
			String subject = "diors - 注册激活";
			String templatePath = "velocity/registerActivation.vm";
			
			u=this.basicLogin(user);
			this.sendEmail(user.getName(), tmpValidateCode,
					user.getEmail(), subject , templatePath);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return u;
	}
	
	@Override
	public void registerActivation(String username, String validateCode)
			throws Exception {
		try {
			UserMapper userMapper = (UserMapper)mapper;
			User tmpUser = userMapper.findByUserName(username);
			
			Assert.notNull(tmpUser, "用户名:"+username+" 不存在！");
			
			String tmpValidateCode = MD5Util.encoderByMd5(tmpUser.getName()+ tmpUser.getPword());
			
			if(!validateCode.equals(tmpValidateCode)){
				throw new Exception("激活码不正确！");
			}
			
			User aUser = new User();
			aUser.setUserId(tmpUser.getUserId());
			aUser.setState(0);//激活
			int affectedRows= userMapper.update(aUser);
			
			if (affectedRows != 1) {
				throw new Exception(username + " 激活失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void modifyUserInfo(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void modifyPassword(User currentUser, String oldPassword, String newPassword)
			throws Exception {
		try {
			UserMapper userMapper = (UserMapper)mapper;
			
			if(!currentUser.getPword().equals(MD5Util.encoderByMd5(oldPassword))){
				throw new Exception("原密码错误，修改密码操作失败！");
			}
			
			User aUser = new User();
			aUser.setUserId(currentUser.getUserId());
			aUser.setPword(MD5Util.encoderByMd5(newPassword));
			int affectedRows= userMapper.modifyPassword(aUser);
			if (affectedRows != 1) {
				throw new Exception("密码修改失败！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public void findPassword(String username, String validateCode,
			String newPassword) throws Exception {
		try {
			UserMapper userMapper = (UserMapper)mapper;
			User tmpUser = userMapper.findByUserName(username);
			Assert.notNull(tmpUser, "用户名:"+username+" 不存在！");
			String tmpValidateCode = MD5Util.encoderByMd5(tmpUser.getName()+ tmpUser.getPword());
			
			if(!validateCode.equals(tmpValidateCode)){
				throw new Exception("校验码不正确！");
			}
			
			User aUser = new User();
			aUser.setUserId(tmpUser.getUserId());
			aUser.setPword(MD5Util.encoderByMd5(newPassword));
			int affectedRows= userMapper.modifyPassword(aUser);
			if (affectedRows != 1) {
				throw new Exception("密码设置失败！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public void sendEmailForPassword(String userName) throws Exception {

		try {

			UserMapper userMapper = (UserMapper) mapper;
			User tmpUser = userMapper.findByUserName(userName);

			Assert.notNull(tmpUser, "此用户不存在！请输入正确的用户名");

			String tmpValidateCode = MD5Util.encoderByMd5(tmpUser.getName()
					+ tmpUser.getPword());
			String subject = "diors - 找回密码";
			String templatePath = "velocity/findPassword.vm";
			this.sendEmail(tmpUser.getName(), tmpValidateCode,
					tmpUser.getEmail(), subject , templatePath);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public boolean isUserNameAvailable(String name) throws Exception{
		int count = 1;
		try {
			count =  ((UserMapper)mapper).countsOfGivenName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count == 0;
	}
	
	/**
	 * 发送邮件
	 * @param userName	用户名
	 * @param validateCode	激活码
	 * @param emailAddr		邮件地址
	 * @param subject		邮件主题
	 * @param templatePath	邮件模板路径
	 * @throws Exception
	 */
	private void sendEmail(String userName, String validateCode,
			String emailAddr, String subject, String templatePath)
			throws Exception {
		try {
			Assert.hasText(userName, "用户名不能为空！");
			Assert.hasText(validateCode, "激活码不能为空！");
			Assert.hasText(emailAddr, "邮件地址不能为空！");
			Assert.hasText(subject, "邮件主题不能为空！");

			Map<String, Object> model = new HashMap<String, Object>();
			model.put("username", userName);
			model.put("validateCode", validateCode);
			String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templatePath, "utf-8", model);

//			EmailSender.send(emailAddr, subject, text, "text/html");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
