package com.tjetc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tjetc.domain.User;
import com.tjetc.service.UserService;
import com.tjetc.utils.MailUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/validLoginUsername")
	@ResponseBody
	public Map<String, Boolean> validLoginUsername(String username) {
		User user = userService.getByUsername(username);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (user!=null) {
			map.put("valid", true);
		}else {
			map.put("valid", false);
		}
		return map;
	}

	@RequestMapping("/validPassword")
	@ResponseBody
	public Map<String, Boolean> validPassword(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		User user = userService.getByUsername(username);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (user.getPassword().equals(password)) {
			map.put("valid", true);
		}else {
			map.put("valid", false);
		}
		return map;
	}

	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session,Model model) {
		User user = userService.getByUsername(username);
		if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
			if (user.getState()==1) {
				String msg = "��!���½ע������"+user.getEmail()+"���ռ�����Ϣ�����˺�";
				model.addAttribute("msg",msg);
				return "jsp/userValid";
			}else {
				session.setAttribute("user", user);
				return "index";
			}
		} else {
			return "redirect:/jsp/login.jsp";
		}
	}

	@RequestMapping("/quit")
	public String quit(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "index";
	}

	@RequestMapping("/validUsername")
	@ResponseBody
	public Map<String, Boolean> validUsername(String username) {
		User user = userService.getByUsername(username);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (user==null) {
			map.put("valid", true);
		}else {
			map.put("valid", false);
		}
		return map;
	}

	@RequestMapping("/validCode")
	@ResponseBody
	public Map<String, Boolean> validCode(HttpSession session, String checkcode) {
		String code = (String) session.getAttribute("code");
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		if (code.equalsIgnoreCase(checkcode)) {
			map.put("valid", true);
		}else {
			map.put("valid", false);
		}
		return map;
	}

	@RequestMapping("/regist")
	public String regist(User user, HttpSession session, Model model) {
		// ���ʼ�
		// �ռ���
		String email = user.getEmail();
		String code = (String) session.getAttribute("code");
		String projectName = "SmartFurniture";
		String title = projectName + "�˻�����";
		String local = "SmartHomeProject";
		String content = "<h1>"+ projectName +"�ٷ������ʼ�!������������ɼ������!</h1>" +
				"<h3>" +
					"<a href='http://localhost:8080/"+local+"/user/active?code=" + code + "'>" +
						"http://localhost:8080/"+local+"/user/active?code=" + code +
					"</a>" +
				"</h3>";
		MailUtil.sendMail(email, title, content);
		user.setState(1);// δ����
		user.setCode(code);// ������֤��
		userService.add(user);
		String msg = "��!���½ע������"+user.getEmail()+"���ռ�����Ϣ�����˺�";
		model.addAttribute("msg",msg);
		return "jsp/userValid";
	}

	@RequestMapping("/active")
	public String active(String code) {
		userService.active(code);
		return "jsp/active";
	}
}
