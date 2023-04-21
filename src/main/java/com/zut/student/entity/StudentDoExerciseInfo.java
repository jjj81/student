package com.zut.student.entity;

import java.sql.Blob;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class StudentDoExerciseInfo {
	private String doExerciseWebSiteUrl;
	private String doExerciseWebSiteAccount;
	private Integer solveExerciseNumber;
	private Date doExerciseStartTime;
	private Date doExerciseEndTime;
	private Blob doExercisePhoto1; 
	private Blob doExercisePhoto2; 
	private Blob doExercisePhoto3; 
}
