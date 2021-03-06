package com.myplate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import com.myplate.pojo.QueryConsumer;
import com.myplate.service.IMyplateService;
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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	private IUserService userService;
	private Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	private IMyplateService imyplateService;

	@RequestMapping("/userLogin")
	public ModelAndView login(HttpServletRequest request, Model model){
		try {
			String userName = request.getParameter("userName");
			String pwd = request.getParameter("password");
			User u = userService.getUserByUserName(userName);
				if(StringUtils.isEmpty(u.getUserName()) ||StringUtils.isEmpty(u.getPwd()) ){
					throw new Exception("用户名或密码为空！");
				}else if(u.getUserName().equals(userName) && u.getPwd().equals(pwd)){
					request.getSession().setAttribute("userName",u.getUserName());
					request.getSession().setAttribute("id",u.getId());
					if("admin".equals(userName)){
						ModelAndView mv = new ModelAndView();
						List<QueryConsumer> queryList = imyplateService.queryInfo("","","");
						mv.addObject("queryList",queryList);
						mv.setViewName("/admin");
						return mv;
					}
					ModelAndView mv = new ModelAndView();
					mv.setViewName("/buildMenu");
					return mv;
				}else{
					throw new Exception("用户名或密码错误！");
				}
		} catch (Exception e) {
			log.error("登录异常",e);
			request.setAttribute("error_msg",e.getMessage());
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		return mv;
	}
	@RequestMapping(value="/validateUser",method=RequestMethod.POST)
	@ResponseBody
	public boolean validateUser(HttpServletRequest request){
		try {
			String username = request.getParameter("username");
			if(!StringUtils.isEmpty(username)){
				User u = userService.getUserByUserName(username);
				if(u == null){
					return true;
				}else{
					return false;
				}
			}
		} catch (Exception e) {
			log.error("validateUser error",e);
			e.printStackTrace();
		}
		return false;
	}
	@RequestMapping("/toRegisterPage")
	public String toRegisterPage(HttpSession httpSession,String username,String password){
		return "/register";
	}
	@RequestMapping("/register")
	public String register(HttpServletRequest request,HttpSession httpSession,String userName,String password){
		try {
			if(!StringUtils.isEmpty(userName)&& !StringUtils.isEmpty(password)){
				User user = new User();
				user.setUserName(userName);
				user.setPwd(password);
				userService.save(user);
                httpSession.setAttribute("userName",user.getUserName());
                System.out.println(user.getId());
                request.getSession().setAttribute("id",user.getId());
				return "/buildMenu";
			}
		} catch (Exception e) {
			log.error("register error",e);
			e.printStackTrace();
		}
		return "/register";
	}
}
