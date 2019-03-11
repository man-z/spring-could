package com.zh.thank.zuulapigateway.attributes;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * 通过该类自定义异常模板
 * #需要在启动类使用@Bean注解来生效这个异常属性
 */
public class ThankAttributes extends DefaultErrorAttributes{

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> result = super.getErrorAttributes(webRequest, includeStackTrace);
        //删除返回给用显示的exception属性
        result.remove("exception");
        return result;
    }
}
