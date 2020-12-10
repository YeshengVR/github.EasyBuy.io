package com.Project.EasyBuy.User.Entry;

public class User {
    private Number id;//用户id
    private String loginname;//昵称
    private String username;//用户账户
    private String password;
    private Number sex;
    private String identitycode;//身份证
    private String email;
    private String mobile;
    private Number type;
    private String phone;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginname='" + loginname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", identitycode='" + identitycode + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", type=" + type +
                ", phone=" + phone +
                '}';
    }

    public User() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User(Number id, String loginname, String username, String password, Number sex, String identitycode, String email, String mobile, Number type, String phone) {
        this.id = id;
        this.loginname = loginname;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.identitycode = identitycode;
        this.email = email;
        this.mobile = mobile;
        this.type = type;
        this.phone = phone;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Number getSex() {
        return sex;
    }

    public void setSex(Number sex) {
        this.sex = sex;
    }

    public String getIdentitycode() {
        return identitycode;
    }

    public void setIdentitycode(String identitycode) {
        this.identitycode = identitycode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Number getType() {
        return type;
    }

    public void setType(Number type) {
        this.type = type;
    }
}
