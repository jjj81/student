package com.zut.student.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.*;

import com.zut.student.entity.Notice;

@Mapper
public interface NoticeMapper {

	@Select("select * from notice where teacherId=#{teacherId}")
	List<Notice> selectNoticeByTeacherId(String teacherId);
}
