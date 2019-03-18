package com.vanvov.kafka.service.impl;

import com.vanvov.kafka.common.Result;
import com.vanvov.kafka.dao.TSysLogDao;
import com.vanvov.kafka.domain.TSysLog;
import com.vanvov.kafka.service.ITSysLogService;

import com.vanvov.kafka.service.IUserService;
import com.vanvov.kafka.utils.PageUtil;
import com.vanvov.kafka.utils.UUIDG;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: TSysLogServiceImpl</p>
 * <p>Description:操作日志 </p>
 *
 * @author lzq
 * @date 2018年8月13日
 */
@Service("tSysLogService")
public class TSysLogServiceImpl implements ITSysLogService {

    private static final Logger logger = LogManager.getLogger(TSysLogServiceImpl.class);

    @Autowired
    private TSysLogDao tSysLogDao;

    @Autowired
    private IUserService userService;

    @Override
    public Result queryUserLogGrid(Map paramMap) {
        Result res = new Result();
        try {
            long total = tSysLogDao.queryTSysLogGridByTotal(paramMap);
            List<Map> resList = new ArrayList<Map>();
            if (total > 0) {
                PageUtil.limit(paramMap);
                resList = tSysLogDao.queryTSysLogGridByList(paramMap);
            }
            //记录查询日志的关键字,看是哪里编码问题
            if (StringUtils.isNotBlank((String) paramMap.get("operate")) || StringUtils.isNotBlank((String) paramMap.get("module_name"))) {
                TSysLog tSysLog = new TSysLog();
                tSysLog.setLog_id(UUIDG.generate());
                tSysLog.setModule_name("操作日志");
                tSysLog.setOperate("新增");
                tSysLog.setOper_time(new Date());
                tSysLog.setMemo("新增查询操作日志的日志");
                tSysLog.setParams("[ \"module_name\":" + paramMap.get("module_name") + ", \"operate\":" + paramMap.get("operate") + " ]");
                tSysLogDao.insertTSysLog(tSysLog);
            }
            String result = PageUtil.toGrid(resList, total, paramMap);
            res.setGrid(result);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("queryUserLogGrid 出现异常", e);
            res.setSuccess(false);
        }
        return res;

    }

    @Override
    public void addTSysLog(TSysLog tSysLog) {
        tSysLogDao.insertTSysLog(tSysLog);

    }

    @Override
    public TSysLog queryLogById(String id) {

        TSysLog tSysLog = tSysLogDao.queryLogById(id);
		/* if(StringUtils.isNotBlank(tSysLog.getUser_id()) && !"无法获取用户id".equals(tSysLog.getUser_id())){
			 TSysUser tSysUser = userService.queryUserById(tSysLog.getUser_id());
			 tSysLog.setUser_name(tSysUser.getLogin_name());
		 }*/
        return tSysLog;
    }

}
