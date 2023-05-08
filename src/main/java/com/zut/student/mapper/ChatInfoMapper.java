package com.zut.student.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;

import com.zut.student.entity.ChatInfo;

@Mapper
public interface ChatInfoMapper {

	@Insert("insert into chatRoom(userId,lineText) values(#{userId},#{lineText})")
	void insertChatInfo(String userId, String lineText);

	@Select("select * from chatRoom ")
	List<ChatInfo> selectAllChatInfo();
}
