package com.zh.thank.zuulapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class ErrorFilter extends ZuulFilter{
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 30;
    }

    @Override
    public boolean shouldFilter() {
        //只针对，对于post过滤器在执行时出现异常后，导致没有其他的过滤器组织异常信息
        RequestContext ctx = RequestContext.getCurrentContext();
        //由于自己定过滤器处理器会保存当前抛异常时的过滤器实例，所以这里可以直接获取
        ZuulFilter failedFilter = (ZuulFilter)ctx.get("failed.filter");
        if(failedFilter != null && "post".equals(failedFilter.filterType())){
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        ctx.set("status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        ctx.set("exception",throwable.getCause());
        ctx.set("message","就看你是不是开启异常了！");
        return null;
    }
}
