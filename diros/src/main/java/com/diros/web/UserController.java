package com.diros.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diros.model.User;
import com.diros.service.UserService;
import com.diros.util.TotalAction;

@Controller
@RequestMapping("/user")
public class UserController extends TotalAction {

	@Resource
	private UserService userService;
	private User user;
	private String msg;
	private String appContext=null; 
	
	private String basePath=null; 
	
	
	private boolean success;

	
	/**
	 * 用户登录
	 * @param user
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(User user, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {
		appContext= request.getContextPath();
		basePath= request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext +"/";
		System.out.println(user);
		try {
			Assert.notNull(user, "不能获取到用户登录信息！");
			Assert.hasText(user.getName(), "用户名不能为空！");
			Assert.hasText(user.getPword(), "密码不能为空！");
			User tmpUser = userService.basicLogin(user);

			if (tmpUser != null) {
				request.getSession().setAttribute("basicUser", tmpUser);
				map.put("message", tmpUser);
				return "redirect:"+basePath;
			}
		request.setAttribute("msg", "用户名或密码错误！");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			logger.debug(e.getMessage());
			return "fail";
		}
		return "redirect:"+basePath;
	}

	/**
	 * 显示用户注册页面
	 * @return
	 */
	@RequestMapping(value = "/showRegister", method = RequestMethod.GET)
	public String showRegister() {
		return "user/register";
	}

	/**
	 * 用户注册
	 * @param user
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/register")
	public String register(User user, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {
			appContext= request.getContextPath();
			basePath= request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext +"/";
		try {

			Assert.notNull(user, "不能获取到用户注册信息！");
			Assert.hasText(user.getName(), "用户名不能为空！");
			Assert.hasText(user.getPword(), "密码不能为空！");
			Assert.hasText(user.getEmail(), "邮件不能为空！");
			Assert.hasText(user.getNickName(), "昵称不能为空！");

			User u=userService.register(user);
			msg = "我们已向你提示的注册邮箱发送了注册激活码，请在48小时内激活。";
			request.setAttribute("msg",msg);
//			msg = "登录成功！";
			success = true;
			if(success && u !=null)
			{
				request.getSession().setAttribute("basicUser", u);
			}
		} catch (Exception e) {
			msg = e.getMessage();
			request.setAttribute("msg",msg);
			logger.debug(e.getMessage());
			return "fail";
		}
		
		return "redirect:"+basePath;
	}

	/**
	 * 注册激活
	 * @return
	 */
	@RequestMapping(value = "/registerActivation", method = RequestMethod.GET)
	public String registerActivation(HttpServletRequest request,HttpServletResponse response) {
		try {
			String username = request.getParameter("username");
			String validateCode = request.getParameter("validateCode");
			
			Assert.hasText(username, "用户名不能为空！");
			Assert.hasText(validateCode, "检验码不能为空！");
			
			userService.registerActivation(username , validateCode);
			
			msg = username + "成功激活！";
			request.setAttribute("msg",msg);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
	}
	
	/**
	 * 显示修改用户密码页面
	 * @return
	 */
	@RequestMapping(value = "/showModifyPassword", method = RequestMethod.GET)
	public String showModifyPassword() {
		return "user/modifyPassword";
	}
	
	/**
	 * 修改用户密码
	 * @param user
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/modifyPassword")
	public String modifyPassword(User user, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			
			Assert.hasText(oldPassword, "原密码不能为空！");
			Assert.hasText(newPassword, "新密码不能为空！");
			
			Object object = request.getSession().getAttribute("basicUser");
			Assert.notNull(object, "无法获取到当前用户信息，请重新登录！");
			
			User currentUser = (User) object;
			
			userService.modifyPassword(currentUser, oldPassword, newPassword);
			request.setAttribute("msg","密码修改成功！");
			success = true;
		} catch (Exception e) {
			msg = e.getMessage();
			request.setAttribute("msg", e.getMessage());
			return "fail";
		}
		return "success";
	}
	
	/**
	 * 显示输入用户名页面，以找回密码
	 * @return
	 */
	@RequestMapping(value = "/showInputUserName", method = RequestMethod.GET)
	public String showInputUserName() {
		return "user/inputUserName";
	}
	
	/**
	 * 发送邮件以找回密码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sendEmailForPassword")
	public String sendEmailForPassword(HttpServletRequest request,
			HttpServletResponse response){
		String name = request.getParameter("name");
		Assert.hasText(name, "用户名不能为空！");
		
		try {
			userService.sendEmailForPassword(name);
			msg = "我们已向你注册时提供的邮箱地址发送了找回密码的检验信息，请尽快登录邮箱处理。";
			request.setAttribute("msg", msg);
		} catch (Exception e) {
			msg = e.getMessage();
			request.setAttribute("msg", e.getMessage());
			return "fail";
		}
		return "success";
	}
	
	/**
	 * 显示找回密码页面
	 * @return
	 */
	@RequestMapping(value = "/showFindPassword", method = RequestMethod.GET)
	public String showFindPassword(HttpServletRequest request,HttpServletResponse response) {
		try {
			String username = request.getParameter("username");
			String validateCode = request.getParameter("validateCode");
			
			Assert.hasText(username, "用户名不能为空！");
			Assert.hasText(validateCode, "检验码不能为空！");
			
			request.setAttribute("username", username);
			request.setAttribute("validateCode", validateCode);
			
			return "user/findPassword";
		} catch (Exception e) {
			// TODO: handle exception
			return "fail";
		}
	}
	
	/**
	 * 找回用户密码
	 * @param user
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findPassword")
	public String findPassword(User user, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			String username = request.getParameter("username");
			String validateCode = request.getParameter("validateCode");
			String newPassword = request.getParameter("newPassword");
			
			Assert.hasText(username, "用户名不能为空！");
			Assert.hasText(validateCode, "检验码不能为空！");
			Assert.hasText(newPassword, "新密码不能为空！");
			
			userService.findPassword(username, validateCode, newPassword);
			request.setAttribute("msg","密码设置成功！");
			success = true;
		} catch (Exception e) {
			msg = e.getMessage();
			request.setAttribute("msg", msg);
			logger.debug(e.getMessage());
			return "fail";
		}
		return "success";
	}
	
	/**
	 * 检验用户名是否可用于注册
	 * 
	 * @return
	 */
	@RequestMapping(value = "/isUserNameAvailable")
	public String isUserNameAvailable(String name) {
		Assert.hasText(name, "用户名不能为空！");
		boolean flag = false;
		try {
			flag = userService.isUserNameAvailable(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		// FIXME 通过json 形式返回数据
		return "success";
	}
	
	@RequestMapping(value = "/userInfo")
	public String getUserInfo(HttpServletRequest request,
			HttpServletResponse response) {
		User user = null;
		HttpSession session = request.getSession();
		if (session.getAttribute("basicUser") != null) {
			user = (User) session.getAttribute("basicUser");
			user.setPword(null);
		}
		return "user/userInfo";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {
		appContext= request.getContextPath();
		basePath= request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext +"/";
		request.getSession().invalidate();
		this.clear();
		return "redirect:"+basePath;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 清理用户信息
	 */
	private void clear() {
		user = null;
	}

}
