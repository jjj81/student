package com.zut.student.mapper;

import com.zut.student.entity.LoginInfo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegisterMapper {
	@Insert("insert into studentLoginInfo(studentId,passWord) values(#{studentId},#{passWord})")
	void insertStudentInfo(LoginInfo loginInfo);

	@Select("select * from studentLoginInfo where studentId=#{id}")
	LoginInfo searchByStudentId(String id);

}
