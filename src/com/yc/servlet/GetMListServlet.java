package com.yc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yc.bean.Message;
import com.yc.biz.Biz;
import com.yc.biz.impl.BizImpl;

/**
 * Servlet implementation class GetMListServlet
 */
@WebServlet("/doGetMList")
public class GetMListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int receiveId = Integer.parseInt(request.getParameter("id"));
		Biz b = new BizImpl();
		List<Message> mList = b.getMessageByUser(receiveId);
		String json = JSON.toJSONString(mList);
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
