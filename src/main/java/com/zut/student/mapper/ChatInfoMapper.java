package com.zut.student.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;

import com.zut.student.entity.ChatInfo;

@Mapper
public interface ChatInfoMapper {

	@Insert("insert into chatRoom(userId,lineText,clazzId) values(#{userId},#{lineText},#{clazzId})")
	void insertChatInfo(ChatInfo chatInfo);

	@Select("select * from chatRoom  where clazzId=#{clazzId}")
	List<ChatInfo> selectChatInfoByClazzId(Integer clazzId);
}
