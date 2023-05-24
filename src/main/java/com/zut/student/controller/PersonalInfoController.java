package com.zut.student.controller;

import com.zut.student.entity.LoginInfo;
import com.zut.student.entity.PassWord;
import com.zut.student.mapper.StudentInfoMapper;
import com.zut.student.service.StudentOrganizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/personalInfo")
public class PersonalInfoController {
	BCryptPasswordEncoder bcRCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private StudentInfoMapper studentInfoMapper;

	@Autowired
	private StudentOrganizationService studentOrganizationService;

	@GetMapping("/{studentId}")
	String getStudentPersonalInfoPage(Model model, @PathVariable("studentId") String studentId) {
		model.addAttribute("studentInfo",
				studentOrganizationService.showStudentInfo(studentInfoMapper.searchStudentByStudentId2(studentId)));
		model.addAttribute("studentId", studentId);
		model.addAttribute("loginInfo", new LoginInfo());

		model.addAttribute("passWord", new PassWord());

		return "personalInfo";
	}

	@PostMapping("/updateName")
	String updateName(Model model, @RequestParam("studentId") String studentId, final LoginInfo loginInfo) {

		studentInfoMapper.updateStudentName(loginInfo.getStudentName(), studentId);
		model.addAttribute("studentInfo",
				studentOrganizationService.showStudentInfo(studentInfoMapper.searchStudentByStudentId2(studentId)));
		model.addAttribute("studentId", studentId);
		model.addAttribute("loginInfo", new LoginInfo());
		model.addAttribute("passWord", new PassWord());

		return "personalInfo";
	}

	@PostMapping("/updatePassWord")
	String updatePassWord(Model model, @RequestParam("studentId") String studentId, final PassWord passWord) {

		if (bcRCryptPasswordEncoder.matches(passWord.getOriginalPassWord(),
				studentInfoMapper.searchStudentByStudentId(studentId).getPassWord()) == false) {

			model.addAttribute("originalError", "原密码错误");
			model.addAttribute("studentInfo",
					studentOrganizationService.showStudentInfo(studentInfoMapper.searchStudentByStudentId2(studentId)));
			model.addAttribute("studentId", studentId);
			model.addAttribute("loginInfo", new LoginInfo());

			model.addAttribute("passWord", new PassWord());

			return "personalInfo";

		}
		if (passWord.getNewPassWord().equals(passWord.getConfirmNew()) == false) {
			model.addAttribute("confirmError", "两次密码输入不匹配");
			model.addAttribute("studentInfo",
					studentOrganizationService.showStudentInfo(studentInfoMapper.searchStudentByStudentId2(studentId)));
			model.addAttribute("studentId", studentId);
			model.addAttribute("loginInfo", new LoginInfo());

			model.addAttribute("passWord", new PassWord());

			return "personalInfo";

		}
		studentInfoMapper.updatePassWord(bcRCryptPasswordEncoder.encode(passWord.getNewPassWord()), studentId);
		model.addAttribute("updatePWSuccess", "修改密码成功");
		model.addAttribute("studentInfo",
				studentOrganizationService.showStudentInfo(studentInfoMapper.searchStudentByStudentId2(studentId)));
		model.addAttribute("studentId", studentId);
		model.addAttribute("loginInfo", new LoginInfo());

		model.addAttribute("passWord", new PassWord());

		return "personalInfo";
	}

}
