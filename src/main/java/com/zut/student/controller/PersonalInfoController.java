package com.zut.student.controller;

import com.zut.student.entity.LoginInfo;
import com.zut.student.mapper.StudentInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personalInfo")
public class PersonalInfoController {
	BCryptPasswordEncoder bcRCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private StudentInfoMapper studentInfoMapper;

	@GetMapping("/{studentId}")
	String getStudentPersonalInfoPage(Model model, @PathVariable("studentId") String studentId) {
		model.addAttribute("studentPersonalInfo", studentInfoMapper.searchStudentByStudentId(studentId));
		model.addAttribute("studentId", studentId);
		return "personalInfo";
	}

	@PostMapping("/updateName/{studentId}")
	String updateStudentName(@PathVariable("studentId") String studentId, Model model,
			final LoginInfo studentPersonalInfo) {
		studentInfoMapper.updateStudentName(studentPersonalInfo.getStudentName(), studentId);
		model.addAttribute("studentPersonalInfo", studentInfoMapper.searchStudentByStudentId(studentId));
		model.addAttribute("studentId", studentId);
		return "personalInfo";
	}

	@PostMapping("/updatePassWord/{studentId}")
	String updatePassWord(@PathVariable("studentId") String studentId, Model model,
			final LoginInfo studentPersonalInfo) {
		studentInfoMapper.updatePassWord(bcRCryptPasswordEncoder.encode(studentPersonalInfo.getPassWord()), studentId);
		model.addAttribute("studentId", studentId);
		return "changePassWordSuccess";
	}

}
