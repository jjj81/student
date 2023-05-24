package com.zut.student.controller;

import java.sql.Date;

import com.zut.student.entity.StudentDoExerciseInfo;
import com.zut.student.mapper.StudentDoExerciseInfoMapper;
import com.zut.student.mapper.UrlAndPowerInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/studentDoExerciseInfo")
public class StudentDoExerciseInfoController {

	@Autowired
	StudentDoExerciseInfoMapper studentDoExerciseInfoMapper;

	@Autowired
	UrlAndPowerInfoMapper urlAndPowerInfoMapper;

	@GetMapping("/{studentId}")
	String getStudentDoExerciseInfo(Model model, @PathVariable("studentId") String studentId) {
		model.addAttribute("allUrl", urlAndPowerInfoMapper.selectAll());
		model.addAttribute("studentId", studentId);
		model.addAttribute("studentDoExerciseInfo", new StudentDoExerciseInfo());
		model.addAttribute("personalDoExerciseInfo",
				studentDoExerciseInfoMapper.searchStudentDoExerciseInfoById(studentId));
		return "doExerciseInfo";
	}

	@PostMapping("/insert/{studentId}")
	String insertStudentDoExerciseInfo(Model model, final StudentDoExerciseInfo studentDoExerciseInfo,
			@PathVariable("studentId") String studentId) {
		if (studentDoExerciseInfo.getDoExerciseEndTime()
				.after(studentDoExerciseInfo.getDoExerciseStartTime()) == false) {
			model.addAttribute("dateError", "开始日期大于结束日期，请修改!!!!!");
			model.addAttribute("allUrl", urlAndPowerInfoMapper.selectAll());
			model.addAttribute("studentId", studentId);
			model.addAttribute("studentDoExerciseInfo", new StudentDoExerciseInfo());
			model.addAttribute("personalDoExerciseInfo",
					studentDoExerciseInfoMapper.searchStudentDoExerciseInfoById(studentId));
			return "doExerciseInfo";
		}
		if (studentDoExerciseInfoMapper.selectByUrlAndAccount(studentDoExerciseInfo.getDoExerciseWebSiteUrl(),
				studentDoExerciseInfo.getDoExerciseWebSiteAccount()) != null) {
			model.addAttribute("infoExist", "该url和account的组合在数据库中已有实例，请勿重复添加");
			model.addAttribute("allUrl", urlAndPowerInfoMapper.selectAll());
			model.addAttribute("studentId", studentId);
			model.addAttribute("studentDoExerciseInfo", new StudentDoExerciseInfo());
			model.addAttribute("personalDoExerciseInfo",
					studentDoExerciseInfoMapper.searchStudentDoExerciseInfoById(studentId));
			return "doExerciseInfo";

		}
		studentDoExerciseInfo.setStudentId(studentId);
		studentDoExerciseInfoMapper.insertStuentDoExerciseInfo(studentDoExerciseInfo);

		model.addAttribute("allUrl", urlAndPowerInfoMapper.selectAll());
		model.addAttribute("studentId", studentId);
		model.addAttribute("studentDoExerciseInfo", new StudentDoExerciseInfo());
		model.addAttribute("personalDoExerciseInfo",
				studentDoExerciseInfoMapper.searchStudentDoExerciseInfoById(studentId));

		return "doExerciseInfo";
	}

	@GetMapping("/delete")
	String deleteStudentDoExercise(@RequestParam("doExerciseWebSiteUrl") String doExerciseWebSiteUrl,
			@RequestParam("doExerciseWebSiteAccount") String doExerciseWebSiteAccount, Model model,
			@RequestParam("studentId") String studentId) {

		studentDoExerciseInfoMapper.deleteStudentDoExerciseInfo(doExerciseWebSiteUrl, doExerciseWebSiteAccount);

		model.addAttribute("allUrl", urlAndPowerInfoMapper.selectAll());
		model.addAttribute("studentId", studentId);
		model.addAttribute("studentDoExerciseInfo", new StudentDoExerciseInfo());
		model.addAttribute("personalDoExerciseInfo",
				studentDoExerciseInfoMapper.searchStudentDoExerciseInfoById(studentId));

		return "doExerciseInfo";
	}

