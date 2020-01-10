package com.vvv.po;

import java.util.Date;

public class Message {
    private Integer id;

    private Date createtime;

    private Integer userid;

    private String contents;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }

	@Override
	public String toString() {
		return "Message [contents=" + contents + ", createtime=" + createtime
				+ ", id=" + id + ", userid=" + userid + "]";
	}
}