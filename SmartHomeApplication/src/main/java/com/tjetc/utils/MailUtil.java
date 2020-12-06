package com.tjetc.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	public static void sendMail(String to, String title, String content) {
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
		Transport ts;
		try {
			ts = session.getTransport();
			// 3��ʹ��������û��������������ʼ��������������ʼ�ʱ����������Ҫ�ύ������û����������smtp���������û��������붼ͨ����֤֮����ܹ����������ʼ����ռ��ˡ�
			ts.connect("smtp.163.com", "17320038067@163.com", "QHPQFJIAWCUSYPSH");
			// 4�������ʼ�
			Message message = createSimpleMail(session, to, title, content);
			// 5�������ʼ�
			ts.sendMessage(message, message.getAllRecipients());
			ts.close();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @Method: createSimpleMail
	 * @Description: ����һ��ֻ�����ı����ʼ�
	 *
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static MimeMessage createSimpleMail(Session session, String to, String title, String content)
			throws Exception {
		// �����ʼ�����
		MimeMessage message = new MimeMessage(session);
		// ָ���ʼ��ķ�����
		message.setFrom(new InternetAddress("17320038067@163.com"));
		// ָ���ʼ����ռ��ˣ����ڷ����˺��ռ�����һ���ģ��Ǿ����Լ����Լ���
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		// "954028010@qq.com"));
		// �ʼ��ı���
		message.setSubject(title);
		// �ʼ����ı�����
		message.setContent(content, "text/html;charset=UTF-8");
		// ���ش����õ��ʼ�����
		return message;
	}
}
