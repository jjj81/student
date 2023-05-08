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

@Controller
@RequestMapping("/chatRoom")
public class ChatRoomController {
	@Autowired
	private StudentInfoMapper studentInfoMapper;

	@Autowired
	private ChatInfoMapper chatInfoMapper;
	@GetMapping("/{studentId}")
	String getIndex(Model model, @PathVariable("studentId") String studentId) {
		model.addAttribute("chatRecordList", chatInfoMapper.selectAllChatInfo());
		model.addAttribute("className", studentInfoMapper.searchStudentByStudentId(studentId).getClassName());
		model.addAttribute("chatInfo", new ChatInfo());
		return "chatRoom";
	}

	@PostMapping("/insert/{studentId}")
	String insertChatInfo(@PathVariable("studentId") String studentId, Model model, final ChatInfo chatInfo) {
		chatInfoMapper.insertChatInfo(studentId, chatInfo.getLineText());
		model.addAttribute("chatRecord", chatInfoMapper.selectAllChatInfo());
		model.addAttribute("className", studentInfoMapper.searchStudentByStudentId(studentId).getClassName());
		model.addAttribute("chatInfo", new ChatInfo());
		return "chatRoom";
	}

}
