package com.yc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Message;
import com.yc.bean.User;
import com.yc.biz.Biz;
import com.yc.biz.impl.BizImpl;

/**
 * Servlet implementation class SendMsgServlet
 */
@WebServlet("/doSendMsg")
public class SendMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sendId = ((User)(request.getSession().getAttribute("user"))).getId();
		String title = request.getParameter("title");
		String msgContent = request.getParameter("content");
		int receiveId = Integer.parseInt(request.getParameter("toUser"));
		Message m = new Message(sendId,title,msgContent,receiveId);
		Biz b = new BizImpl();
		if(b.sendMsg(m)){
			request.setAttribute("sendMsg", true);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else{
			request.setAttribute("sendMsg", false);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
