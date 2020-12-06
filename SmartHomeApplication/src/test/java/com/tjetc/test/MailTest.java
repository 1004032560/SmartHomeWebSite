package com.tjetc.test;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailTest {

	public static void main(String[] args) throws Exception {
		String title = "网上商城激活";
		String code = "asdf";
		String content = "<h1>购物天堂商城官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://192.168.36.103:8080/shop/user_active.action?code="
	            + code
	            + "'>http://192.168.36.103:8080/shop/user_active.action?code="
	            + code + "</a></h3>";
	    sendMail("17320038067@163.com",title,content);
	  }

	private static void sendMail(String to,String title,String content) throws NoSuchProviderException, MessagingException, Exception {
		Properties prop = new Properties();
	    // 163邮箱设置:
	    prop.setProperty("mail.host", "smtp.163.com");
	    prop.setProperty("mail.transport.protocol", "smtp");
	    prop.setProperty("mail.smtp.auth", "true");
	    // 使用JavaMail发送邮件的5个步骤
	    // 1、创建session
	    Session session = Session.getInstance(prop);
	    // 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
	    session.setDebug(true);
	    // 2、通过session得到transport对象
	    Transport ts = session.getTransport();
	    // 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
	    ts.connect("smtp.163.com", "17320038067@163.com", "QHPQFJIAWCUSYPSH");
	    // 4、创建邮件
	    Message message = createSimpleMail(session,to,title,content);
	    // 5、发送邮件
	    ts.sendMessage(message, message.getAllRecipients());
	    ts.close();
	}

	  /**
	   * @Method: createSimpleMail
	   * @Description: 创建一封只包含文本的邮件
	   *
	   * @param session
	   * @return
	   * @throws Exception
	   */
	  public static MimeMessage createSimpleMail(Session session,String to,String title,String content)
	      throws Exception {
	    // 创建邮件对象
	    MimeMessage message = new MimeMessage(session);
	    // 指明邮件的发件人
	    message.setFrom(new InternetAddress("17320038067@163.com"));
	    // 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
	    message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	    // "954028010@qq.com"));
	    // 邮件的标题
	    message.setSubject(title);
	    // 邮件的文本内容
	    String code = "21222222222";
	    message.setContent(content, "text/html;charset=UTF-8");
	    // 返回创建好的邮件对象
	    return message;
	  }
}
