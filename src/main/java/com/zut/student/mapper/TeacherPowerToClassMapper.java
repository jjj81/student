package com.zut.student.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.*;

import com.zut.student.entity.TeacherPowerToClass;

@Mapper
public interface TeacherPowerToClassMapper {
	@Select("select * from teacherPowerToClass where teacherId=#{teacherId}")
	List<TeacherPowerToClass> searchTeacherPowerToClassById(String teacherId);

	@Select("select * from teacherPowerToClass where teacherId=#{teacherId} and clazzId=#{clazzId}")
	TeacherPowerToClass searchByTidAndCid(String teacherId, Integer clazzId);

	@Select("select * from teacherPowerToClass where clazzId=#{clazzId}")
	List<TeacherPowerToClass> selectTeacherPowerByClazzId(Integer clazzId);
}
