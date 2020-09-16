package com.jwz.salesteam.mapper;

import com.jwz.salesteam.entity.GoodsList;
import com.jwz.salesteam.entity.GoodsListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsListMapper {
    int countByExample(GoodsListExample example);

    int deleteByExample(GoodsListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsList record);

    int insertSelective(GoodsList record);

    List<GoodsList> selectByExample(GoodsListExample example);

    GoodsList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsList record, @Param("example") GoodsListExample example);

    int updateByExample(@Param("record") GoodsList record, @Param("example") GoodsListExample example);

    int updateByPrimaryKeySelective(GoodsList record);

    int updateByPrimaryKey(GoodsList record);
}