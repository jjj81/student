package com.zut.student.controller;

import com.zut.student.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@GetMapping("/{studentId}")
	String getIndex(Model model, @PathVariable("studentId") String studentId) {
		model.addAttribute("studentId", studentId);
		model.addAttribute("notice", noticeService.canReceiveNotice(studentId));

		return "notice";
	}
}
