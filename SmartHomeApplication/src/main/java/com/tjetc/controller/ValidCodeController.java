package com.tjetc.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tjetc.utils.CodeUtil;

@Controller
public class ValidCodeController {
	
	@RequestMapping("/validCode")
	public void validCode(HttpSession session,HttpServletResponse response) throws IOException {
		// ��ȡ��֤��
		String code = CodeUtil.getCode(4);
		// ����session
		session.setAttribute("code", code);
		// ���ڴ��л���֤�룬������
		int width = 120;
		int height = 25;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		// �õ�����
		Graphics g = image.getGraphics();
		// ������
		g.setColor(Color.blue);
		g.drawRect(0, 0, width, height);
		// �����α���ɫ
		g.setColor(Color.yellow);
		g.fillRect(1, 1, width - 2, height - 2);
		// ��������
		Random random = new Random();
		g.setColor(Color.gray);
		for (int i = 0; i < 8; i++) {
			g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
		}

		// ����֤��
		g.setColor(Color.red);
		g.setFont(new Font("����", Font.BOLD | Font.ITALIC, 18));
		int x = 18;
		for (int i = 0; i < code.length(); i++) {
			g.drawString(code.charAt(i) + "", x, 20);
			x += 22;
		}
		// ����������Ӧͷ����ֹ���������ͼƬ
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		// ���������Ӧ���
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

}
