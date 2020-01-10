package com.vvv.po;

public class User {
    private Integer id;

    private String loginname;

    private String loginpwd;

    private String nickname;

    private Integer isonline;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd == null ? null : loginpwd.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getIsonline() {
        return isonline;
    }

    public void setIsonline(Integer isonline) {
        this.isonline = isonline;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", isonline=" + isonline + ", loginname="
				+ loginname + ", loginpwd=" + loginpwd + ", nickname="
				+ nickname + "]";
	}
}