package com.myplate.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Program Name:
 * author :john
 * Date:2018-10-2018/10/10  21:21  星期三
 * version 1.0
 */
public class UserRoleAuthorizationInterceptor implements HandlerInterceptor {
    //不拦截"/loginForm"和"/login"请求
    private static final String[] IGNORE_URI = {"/register", "/login_bgimg", "/userLogin"};

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {


        if("GET".equalsIgnoreCase(request.getMethod())){
            //RequestUtil.saveRequest();
        }
        System.out.println("preHandle...");
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                break;
            }
        }
        System.out.println("requestUri" + requestUri);
        System.out.println("contextPath" + contextPath);
        System.out.println("url" + url);
        String username = (String) request.getSession().getAttribute("username");
        if(null == username){
            request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
            return false;
        }
        else{
            return true;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
        if(modelAndView != null){
            Map<String, String> map = new HashMap<String, String>();
            modelAndView.addAllObjects(map);
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion...");
    }
}
