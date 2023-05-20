package com.zut.student.controller;

import com.zut.student.entity.LoginInfo;
import com.zut.student.mapper.RegisterMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	@Autowired
	RegisterMapper registerMapper;

	@GetMapping("/login")
	String login(Model model) {
		model.addAttribute("studentInfo", new LoginInfo());
		return "login";
	}

	@PostMapping("/login/confirm")
	String loginInfoConfirm(final LoginInfo loginInfo, Model model) {
		if (registerMapper.searchByStudentId(loginInfo.getStudentId()) == null) {
			model.addAttribute("userNotExist", "学号不存在，请检查是否填错或联系老师添加");
			model.addAttribute("studentInfo", new LoginInfo());
			return "login";

		}
		if ((encoder.matches(loginInfo.getPassWord(),
				(registerMapper.searchByStudentId(loginInfo.getStudentId())).getPassWord()) == false)) {
			model.addAttribute("passWordError", "密码错误");
			model.addAttribute("studentInfo", new LoginInfo());
			return "login";

		}
		model.addAttribute("studentId", loginInfo.getStudentId());
		return "studentIndex";
	}

	@GetMapping("/studentIndex/{studentId}")
	String returnStuentIndex(Model model, @PathVariable("studentId") String studentId) {
		model.addAttribute("studentId", studentId);
		return "studentIndex";
	}

}
