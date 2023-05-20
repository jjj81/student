package com.zut.student.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;

import com.zut.student.entity.ChatInfo;

@Mapper
public interface ChatInfoMapper {

	@Insert("insert into chatRoom(userId,lineText,className,userName) values(#{userId},#{lineText},#{className},#{userName})")
	void insertChatInfo(String userId, String lineText, String className, String userName);

	@Select("select * from chatRoom  where className=#{className}")
	List<ChatInfo> selectChatInfoByClassName(String className);
}
