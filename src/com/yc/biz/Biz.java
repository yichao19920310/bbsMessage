package com.yc.biz;

import java.util.List;

import com.yc.bean.Message;
import com.yc.bean.Pager;
import com.yc.bean.User;


public interface Biz {
	/**
	 * 
	 * @Title: login  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param username
	 * @param password
	 * @return 返回类型User        
	 * @throws
	 */
	User login(String username, String password);

	boolean register(String username, String password, String affirm, String email);

	/**  
	* @Title: getOtherUName  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param id
	* @param @return    参数  
	* @return List<String>    返回类型  
	* @throws  
	*/  
	List<User> getOtherUName(int id);

	/**  
	* @Title: checkUsername  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param username
	* @param @return    参数  
	* @return boolean    返回类型  true代表用户名不存在,可以注册  false代表用户名已存在,不可注册
	* @throws  
	*/  
	boolean checkUsername(String username);

	/**  
	* @Title: sendMsg  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param m 参数   Message对象
	* @return boolean    返回类型  true成功 false失败
	* @throws  
	*/  
	boolean sendMsg(Message m);

	List<Message> getMessageByUser(int receiveId);

	Message getMessageById(int id);

	/**  
	* @Title: showAll  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param receiveId
	* @param @param pager
	* @param @return    参数  
	* @return List<Message>    返回类型  
	* @throws  
	*/  
	List<Message> showAll(int receiveId, Pager pager);

}
