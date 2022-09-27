package com.example.mapper;

import com.example.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/27
 * \* Description:
 * \* @author 王祥栋
 */
@Mapper
public interface Test02Mapper {
    List<StudentEntity> selectAllStudents();

    /**
     * 批量增加数据
     * @param list
     * @return
     */
    int volumeIncrease(@Param("list") List<StudentEntity> list);
}
