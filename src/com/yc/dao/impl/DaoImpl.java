package com.yc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.yc.tools.JDBCUtils;
import com.yc.bean.Message;
import com.yc.bean.User;
import com.yc.dao.Dao;

public class DaoImpl implements Dao{

	@Override
	public User getUserByUsername(String username) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
		return run.query(sql, new BeanHandler<>(User.class),username);
		
	}

	@Override
	public boolean register(String username, String password, String email) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "INSERT INTO USERS VALUES(SEQ_USERS.nextval,?,?,?)";
		int row = 0;
		row=run.update(sql,username,password,email);
		if(row==1){
			return true;
		}
		return false;
	}

	/* (非 Javadoc)  
	* <p>Title: getOtherUList</p>  
	* <p>Description: </p>  
	* @param id
	* @return  
	* @see com.yc.dao.Dao#getOtherUList(int)  
	*/  
	@Override
	public List<User> getOtherUList(int id) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT ID,USERNAME FROM USERS WHERE ID != ?";
		
		return run.query(sql, new BeanListHandler<>(User.class),id);
	}

	/* (非 Javadoc)  
	* <p>Title: sendMsg</p>  
	* <p>Description: </p>  
	* @param m
	* @return  
	* @see com.yc.dao.Dao#sendMsg(com.yc.bean.Message)  
	*/  
	@Override
	public int sendMsg(Message m) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "insert into messages (id,sendid,title,msgcontent,state,receiveid,msg_create_date) "
				+ "values(seq_message.nextval,?,?,?,0,?,?)";
		
		return run.update(sql, m.getSendId(),m.getTitle(),m.getMsgContent(),m.getReceiveId(),m.getMsg_Create_Date());
	}

	@Override
	public List<Message> getMessageByUser(int receiveId) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "select * from messages where receiveId = ?";
		return run.query(sql, new BeanListHandler<>(Message.class),receiveId);
	}

	@Override
	public Message getMessageById(int id) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "select * from messages where id = ?";
		return run.query(sql, new BeanHandler<>(Message.class),id);
	}

	/* (非 Javadoc)  
	* <p>Title: readMsg</p>  
	* <p>Description: </p>    
	* @see com.yc.dao.Dao#readMsg()  
	*/  
	@Override
	public void readMsg(int id) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "update messages set state = 1 where id = ?";
		run.update(sql,id);
		
	}

	/* (非 Javadoc)  
	* <p>Title: getUserById</p>  
	* <p>Description: </p>  
	* @param id
	* @return  
	* @see com.yc.dao.Dao#getUserById(int)  
	*/  
	@Override
	public User getUserById(int id) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "select * from users where id = ?";
		return run.query(sql, new BeanHandler<>(User.class),id);
	}

	/* (非 Javadoc)  
	* <p>Title: queryCount</p>  
	* <p>Description: </p>  
	* @param receiveId
	* @return  
	* @see com.yc.dao.Dao#queryCount(int)  
	*/  
	@Override
	public int queryCount(int receiveId) throws SQLException {
		int count = -1;
		//贾琏
		Connection conn = JDBCUtils.getConnection();
		String sql = "SELECT COUNT(ID) FROM Messages where receiveid = ?";
		//欲
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, receiveId);
		//执
		ResultSet rs = ps.executeQuery();
		//事
		if(rs.next()){
			count = rs.getInt(1);
		}
		//毙
		rs.close();
		ps.close();
		conn.close();
		return count;
	}

	/* (非 Javadoc)  
	* <p>Title: queryList</p>  
	* <p>Description: </p>  
	* @param receiveId
	* @param start
	* @param end
	* @return
	* @throws SQLException  
	* @see com.yc.dao.Dao#queryList(int, int, int)  
	*/  
	@Override
	public List<Message> queryList(int receiveId, int start, int end) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT * FROM("
				+ "SELECT ROWNUM R,MESSAGES.* "
				+ "FROM MESSAGES WHERE RECEIVEID = ?) T "
				+ "WHERE T.R>? AND T.R<=?";
		List<Message> list = run.query(sql, 
				new BeanListHandler<>(Message.class),
				receiveId,start,end);
		return list;
	}

}
