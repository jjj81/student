package com.zut.student.controller;

import com.zut.student.entity.StudentDoExerciseInfo;
import com.zut.student.mapper.StudentDoExerciseInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/studentDoExerciseInfo")
public class StudentDoExerciseInfoController {

	@Autowired
	StudentDoExerciseInfoMapper studentDoExerciseInfoMapper;

	@GetMapping("/insert")
	String getStudentDoExerciseInfo(Model model) {
		model.addAttribute("studentDoExerciseInfo", new StudentDoExerciseInfo());
		return "insertStudentDoExerciseInfo";
	}

	@PostMapping("/insert")
	String insertStudentDoExerciseInfo(final StudentDoExerciseInfo studentDoExerciseInfo) {
		studentDoExerciseInfoMapper.insertStuentDoExerciseInfo(studentDoExerciseInfo);
		return "insertStudentDoExerciseSuccess";
	}
}
