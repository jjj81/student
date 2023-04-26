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

	@GetMapping("/get")
	String getStudentDoExerciseInfo(Model model) {
		model.addAttribute("studentDoExerciseInfo", new StudentDoExerciseInfo());
		return "insertStudentDoExerciseInfo";
	}

	@PostMapping("/insert")
	String insertStudentDoExerciseInfo(final StudentDoExerciseInfo studentDoExerciseInfo) {
		if (studentDoExerciseInfo.getDoExerciseEndTime()
		    .after(studentDoExerciseInfo.getDoExerciseStartTime()) == false)
			return "studentDoExerciseInfoTimeError";
		if (studentDoExerciseInfo.getSolveExerciseNumber() < 0)
			return "studentDoExerciseInfoSolveNumberError";
		studentDoExerciseInfoMapper.insertStuentDoExerciseInfo(studentDoExerciseInfo);
		return "insertStudentDoExerciseSuccess";
	}

	@PostMapping("/searchByIdAndUrl")
	String searchByIdAndUrl(Model model, StudentDoExerciseInfo studentDoExerciseInfo) {
		model.addAttribute("searchList", studentDoExerciseInfoMapper.searchByIdAndWebSiteUrl(
				studentDoExerciseInfo.getStudentId(), studentDoExerciseInfo.getDoExerciseWebSiteUrl()));
		return "studentDoExerciseInfoSearchByIdAndUrl";
	}
}
