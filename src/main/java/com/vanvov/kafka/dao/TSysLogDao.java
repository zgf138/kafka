package com.vanvov.kafka.dao;

import com.vanvov.kafka.domain.TSysLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: TSysLogDao</p>
 * <p>Description:日志查询 </p>
 * @date 2018年8月13日
 */
@Mapper    //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface TSysLogDao {

    /**
     * <p>Title: queryUserLogGridByTotal</p>
     * <p>Description:查询总记录数 </p>
     *
     * @param paramMap
     * @return
     */
    long queryTSysLogGridByTotal(Map paramMap);

    /**
     * <p>Title: queryUserLogGridByList</p>
     * <p>Description:查询页面操作日志列表数据 </p>
     *
     * @param paramMap 页面传进来的参数
     * @return
     */
    List<Map> queryTSysLogGridByList(Map paramMap);

    /**
     * <p>Title: insertTSysLog</p>
     * <p>Description:添加日志 </p>
     *
     * @param tSysLog 日志实体类
     * @return 添加个数
     */
    public int insertTSysLog(TSysLog tSysLog);


    /**
     * <p>Title: queryLogById</p>
     * <p>Description:根据日志id查询日志 </p>
     *
     * @param id
     * @return
     */
    TSysLog queryLogById(String id);

}
