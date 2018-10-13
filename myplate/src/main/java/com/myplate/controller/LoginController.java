package com.myplate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import com.myplate.utils.MyPlateException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myplate.pojo.User;
import com.myplate.service.IUserService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	private IUserService userService;
	private Logger log = Logger.getLogger(LoginController.class);

	@RequestMapping("/userLogin")
	public String login(HttpServletRequest request,Model model){
		try {
			String userName = request.getParameter("userName");
			String pwd = request.getParameter("password");
			User u = userService.getUserByUserName(userName);
				if(StringUtils.isEmpty(u.getUserName()) ||StringUtils.isEmpty(u.getPwd()) ){
					throw new Exception("用户名或密码为空！");
				}else if(u.getUserName().equals(userName) && u.getPwd().equals(pwd)){
					request.getSession().setAttribute("userName",u.getUserName());
					if("admin".equals(userName)){
						return "/admin";
					}
					return "/buildMenu";
				}else{
					throw new Exception("用户名或密码错误！");
				}
		} catch (Exception e) {
			log.error("登录异常",e);
			request.setAttribute("error_msg",e.getMessage());
			e.printStackTrace();
		}
		return "/index";
	}
	@RequestMapping(value="/validateUser",method=RequestMethod.POST)
	@ResponseBody
	public boolean validateUser(HttpServletRequest request){
		try {
			String username = request.getParameter("username");
			if(!StringUtils.isEmpty(username)){
				User u = userService.getUserByUserName(username);
				if(u == null){
					return false;
				}else{
					return true;
				}
			}
		} catch (Exception e) {
			log.error("validateUser error",e);
			e.printStackTrace();
		}
		return true;
	}
	@RequestMapping("/toRegisterPage")
	public String toRegisterPage(HttpSession httpSession,String username,String password){
		return "/register";
	}
	@RequestMapping("/register")
	public String register(HttpSession httpSession,String userName,String password){
		try {
			if(!StringUtils.isEmpty(userName)&& !StringUtils.isEmpty(password)){
				User user = new User();
				user.setUserName(userName);
				user.setPwd(password);
				userService.save(user);
                httpSession.setAttribute("userName",user.getUserName());
				return "/buildMenu";
			}
		} catch (Exception e) {
			log.error("register error",e);
			e.printStackTrace();
		}
		return "/register";
	}

}
