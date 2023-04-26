package com.zut.student.controller;

import com.zut.student.entity.LoginInfo;
import com.zut.student.mapper.RegisterMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();   
    
	@Autowired
	RegisterMapper registerMapper;
    
	@GetMapping("/register")
	String register(Model model) {
		model.addAttribute("studentInfo", new LoginInfo());
		return "register";
	}

	@PostMapping("/registerCreate")
	String registerCreate(final LoginInfo registerInfo) {
		if (registerMapper.searchByStudentId(registerInfo.getStudentId()) != null) {
			return "accountBeRegistered";
		}
		registerInfo.setPassWord(encoder.encode(registerInfo.getPassWord())); 
		registerMapper.insertStudentInfo(registerInfo);
		return "registerSuccess";
	}
}
