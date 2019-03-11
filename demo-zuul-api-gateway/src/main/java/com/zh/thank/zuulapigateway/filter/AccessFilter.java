package com.zh.thank.zuulapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import freemarker.log.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessFilter extends ZuulFilter {


    /**
     * 过滤器类型
     * @return
     *  #pre表示可以在请求被路由之前调用这个过滤器
     * #routing表示在路由请求时被调用
     * #post表示在routing和error过滤器之后被调用
     * #error表示处理请求时发生错误时被调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序
     * @return
     * 返回值越小优先级越高
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        try {
            throwException();
        } catch (Exception e){
            throw new RuntimeException("就看你是不是开启异常了！");
        }
        HttpServletRequest request = ctx.getRequest();
        System.out.println("send {} request to {} " +request.getRequestURI().toString()+request.getMethod().toString());
        String accessToken = request.getParameter("accessToken");
        if(accessToken == null){
            System.out.println("access token is empty");
            ctx.getResponse().setCharacterEncoding("UTF-8");
            //命令zuul过滤该请求，不对其进行路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("您的请求有危险，不允许您通过！");
            return null;
        }
        return null;
    }

    public void throwException(){
        throw new RuntimeException("测试抛异常");
    }
}
