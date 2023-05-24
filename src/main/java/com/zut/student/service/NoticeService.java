package com.zut.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.zut.student.entity.Notice;
import com.zut.student.entity.TeacherPowerToClass;
import com.zut.student.mapper.NoticeMapper;
import com.zut.student.mapper.StudentInfoMapper;
import com.zut.student.mapper.TeacherPowerToClassMapper;

@Service
public class NoticeService {

	@Autowired
	private StudentInfoMapper studentInfoMapper;

	@Autowired
	private TeacherPowerToClassMapper teacherPowerToClassMapper;

	@Autowired
	private NoticeMapper noticeMapper;

	public List<Notice> canReceiveNotice(String studentId) {
		List<Notice> notice = new ArrayList<>();
		for (TeacherPowerToClass t : teacherPowerToClassMapper.selectTeacherPowerByClazzId(
				studentInfoMapper.searchStudentByStudentId(studentId).getClazzId())) {
			for (Notice n : noticeMapper.selectNoticeByTeacherId(t.getTeacherId())) {
				notice.add(n);
			}
		}

		return notice;
	}
}
