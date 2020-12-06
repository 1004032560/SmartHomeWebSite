package com.looper;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailTest2 {

	public static void main(String[] args) throws Exception {

	    Properties prop = new Properties();
	    // 163��������:
	    prop.setProperty("mail.host", "smtp.163.com");
	    prop.setProperty("mail.transport.protocol", "smtp");
	    prop.setProperty("mail.smtp.auth", "true");
	    // ʹ��JavaMail�����ʼ���5������
	    // 1������session
	    Session session = Session.getInstance(prop);
	    // ����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬
	    session.setDebug(true);
	    // 2��ͨ��session�õ�transport����
	    Transport ts = session.getTransport();
	    // 3��ʹ��������û��������������ʼ��������������ʼ�ʱ����������Ҫ�ύ������û����������smtp���������û��������붼ͨ����֤֮����ܹ����������ʼ����ռ��ˡ�
	    ts.connect("smtp.163.com", "17320038067@163.com", "QHPQFJIAWCUSYPSH");
	    // 4�������ʼ�
	    Message message = createSimpleMail(session);
	    // 5�������ʼ�
	    ts.sendMessage(message, message.getAllRecipients());
	    ts.close();
	  }

	  /**
	   * @Method: createSimpleMail
	   * @Description: ����һ��ֻ�����ı����ʼ�
	   *
	   * @param session
	   * @return
	   * @throws Exception
	   */
	  public static MimeMessage createSimpleMail(Session session)
	      throws Exception {
	    // �����ʼ�����
	    MimeMessage message = new MimeMessage(session);
	    // ָ���ʼ��ķ�����
	    message.setFrom(new InternetAddress("1004032560@qq.com"));
	    // ָ���ʼ����ռ��ˣ����ڷ����˺��ռ�����һ���ģ��Ǿ����Լ����Լ���
	    message.setRecipient(Message.RecipientType.TO, new InternetAddress(
	        "1004032560@qq.com"));
	    // "954028010@qq.com"));
	    // �ʼ��ı���
	    message.setSubject("���ʼ�");
	    // �ʼ����ı�����
	    String code = "21222222222";
	    message.setContent(
	        "<h1>���������̳ǹٷ������ʼ�!������������ɼ������!</h1><h3><a href='http://192.168.36.103:8080/shop/user_active.action?code="
	            + code
	            + "'>http://192.168.36.103:8080/shop/user_active.action?code="
	            + code + "</a></h3>", "text/html;charset=UTF-8");
	    // ���ش����õ��ʼ�����
	    return message;
	  }
	
}
