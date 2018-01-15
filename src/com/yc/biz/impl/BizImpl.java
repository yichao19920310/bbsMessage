package com.yc.biz.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.yc.bean.Message;
import com.yc.bean.User;
import com.yc.biz.Biz;
import com.yc.dao.Dao;
import com.yc.dao.impl.DaoImpl;

public class BizImpl implements Biz{
	private static Dao d = new DaoImpl();
	@Override
	public User login(String username, String password) {
		if(null==username||null==password||username.length()==0||password.length()==0){
			System.out.println("参数为NULL或空!");
			return null;
		}
		User u = null;
		//Dao d = new DaoImpl();
		try {
			u = d.getUserByUsername(username);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		if(u==null){
			System.out.println("用户:"+username+"不存在!");
			return null;
		}
		if(password.equals(u.getPassword())){
			return u;
		}
		System.out.println("用户:"+username+"密码不匹配!");
		return null;
	}
	@Override
	public boolean register(String username, String password, String affirm, String email) {
		if(null==username||null==password||null==affirm||null==email||username.length()==0||password.length()==0||affirm.length()==0||email.length()==0){
			System.out.println("参数为NULL或空!");
			return false;
		}
		User u = null;
		//Dao d = new DaoImpl();
		try {
			u = d.getUserByUsername(username);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		if(u!=null){
			System.out.println("用户:"+username+"已存在!");
			return false;
		}
		if(!password.equals(affirm)){
			System.out.println("两次密码不一致!");
			return false;
		}
		boolean success = false;
		try {
			success = d.register(username,password,email);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		System.out.println(success?"插入数据成功!":"插入数据失败!");
		return success;
	}
	/* (非 Javadoc)  
	* <p>Title: getOtherUName</p>  
	* <p>Description: </p>  
	* @param id
	* @return  
	* @see com.yc.biz.Biz#getOtherUName(int)  
	*/  
	@Override
	public List<User> getOtherUName(int id) {
		List<User> uList = null;
		try {
			uList = d.getOtherUList(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uList;
	}
	/* (非 Javadoc)  
	* <p>Title: checkUsername</p>  
	* <p>Description: </p>  
	* @param username
	* @return  
	* @see com.yc.biz.Biz#checkUsername(java.lang.String)  
	*/  
	@Override
	public boolean checkUsername(String username) {
		User u = null;
		try {
			u = d.getUserByUsername(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(u==null){
			return true;
		}
		return false;
	}
	/* (非 Javadoc)  
	* <p>Title: sendMsg</p>  
	* <p>Description: </p>  
	* @param m
	* @return  
	* @see com.yc.biz.Biz#sendMsg(com.yc.bean.Message)  
	*/  
	@Override
	public boolean sendMsg(Message m) {
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		m.setMsg_Create_Date(date);
		int row = 0;
		try {
			row = d.sendMsg(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(row!=0){
			return true;
		}
		return false;
	}
	@Override
	public List<Message> getMessageByUser(int receiveId) {
		List<Message> mList = null;
		try {
			mList = d.getMessageByUser(receiveId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(mList!=null){
			for (Message m : mList) {
				User u = null;
				try {
					u = d.getUserById(m.getSendId());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				m.setSendUser(u.getUsername());
			}
		}
		return mList;
	}
	@Override
	public Message getMessageById(int id) {
		Message m = null;
		try {
			m = d.getMessageById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(m!=null&&m.getState()==0){
			User u = null;
			try {
				u = d.getUserById(m.getSendId());
				d.readMsg(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(u!=null){
				m.setSendUser(u.getUsername());
			}
		}else{
			User u = null;
			try {
				u = d.getUserById(m.getSendId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(u!=null){
				m.setSendUser(u.getUsername());
			}
		}
		return m;
	}

}
