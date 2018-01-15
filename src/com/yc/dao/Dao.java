package com.yc.dao;

import java.sql.SQLException;
import java.util.List;

import com.yc.bean.Message;
import com.yc.bean.User;

public interface Dao {

	User getUserByUsername(String username) throws SQLException;

	boolean register(String username, String password, String email) throws SQLException;

	/**
	 * @throws SQLException   
	* @Title: getOtherUList  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param id
	* @param @return    参数  
	* @return List<String>    返回类型  
	* @throws  
	*/  
	List<User> getOtherUList(int id) throws SQLException;

	/**
	 * @throws SQLException   
	* @Title: sendMsg  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param m
	* @param @return    参数  
	* @return int    返回类型  
	* @throws  
	*/  
	int sendMsg(Message m) throws SQLException;

	List<Message> getMessageByUser(int receiveId) throws SQLException;

	Message getMessageById(int id) throws SQLException;

	/**
	 * @throws SQLException 
	 * @param id   
	* @Title: readMsg  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param     参数  
	* @return void    返回类型  
	* @throws  
	*/  
	void readMsg(int id) throws SQLException;

	/**
	 * @throws SQLException   
	* @Title: getUserById  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param id
	* @param @return    参数  
	* @return User    返回类型  
	* @throws  
	*/  
	User getUserById(int id) throws SQLException;

}
