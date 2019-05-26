package com.free.system.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description:
 * @author suwenguang@52tt.com
 * @date 2019/5/24
 * @version 1.0.0
 **/
@Component
@Slf4j
public class PreRequestFilter extends ZuulFilter {

    /**
     * 方法:  filterType
     * @author suwenguang
     * @date 2019/5/24
     * @return String
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 方法:  filterOrder
     * @author suwenguang
     * @date 2019/5/24
     * @return int
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 方法:  shouldFilter
     * @author suwenguang
     * @date 2019/5/24
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 方法:  run
     * @author suwenguang
     * @date 2019/5/24
     * @return Object
     * @throws ZuulException when
     */
    @Override
    public Object run() throws ZuulException {
        //获取请求上下文
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpServletResponse response = context.getResponse();

        context.set("startTime", System.currentTimeMillis());
        //todo:鉴权
        this.check(context, request, response);
        return null;
    }


    /**
     * 说明:
     * @author suwenguang
     * @date 2019/5/25
     * @return void <- 返回类型
     */
    private void check(RequestContext context, HttpServletRequest request, HttpServletResponse response) {
        //鉴权逻辑
        Object token = request.getParameter("token");

        if (ObjectUtils.isEmpty(token) && !request.getRequestURI().contains("login") && !request.getRequestURI().contains("static")) {
            log.info("ip:{},no token",request.getRemoteAddr());
            //设置zuul 返回标志,true则转发给对应服务,false则直接返回,需要自己设置response
            context.setSendZuulResponse(false);
            //设置http status 为未授权
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            try {
                //返回重定向页面
                response.sendRedirect("/user/login.html");
            } catch (IOException e) {
                log.error("io 错误:{}", e.getMessage());
            }
            //设置自定义的返回体
            context.setResponse(response);
        }
    }
}
