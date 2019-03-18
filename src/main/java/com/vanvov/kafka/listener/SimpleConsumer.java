package com.vanvov.kafka.listener;


import com.alibaba.fastjson.JSONObject;
import com.vanvov.kafka.domain.TSysLog;
import com.vanvov.kafka.service.ITSysLogService;
import com.vanvov.kafka.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleConsumer {

    @Autowired
    IUserService userService;

    @Autowired
    ITSysLogService sysLogService;

    @Autowired
    MongoTemplate mongoTemplate;

    @KafkaListener(topics = {"basic-log"})
    public void receive(String message) throws InterruptedException {
        String substring = message.substring(message.indexOf("{"));
        System.out.println("---------------------------------------" + substring);
        if (StringUtils.isNotBlank(substring)) {
            JSONObject jsonObject = JSONObject.parseObject(substring);
            TSysLog tSysLog = JSONObject.toJavaObject(jsonObject, TSysLog.class);
            sysLogService.addTSysLog(tSysLog);
            System.out.println("消费了" + JSONObject.toJSON(tSysLog).toString());
            mongoTemplate.save(tSysLog, "log");
        }

    }

}
