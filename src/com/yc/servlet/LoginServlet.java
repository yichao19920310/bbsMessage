package com.yc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.User;
import com.yc.biz.Biz;
import com.yc.biz.impl.BizImpl;

@WebServlet("/doLogin")
public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	
	public static Biz b = new BizImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(Thread.currentThread().getName()+"执行登陆");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html);charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//Biz b = new BizImpl();
		User u = b.login(username,password);
		if(u!=null){
			System.out.println("用户:"+username+" 登录成功!");
			req.getSession().setAttribute("user", u);
			resp.getWriter().write("OK");
		}else{
			System.out.println("用户:"+username+" 登录失败!");
			resp.getWriter().write("ERROR");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
