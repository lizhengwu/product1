/**
 * FileName: OnSystemPropertiesCondition
 * Author:   lzw
 * Date:     2020/2/20 21:20
 * Description:
 * History:
 */
package com.lzw.condition;

import java.util.Objects;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import com.lzw.annotation.OnSystemPropertyConditon;

/**
 * 〈 根据 SystemProperties 判断是否加载某个实例〉
 *
 * @author lzw
 * @create 2020/2/20
 * @since 1.0.0
 */
public class OnSystemPropertiesCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		MultiValueMap<String, Object> allAnnotationAttributes = metadata.getAllAnnotationAttributes(OnSystemPropertyConditon.class.getName());
		String name = (String) allAnnotationAttributes.getFirst("name");
		String value = (String) allAnnotationAttributes.getFirst("value");

		String language = context.getEnvironment().getProperty(name);
		return Objects.equals(value, language);
	}
}