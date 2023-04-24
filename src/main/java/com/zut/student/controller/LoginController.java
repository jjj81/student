package com.zut.student.controller;

import com.zut.student.entity.LoginInfo;
import com.zut.student.entity.StudentDoExerciseInfo;
import com.zut.student.mapper.RegisterMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
			return "userNotExist";
		}
		if ((encoder.matches(loginInfo.getPassWord(),
				(registerMapper.searchByStudentId(loginInfo.getStudentId())).getPassWord()) == false)) {
			return "passwordError";
		}
		StudentDoExerciseInfo studentDoExerciseInfo = new StudentDoExerciseInfo();
		model.addAttribute("studentDoExerciseInfo", studentDoExerciseInfo);
		return "studentIndex";
	}

	@GetMapping("/studentIndex")
	String returnStuentIndex(Model model) {
		StudentDoExerciseInfo studentDoExerciseInfo = new StudentDoExerciseInfo();
		model.addAttribute("studentDoExerciseInfo", studentDoExerciseInfo);

		return "studentIndex";
	}

}
