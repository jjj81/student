
package com.zut.student.mapper;

import com.zut.student.entity.LoginInfo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentInfoMapper {

	@Select("select * from studentLoginInfo where studentId=#{studentId}")
	LoginInfo searchStudentByStudentId(String studentId);
}
