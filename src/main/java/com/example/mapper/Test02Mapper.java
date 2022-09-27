package com.example.mapper;

import com.example.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

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
}
