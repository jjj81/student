package com.zut.student.mapper;

import com.zut.student.entity.StudentDoExerciseInfo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.*;

@Mapper
public interface StudentDoExerciseInfoMapper {
    @Insert("insert into studentDoExerciseInfo(studentId,doExerciseWebSiteUrl,doExerciseWebSiteAccount,"
	    + "solveExerciseNumber,doExerciseStartTime,doExerciseEndTime,doExercisePhoto1,"
	    + "doExercisePhoto2,doExercisePhoto3) "
	    + " values (#{studentId},#{doExerciseWebSiteUrl},#{doExerciseWebSiteAccount},"
	    + "#{solveExerciseNumber},#{doExerciseStartTime},#{doExerciseEndTime},#{doExercisePhoto1},"
	    + "#{doExercisePhoto2},#{doExercisePhoto3})")
    void insertStuentDoExerciseInfo(StudentDoExerciseInfo studnetDoExerciseInfo);

    @Select("select * from studentDoExerciseInfo  where  studentId=#{studentId} and doExerciseWebSiteUrl=#{webSiteUrl}")
    List<StudentDoExerciseInfo> searchByIdAndWebSiteUrl(String studentId, String webSiteUrl);

}
