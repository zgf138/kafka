package com.vanvov.kafka.listener;


import com.alibaba.fastjson.JSONObject;
import com.vanvov.kafka.domain.TSysLog;
import com.vanvov.kafka.service.ITSysLogService;
import com.vanvov.kafka.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleConsumer {

    @Autowired
    IUserService userService;

    @Autowired
    ITSysLogService sysLogService;

    @KafkaListener(topics = {"basic-log"})
    public void receive(String message) throws InterruptedException {
        String substring = message.substring(message.indexOf("{"));
        System.out.println("---------------------------------------"+substring);
        if (StringUtils.isNotBlank(substring)){
            JSONObject jsonObject = JSONObject.parseObject(substring);
            TSysLog tSysLog = JSONObject.toJavaObject(jsonObject, TSysLog.class);
            System.out.println(tSysLog);
            sysLogService.addTSysLog(tSysLog);
        }

    }

}
