package com.zut.student.mapper;

import com.zut.student.entity.StudentDoExerciseInfo;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;

@Mapper
public interface StudentDoExerciseInfoMapper {
	@Insert("insert into studentDoExerciseInfo(studentId,doExerciseWebSiteUrl,doExerciseWebSiteAccount, solveExerciseNumber,doExerciseStartTime,doExerciseEndTime) values(#{studentId},#{doExerciseWebSiteUrl},#{doExerciseWebSiteAccount},#{solveExerciseNumber},#{doExerciseStartTime},#{doExerciseEndTime})")
	void insertStuentDoExerciseInfo(StudentDoExerciseInfo studnetDoExerciseInfo);

	@Select("select * from studentDoExerciseInfo  where  studentId=#{studentId} ")
	List<StudentDoExerciseInfo> searchStudentDoExerciseInfoById(String studentId);

	@Select("select * from studentDoExercisInfo  where doExerciseWebSiteUrl=#{doExerciseWebSiteUrl} and doExerciseWebSiteAccount=#{doExerciseWebSiteAccount}")
	StudentDoExerciseInfo selectDoExerciseByUrlAndAccount(String doExerciseWebSiteUrl, String doExerciseWebSiteAccount);
    
	@Delete("delete from studentDoExerciseInfo where doExerciseWebSiteUrl=#{doExerciseWebSiteUrl} and doExerciseWebSiteAccount=#{doExerciseWebSiteAccount}")
	void deleteStudentDoExerciseInfo(String doExerciseWebSiteUrl, String doExerciseWebSiteAccount);

	@Update("update studentDoExerciseInfo set doExercisePhoto1=#{image1} where doExerciseWebSiteUrl=#{doExerciseWebSiteUrl} and doExerciseWebSiteAccount=#{doExerciseWebSiteAccount}")
	void updateImage(String image1, String doExerciseWebSiteUrl, String doExerciseWebSiteAccount);

	@Select("select * from studentDoExerciseInfo where doExerciseWebSiteUrl=#{doExerciseWebSiteUrl} and doExerciseWebSiteAccount=#{doExerciseWebSiteAccount}")
	StudentDoExerciseInfo selectByUrlAndAccount(String doExerciseWebSiteUrl, String doExerciseWebSiteAccount);

	@Update("update studentDoExerciseInfo set doExercisePhoto2=#{image} where doExerciseWebSiteUrl=#{doExerciseWebSiteUrl} and doExerciseWebSiteAccount=#{doExerciseWebSiteAccount}")
	void updateImage2(String image, String doExerciseWebSiteUrl, String doExerciseWebSiteAccount);

	@Update("update studentDoExerciseInfo set doExercisePhoto3=#{image} where doExerciseWebSiteUrl=#{doExerciseWebSiteUrl} and doExerciseWebSiteAccount=#{doExerciseWebSiteAccount}")
	void updateImage3(String image, String doExerciseWebSiteUrl, String doExerciseWebSiteAccount);

	@Update("update studentDoExerciseInfo set doExercisePhoto4=#{image} where doExerciseWebSiteUrl=#{doExerciseWebSiteUrl} and doExerciseWebSiteAccount=#{doExerciseWebSiteAccount}")
	void updateImage4(String image, String doExerciseWebSiteUrl, String doExerciseWebSiteAccount);

	@Update("update studentDoExerciseInfo set doExercisePhoto5=#{image} where doExerciseWebSiteUrl=#{doExerciseWebSiteUrl} and doExerciseWebSiteAccount=#{doExerciseWebSiteAccount}")
	void updateImage5(String image, String doExerciseWebSiteUrl, String doExerciseWebSiteAccount);

	@Update("update studentDoExerciseInfo set studentComment=#{studentComment} where doExerciseWebSiteUrl=#{doExerciseWebSiteUrl} and doExerciseWebSiteAccount=#{doExerciseWebSiteAccount}")
	void updateStudentComment(String studentComment, String doExerciseWebSiteUrl, String doExerciseWebSiteAccount);

	@Update("update studentDoExerciseInfo set solveExerciseNumber=#{number}   where doExerciseWebSiteUrl=#{doExerciseWebSiteUrl} and doExerciseWebSiteAccount=#{doExerciseWebSiteAccount}")
	int updateSolveNumber(Integer number, String doExerciseWebSiteUrl, String doExerciseWebSiteAccount);

	@Update("update studentDoExerciseInfo set doExerciseStartTime=#{time}   where doExerciseWebSiteUrl=#{doExerciseWebSiteUrl} and doExerciseWebSiteAccount=#{doExerciseWebSiteAccount}")
	int updateStartTime(Date time, String doExerciseWebSiteUrl, String doExerciseWebSiteAccount);

	@Update("update studentDoExerciseInfo set doExerciseEndTime=#{time}   where doExerciseWebSiteUrl=#{doExerciseWebSiteUrl} and doExerciseWebSiteAccount=#{doExerciseWebSiteAccount}")
	int updateEndTime(Date time, String doExerciseWebSiteUrl, String doExerciseWebSiteAccount);

}
