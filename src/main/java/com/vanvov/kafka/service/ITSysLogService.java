package com.vanvov.kafka.service;


import com.vanvov.kafka.common.Result;
import com.vanvov.kafka.domain.TSysLog;

import java.util.Map;

/**
 * 操作日志
 *
 * @author lzq
 * 2018年7月21日 上午11:10:14
 */
public interface ITSysLogService {

    /**
     * @param param
     * @return
     * @author lzq
     * @DateTime 2018年7月23日 上午14:56:14
     * @serverCode 服务代码
     * @serverComment 查询操作日志列表数据
     */
    Result queryUserLogGrid(Map<String, String> param);

    /**
     * @param tSysLog
     * @return
     * @author lzq
     * @DateTime 2018年7月24日 上午11:50:14
     * @serverCode 服务代码
     * @serverComment 添加操作日志列表数据
     */
    void addTSysLog(TSysLog tSysLog);


    TSysLog queryLogById(String id);


}
