package com.Project.EasyBuy.User.Util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {
    private String to;
    private String getTo;
    public void Email(){
        try {
            HtmlEmail email = new HtmlEmail();//创建一个HtmlEmail实例对象
            email.setHostName("***");//邮箱的SMTP服务器，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com
            email.setCharset("utf-8");//设置发送的字符类型
            email.addTo("***");//设置收件人
            email.setFrom("****@qq.com", "YeSheng");//发送人的邮箱为自己的，用户名可以随便填
            email.setAuthentication("**", "**");//设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
            email.setSubject("修改密码");//设置发送主题
            email.setMsg("填写你的发送内容");//设置发送内容
            email.send();//进行发送
        } catch (EmailException e) {
            e.printStackTrace();
        }
        return;
    }

}
