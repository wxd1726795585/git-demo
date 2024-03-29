package com.example.mapper;

import com.alibaba.fastjson.JSONObject;
import com.example.entity.CopyEntity;
import com.example.entity.StudentEntity;
import com.example.entity.TradeMqConsumerLog;
import com.example.entity.UpperAgentRes;
import com.example.req.PersonReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
     *
     * @param list
     * @return
     */
    int volumeIncrease(@Param("list") List<StudentEntity> list);

    /**
     * 批量修改数据
     *
     * @param list
     * @return
     */
    int bulkChanges(List<StudentEntity> list);

    /**
     * 批量修改
     *
     * @param tradeMqConsumerLogs
     * @return
     */
    int updateMoreData(@Param("list") List<TradeMqConsumerLog> tradeMqConsumerLogs);

    BigDecimal selectDemo(@Param("list") List<String> idList);

    /**
     * 测试mybatis
     *
     * @param jsonObject
     * @param age
     * @return
     */
    List<CopyEntity> testMybatis(@Param("jsonObject") JSONObject jsonObject, @Param("age") String age);

    /**
     * 查询总条数
     *
     * @return
     */
    Integer selectCount(@Param("gender") String gender);

    /**
     * 测试sql
     *
     * @param flag
     * @return
     */
    List<CopyEntity> test01Sql(@Param("flag") Boolean flag);

    /**
     * 测试sqlv2
     *
     * @param personReq
     * @return
     */
    List<Map<String, Object>> test02Sql(@Param("req") PersonReq personReq);

    /**
     * 测试sql-v3
     *
     * @param copyEntity
     * @return
     */
    int test03Sql(@Param("copy") CopyEntity copyEntity);


    int test04Sql(@Param("id") String id);

    /**
     * 悲观锁
     *
     * @param id
     * @return
     */
    CopyEntity pessimisticLockById(String id);

    /**
     * 更改条数
     * @param id
     * @return
     */
    Integer updateCount(String id);

    /**
     * 添加数据
     * @param id
     * @return
     */
    int insertCopy(String id);

    List<CopyEntity> selectCopyList();

    Integer updateById(@Param("id") String id);

    List<Map<String,Object>> selectById(@Param("id") String id);

    Integer selectCopyCounts();

    CopyEntity getCopyEntityById();

    List<CopyEntity> getCopyEntityList();

    /**
     * 查询商户所有关联代理
     *
     * @param cooperatorId 商户ID
     * @return List<UpperAgentRes>
     */
    List<UpperAgentRes> doFindUpperAgentIds(@Param("cooperatorId") String cooperatorId);

}
