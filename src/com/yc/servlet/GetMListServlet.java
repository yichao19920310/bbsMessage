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
import com.yc.bean.Pager;
import com.yc.bean.User;
import com.yc.biz.Biz;
import com.yc.biz.impl.BizImpl;

/**
 * Servlet implementation class GetMListServlet
 */
@WebServlet("/doGetMList")
public class GetMListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * int receiveId = Integer.parseInt(request.getParameter("id")); Biz b =
		 * new BizImpl(); List<Message> mList = b.getMessageByUser(receiveId);
		 * String json = JSON.toJSONString(mList);
		 * response.getWriter().write(json);
		 */
		int receiveId = ((User) (request.getSession().getAttribute("user"))).getId();
		Biz b = new BizImpl();
		// 1.获取当前下标页
		int pageNum = 1;// 默认下标页为第一页
		String page = request.getParameter("page");
		if (page != null && !"".equals(page)) {
			pageNum = Integer.parseInt(page);
		}
		Pager pager = new Pager(pageNum);// 构建一个分页对象Pager
		// 2.调用业务层完成数据的查询
		
		List<Message> mList = b.showAll(receiveId,pager);
		// 7.将page和List存入request域中
		request.setAttribute("mList", mList);
		request.setAttribute("pager", pager);
		// 8.转发至jsp页面显示
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
