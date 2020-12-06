package com.tjetc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.tjetc.domain.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//拦截请求，判断请求的用户，是否登录
		//得到session对象
		HttpSession session = request.getSession();
		//得到user对象
		User user = (User)session.getAttribute("user");
		if (user==null) {
			System.out.println("LoginInterceptor.preHandle()....");
			response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
			return false;
		}else {	
			return true;
		}
	}

}
