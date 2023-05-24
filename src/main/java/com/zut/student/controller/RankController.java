package com.zut.student.controller;

import com.zut.student.mapper.ClazzMapper;
import com.zut.student.mapper.StudentInfoMapper;
import com.zut.student.mapper.UrlAndPowerInfoMapper;
import com.zut.student.service.RankService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rank")
public class RankController {

	@Autowired
	private ClazzMapper clazzMapper;

	@Autowired
	private StudentInfoMapper studentInfoMapper;

	@Autowired
	private RankService rankService;

	@Autowired
	private UrlAndPowerInfoMapper urlAndPowerInfoMapper;

	@GetMapping("/{studentId}")
	String getRankPage(Model model, @PathVariable("studentId") String studentId) {
		model.addAttribute("clazz",
				clazzMapper.selectClazzById(studentInfoMapper.searchStudentByStudentId(studentId).getClazzId())
						.getClazz());
		model.addAttribute("rank",
				rankService.mergeTheListByStudentId(rankService.sureTheCompositeSocre(
						rankService.isReviewPass(rankService.selectTheSameClass(
								studentInfoMapper.searchStudentByStudentId(studentId).getClazzId())),
						urlAndPowerInfoMapper.selectAll()),
						studentInfoMapper.selectStudentByClazzId(
								studentInfoMapper.searchStudentByStudentId(studentId).getClazzId())));
		return "rank";
	}
}
