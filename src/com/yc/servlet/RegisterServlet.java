package com.yc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.biz.Biz;
import com.yc.biz.impl.BizImpl;

public class RegisterServlet extends HttpServlet{	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -7982047711552798698L;
	public static Biz b = new BizImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(Thread.currentThread().getName()+"执行注册");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html);charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String affirm = req.getParameter("affirm");
		String email = req.getParameter("email");
		if(b.register(username,password,affirm,email)){
			System.out.println("用户:"+username+" 注册成功!");
			resp.sendRedirect("index.jsp");
		}else{
			System.out.println("用户:"+username+" 注册失败!");
			resp.getWriter().write("注册失败!");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
