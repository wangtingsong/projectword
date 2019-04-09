package com.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonMapper {
	
	@Select("select name from person where id =#{id}")
	public String getName(int id);
}
