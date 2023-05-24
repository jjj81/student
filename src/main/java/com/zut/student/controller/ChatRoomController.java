package com.zut.student.controller;

import com.zut.student.entity.ChatInfo;
import com.zut.student.mapper.ChatInfoMapper;
import com.zut.student.mapper.StudentInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/chatRoom")
public class ChatRoomController {
	@Autowired
	private StudentInfoMapper studentInfoMapper;

	@Autowired
	private ChatInfoMapper chatInfoMapper;

	@GetMapping("/{studentId}")
	String inRoom(Model model, @PathVariable("studentId") String studentId) {
		model.addAttribute("chat", new ChatInfo());
		model.addAttribute("message", chatInfoMapper
				.selectChatInfoByClazzId(studentInfoMapper.searchStudentByStudentId(studentId).getClazzId()));
		model.addAttribute("studentId", studentId);
		return "chatRoom";
	}

	@PostMapping("/seedMessage")
	String seedMessage(Model model, @RequestParam("studentId") String studentId, final ChatInfo chatInfo) {
		chatInfo.setUserId(studentId);
		chatInfo.setLineText(chatInfo.getLineText());
		chatInfo.setClazzId(studentInfoMapper.searchStudentByStudentId(studentId).getClazzId());
		chatInfoMapper.insertChatInfo(chatInfo);
		model.addAttribute("chat", new ChatInfo());
		model.addAttribute("message", chatInfoMapper
				.selectChatInfoByClazzId(studentInfoMapper.searchStudentByStudentId(studentId).getClazzId()));

		model.addAttribute("studentId", studentId);

		return "chatRoom";
	}

}
