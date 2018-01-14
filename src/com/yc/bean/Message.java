/**  
* @Title: Message.java  
* @Package com.yc.bean  
* @Description: TODO(用一句话描述该文件做什么)  
* @author admin  
* @date 2018年1月12日  
* @version V1.0  
*/  
package com.yc.bean;

/**  
* @ClassName: Message  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author admin  
* @date 2018年1月12日  
*    
*/
public class Message {

	private int id;
	private int sendId;
	private String title;
	private String msgContent;
	private int state;
	private int receiveId;
	private String msg_Create_Date;
	public Message(int id, int sendId, String title, String msgContent, int state, int receiveId,
			String msg_Create_Date) {
		super();
		this.id = id;
		this.sendId = sendId;
		this.title = title;
		this.msgContent = msgContent;
		this.state = state;
		this.receiveId = receiveId;
		this.msg_Create_Date = msg_Create_Date;
	}
	public Message() {
		super();
	}
	public Message(int sendId, String title, String msgContent, int receiveId) {
		super();
		this.sendId = sendId;
		this.title = title;
		this.msgContent = msgContent;
		this.receiveId = receiveId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSendId() {
		return sendId;
	}
	public void setSendId(int sendId) {
		this.sendId = sendId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}
	public String getMsg_Create_Date() {
		return msg_Create_Date;
	}
	public void setMsg_Create_Date(String msg_Create_Date) {
		this.msg_Create_Date = msg_Create_Date;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", sendId=" + sendId + ", title=" + title + ", msgContent=" + msgContent
				+ ", state=" + state + ", receiveId=" + receiveId + ", msg_Create_Date=" + msg_Create_Date + "]";
	}
	
}
