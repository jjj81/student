package com.zut.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.zut.student.entity.LoginInfo;
import com.zut.student.entity.StudentOrganization;
import com.zut.student.mapper.ClazzMapper;

@Service
public class StudentOrganizationService {

	@Autowired
	private ClazzMapper clazzMapper;

	public List<StudentOrganization> showStudentInfo(List<LoginInfo> stuList) {
		List<StudentOrganization> so = new ArrayList<>();
		for (LoginInfo s : stuList) {
			StudentOrganization studentOrganization = new StudentOrganization();
			studentOrganization.setStudentId(s.getStudentId());
			studentOrganization.setStudentName(s.getStudentName());
			studentOrganization.setClazz(clazzMapper.selectClazzById(s.getClazzId()).getClazz());
			studentOrganization.setFaculty(clazzMapper
					.selectFacultyById(clazzMapper.selectClazzById(s.getClazzId()).getParentId()).getFaculty());
			studentOrganization.setCollege(clazzMapper
					.selectCollegeById2(clazzMapper
							.selectFacultyById(clazzMapper.selectClazzById(s.getClazzId()).getParentId()).getParentId())
					.getCollege());
			so.add(studentOrganization);
		}
		return so;
	}

}
