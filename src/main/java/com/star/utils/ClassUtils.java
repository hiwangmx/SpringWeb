package com.star.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author: 王明星(WangMingXing)
 * @En_Name: Star.Wang
 * @E-mail: hiwangmx@gmail.com
 * @version: normal
 * @Created Time: 2015年12月23日 下午2:49:06
 * @Description:
 *
 **/

public class ClassUtils {

	public static Map<String, String> getMap(Object object) throws IllegalArgumentException, IllegalAccessException{
		Map<String, String> map = new HashMap<String, String>();
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		if(fields != null && fields.length > 0){
			for(Field field : fields){
				field.setAccessible(true);
				map.put(field.getName(), field.get(object).toString());
			}
		}
		return map;
	}
	
}
