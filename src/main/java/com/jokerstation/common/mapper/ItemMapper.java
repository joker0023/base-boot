package com.jokerstation.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jokerstation.common.pojo.Item;

import tk.mybatis.mapper.common.Mapper;

public interface ItemMapper extends Mapper<Item> {

	@Select("select * from item limit 0, 2")
	public List<Item> list2();
	
	public Item listById(@Param("id") Long id);
}
