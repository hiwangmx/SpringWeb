package com.star.redis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author: 王明星(WangMingXing)
 * @En_Name: Star.Wang
 * @E-mail: hiwangmx@gmail.com
 * @version: normal
 * @Created Time: 2015年12月23日 下午1:44:36
 * @Description:
 *
 **/

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisObjectKey {

	String value() default "";
	
}
