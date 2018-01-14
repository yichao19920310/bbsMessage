/**  
* @Title: GetUListServlet.java  
* @Package com.yc.servlet  
* @Description: TODO(用一句话描述该文件做什么)  
* @author admin  
* @date 2018年1月10日  
* @version V1.0  
*/  
package com.yc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yc.bean.User;
import com.yc.biz.Biz;
import com.yc.biz.impl.BizImpl;

/**  
* @ClassName: GetUListServlet  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author admin  
* @date 2018年1月10日  
*    
*/
public class GetUListServlet extends HttpServlet {

	/* (非 Javadoc)  
	* <p>Title: doGet</p>  
	* <p>Description: </p>  
	* @param req
	* @param resp
	* @throws ServletException
	* @throws IOException  
	* @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)  
	*/  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//int id = Integer.parseInt(req.getParameter("id"));
		int id = ((User)req.getSession().getAttribute("user")).getId();
		Biz b = new BizImpl();
		List<User> uList = b.getOtherUName(id);
		//System.out.println(uList);
		//req.setAttribute("uList", uList);
		//req.getRequestDispatcher("newMsg.jsp").forward(req, resp);	
		String json = JSON.toJSONString(uList);	
		resp.getWriter().write(json);
	}
	/* (非 Javadoc)  
	* <p>Title: doPost</p>  
	* <p>Description: </p>  
	* @param req
	* @param resp
	* @throws ServletException
	* @throws IOException  
	* @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)  
	*/  
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
