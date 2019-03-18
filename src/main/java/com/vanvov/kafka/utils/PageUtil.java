package com.vanvov.kafka.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.vanvov.kafka.common.Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  @TODO 类说明     将结果转为json返回页面
 *  @DateTime 2018-1-25 下午04:22:42
 *  @version V1.0
 */
public class PageUtil {
	private static final Logger logger =LogManager.getLogger(PageUtil.class);
	
	/**
	* @date 2018年4月9日 下午9:23:47
	* @Title: limit
	* @Description
	*			设置分页
	* @param param 参数
	* @return void 返回类型
	*/
	public static void limit(Map<String,Object> param){
		int page = Integer.parseInt((String)param.get("page"));
		int rows = Integer.parseInt((String)param.get("rows"));
		param.put("BEGIN_NUM", ((page*rows)-rows));
		param.put("END_NUM", (rows));
		param.put("limit", "true");
	}
	
	/**
	* @date 2018年1月27日 下午9:00:15
	* @Title: toGrid
	* @Description
	*			封装表格数据
	* @param @param result
	* @param @param pages
	* @param @return 参数
	* @return String 返回类型
	* @throws
	*/
	public static String toGrid(List<Map> result, Long total, Map<String,String> page){
		Map<String,Object> resultMap = new HashMap<String,Object>(); 
		Integer pageNum = Integer.parseInt(page.get("page"));
		Double rows = Double.parseDouble(page.get("rows"));
		double count = total/rows;
		resultMap.put("page", pageNum);//页码
		resultMap.put("total", Math.round(Math.ceil(count)));//总页数
		resultMap.put("records", total);//总记录
		resultMap.put("rows", result);
		 String objStr = JSONObject.toJSONString(resultMap,
	                SerializerFeature.WriteDateUseDateFormat,SerializerFeature.WriteMapNullValue);
		return objStr;
	}
	
	/**
	* @date 2018年1月27日 下午9:00:39
	* @Title: write
	* @Description
	*			数据写出表格
	* @param @param result
	* @param @param response
	* @param @throws IOException 参数
	* @return void 返回类型
	* @throws
	*/
	public static void write(Result result, HttpServletResponse response){
		if(result.isSuccess()){
			String data = result.getGrid();
			if(StringUtils.isNotBlank(data)){
				try {
					response.getWriter().write(data);
				} catch (IOException e) {
					// TODO: handle exception
					logger.error(e.getMessage(), e);
				}
			}
		}
	}
}
