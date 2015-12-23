package com.star.redis.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.star.redis.annotation.RedisObjectField;
import com.star.redis.annotation.RedisObjectFieldId;
import com.star.redis.annotation.RedisObjectKey;

/**
 *
 * @author: 王明星(WangMingXing)
 * @En_Name: Star.Wang
 * @E-mail: hiwangmx@gmail.com
 * @version: normal
 * @Created Time: 2015年12月23日 下午3:06:03
 * @Description:
 *
 **/

public class RedisUtils {

	public static final String PROTECT_NAME = "star";
	
	//将Object转换成Map
	public static Map<String, String> getMap(Object object) throws IllegalArgumentException, IllegalAccessException{
		Map<String, String> map = new HashMap<String, String>();
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		if(fields != null && fields.length > 0){
			for(Field field : fields){
				field.setAccessible(true);
				RedisObjectField annotationField = field.getAnnotation(RedisObjectField.class);
				if(annotationField != null && StringUtils.isNotBlank(annotationField.value())){
					map.put(annotationField.value(), field.get(object).toString());
				}else{
					map.put(field.getName(), field.get(object).toString());
				}
			}
		}
		return map;
	}
	
	/**
	 * 以项目名开头、表名（类名）、唯一键，并以":"间隔
	 * 例如：star:122:1212
	 */
	public static String gecKey(Object object) throws IllegalArgumentException, IllegalAccessException{
		//项目名
		String key = PROTECT_NAME;
		//表名（类名）
		Class<?> clazz = object.getClass();
		RedisObjectKey annotation = clazz.getAnnotation(RedisObjectKey.class);
		if(StringUtils.isNotBlank(annotation.value())){
			key += ":" + annotation.value();
		}else{
			key += ":" + clazz.getSimpleName();
		}
		//主键ID
		Field[] fields = clazz.getDeclaredFields();
		if(fields != null && fields.length > 0){
			for(Field field : fields){
				field.setAccessible(true);
				RedisObjectFieldId annotationFieldId = field.getAnnotation(RedisObjectFieldId.class);
				if(annotationFieldId != null){
					key += ":" + field.get(object).toString(); 
				}
			}
		}
		return key;
	}
	
}
