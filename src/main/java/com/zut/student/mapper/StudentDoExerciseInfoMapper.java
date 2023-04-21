package com.zut.student.mapper;

import com.zut.student.entity.StudentDoExerciseInfo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDoExerciseInfoMapper {
	@Insert("insert into studentDoExerciseInfo(doExerciseWebSiteUrl,doExerciseWebSiteAccount,"
			+ "solveExerciseNumber,doExerciseStartTime,doExerciseEndTime,doExercisePhoto1,"
			+ "doExercisePhoto2,doExercisePhoto3) "
			+ " values (#{doExerciseWebSiteUrl},#{doExerciseWebSiteAccount},"
			+ "#{solveExerciseNumber},#{doExerciseStartTime},#{doExerciseEndTime},#{doExercisePhoto1},"
			+ "#{doExercisePhoto2},#{doExercisePhoto3})")
	void insertStuentDoExerciseInfo(StudentDoExerciseInfo stuDoExerciseInfo);

}
