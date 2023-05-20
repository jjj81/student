
package com.zut.student.mapper;

import com.zut.student.entity.LoginInfo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentInfoMapper {

	@Select("select * from studentLoginInfo where studentId=#{studentId}")
	LoginInfo searchStudentByStudentId(String studentId);

	@Update("update studentLoginInfo set studentName=#{studentName} where studentId=#{studentId}")
	void updateStudentName(String studentName, String studentId);

	@Update("update studentLoginInfo set passWord=#{passWord} where studentId=#{studentId}")
	void updatePassWord(String passWord, String studentId);
}