	@PostMapping("/updateStudentComment")
	String updateStudentComment(Model model, @RequestParam("studentId") String studentId,
			@RequestParam("url") String url, @RequestParam("account") String account,
			final StudentDoExerciseInfo studentDoExerciseInfo) {

		studentDoExerciseInfoMapper.updateStudentComment(studentDoExerciseInfo.getStudentComment(), url, account);
		model.addAttribute("allUrl", urlAndPowerInfoMapper.selectAll());
		model.addAttribute("studentId", studentId);
		model.addAttribute("studentDoExerciseInfo", new StudentDoExerciseInfo());
		model.addAttribute("personalDoExerciseInfo",
				studentDoExerciseInfoMapper.searchStudentDoExerciseInfoById(studentId));

		return "doExerciseInfo";
	}

	@PostMapping("/updateSolveNumber")
	String updateSolveNumber(Model model, @RequestParam("studentId") String studentId,
			@RequestParam("url") String url, @RequestParam("account") String account,
			final StudentDoExerciseInfo studentDoExerciseInfo) {
		studentDoExerciseInfoMapper.updateSolveNumber(studentDoExerciseInfo.getSolveExerciseNumber(), url, account);
		model.addAttribute("allUrl", urlAndPowerInfoMapper.selectAll());
		model.addAttribute("studentId", studentId);
		model.addAttribute("studentDoExerciseInfo", new StudentDoExerciseInfo());
		model.addAttribute("personalDoExerciseInfo",
				studentDoExerciseInfoMapper.searchStudentDoExerciseInfoById(studentId));

		return "doExerciseInfo";

	}

	@PostMapping("/updateStartTime")
	String updateStartTime(Model model, @RequestParam("studentId") String studentId,
			@RequestParam("url") String url, @RequestParam("account") String account,
			final StudentDoExerciseInfo studentDoExerciseInfo) {
		Date endTime;
		endTime = studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExerciseEndTime();

		if (studentDoExerciseInfo.getDoExerciseStartTime().before(endTime) == false) {
			model.addAttribute("upTimeError", "开始日期大于结束日期!!!!!");

			model.addAttribute("allUrl", urlAndPowerInfoMapper.selectAll());
			model.addAttribute("studentId", studentId);
			model.addAttribute("studentDoExerciseInfo", new StudentDoExerciseInfo());
			model.addAttribute("personalDoExerciseInfo",
					studentDoExerciseInfoMapper.searchStudentDoExerciseInfoById(studentId));

			return "doExerciseInfo";

		}
		studentDoExerciseInfoMapper.updateStartTime(studentDoExerciseInfo.getDoExerciseStartTime(), url, account);
		model.addAttribute("allUrl", urlAndPowerInfoMapper.selectAll());
		model.addAttribute("studentId", studentId);
		model.addAttribute("studentDoExerciseInfo", new StudentDoExerciseInfo());
		model.addAttribute("personalDoExerciseInfo",
				studentDoExerciseInfoMapper.searchStudentDoExerciseInfoById(studentId));

		return "doExerciseInfo";

	}

	@PostMapping("/updateEndTime")
	String updateEndTime(Model model, @RequestParam("studentId") String studentId,
			@RequestParam("url") String url, @RequestParam("account") String account,
			final StudentDoExerciseInfo studentDoExerciseInfo) {
		Date startTime;
		startTime = studentDoExerciseInfoMapper.selectByUrlAndAccount(url, account).getDoExerciseStartTime();

		if (studentDoExerciseInfo.getDoExerciseEndTime().after(startTime) == false) {
			model.addAttribute("upTimeError", "开始日期大于结束日期!!!!!");

			model.addAttribute("allUrl", urlAndPowerInfoMapper.selectAll());
			model.addAttribute("studentId", studentId);
			model.addAttribute("studentDoExerciseInfo", new StudentDoExerciseInfo());
			model.addAttribute("personalDoExerciseInfo",
					studentDoExerciseInfoMapper.searchStudentDoExerciseInfoById(studentId));

			return "doExerciseInfo";

		}
		studentDoExerciseInfoMapper.updateEndTime(studentDoExerciseInfo.getDoExerciseEndTime(), url, account);
		model.addAttribute("allUrl", urlAndPowerInfoMapper.selectAll());
		model.addAttribute("studentId", studentId);
		model.addAttribute("studentDoExerciseInfo", new StudentDoExerciseInfo());
		model.addAttribute("personalDoExerciseInfo",
				studentDoExerciseInfoMapper.searchStudentDoExerciseInfoById(studentId));

		return "doExerciseInfo";
	}

}
