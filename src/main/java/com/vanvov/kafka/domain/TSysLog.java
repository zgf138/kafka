package com.vanvov.kafka.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TSysLog implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	 /**日志id*/
    private String log_id;
    /**用户id*/
    private String user_id;
    /* 用户名*/
    private String user_name;
    /**模块名称*/
    private String module_name;
    /**操作*/
    private String operate;
    /**时间*/
    private Date oper_time;
    /** 操作时间转换*/
    private String opertime;
    /**类名*/
    private String class_name;
    /**方法名*/
    private String method_name;
    /**传入参数*/
    private String params;
    /* 返回值*/
    private String results;
    /**操作oper_ip*/
    private String oper_ip;
   /* 描述*/
    private String memo;
	public String getLog_id() {
		return log_id;
	}
	public void setLog_id(String log_id) {
		this.log_id = log_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getModule_name() {
		return module_name;
	}
	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getOper_time() {
		return oper_time;
	}
	public void setOper_time(Date oper_time) {
		this.oper_time = oper_time;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getMethod_name() {
		return method_name;
	}
	public void setMethod_name(String method_name) {
		this.method_name = method_name;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
	public String getOper_ip() {
		return oper_ip;
	}
	public void setOper_ip(String oper_ip) {
		this.oper_ip = oper_ip;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getOpertime() {
		return opertime;
	}
	public void setOpertime(String opertime) {
		this.opertime = opertime;
	}

   
}
