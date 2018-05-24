package com.csii.p2p.entity;

import java.util.Date;

public class User {
    private Integer uid;

    private String uphone;

    private String upassword;

    private String invitephone;

    private String email;

    private String nickname;

    private String headsculptureurl;

    private String realname;

    private String idcard;

    private String gesturepassword;

    private Date createdate;

    private Date updatedate;

    private String lastloginip;

    private String deviceid;

    private String logintimer;

    private String remark;

    private Date lastlogindate;

    private String lastloginlocation;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone == null ? null : uphone.trim();
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword == null ? null : upassword.trim();
    }

    public String getInvitephone() {
        return invitephone;
    }

    public void setInvitephone(String invitephone) {
        this.invitephone = invitephone == null ? null : invitephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getHeadsculptureurl() {
        return headsculptureurl;
    }

    public void setHeadsculptureurl(String headsculptureurl) {
        this.headsculptureurl = headsculptureurl == null ? null : headsculptureurl.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getGesturepassword() {
        return gesturepassword;
    }

    public void setGesturepassword(String gesturepassword) {
        this.gesturepassword = gesturepassword == null ? null : gesturepassword.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip == null ? null : lastloginip.trim();
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid == null ? null : deviceid.trim();
    }

    public String getLogintimer() {
        return logintimer;
    }

    public void setLogintimer(String logintimer) {
        this.logintimer = logintimer == null ? null : logintimer.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getLastlogindate() {
        return lastlogindate;
    }

    public void setLastlogindate(Date lastlogindate) {
        this.lastlogindate = lastlogindate;
    }

    public String getLastloginlocation() {
        return lastloginlocation;
    }

    public void setLastloginlocation(String lastloginlocation) {
        this.lastloginlocation = lastloginlocation == null ? null : lastloginlocation.trim();
    }
}