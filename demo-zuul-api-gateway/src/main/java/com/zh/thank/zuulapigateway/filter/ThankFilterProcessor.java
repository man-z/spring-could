package com.zh.thank.zuulapigateway.filter;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 该类主要解决在post过滤执行过程中出现异常后，没有过滤组织异常参数，会导致用户页面显示不友好
 */
public class ThankFilterProcessor extends FilterProcessor{

    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try {

            return super.processZuulFilter(filter);
        } catch (ZuulException e){
            RequestContext ctx = RequestContext.getCurrentContext();
            ctx.set("failed.filter",filter);
            throw e;
        }
    }
}
