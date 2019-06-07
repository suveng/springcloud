package com.free.system.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * description:
 * @author suwenguang@52tt.com
 * @date 2019/5/24
 * @version 1.0.0
 **/
//@Component
@Slf4j
public class AccessLogFilter extends ZuulFilter {
    /**
     * 方法:  filterType
     * @author suwenguang
     * @date 2019/5/24
     * @return String
     */
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    /**
     * 方法:  filterOrder
     * @author suwenguang
     * @date 2019/5/24
     * @return int
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
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
        //计算访问时间
        getUriCostTime();
        return null;
    }

    /**
     * 方法:  getUriCostTime:计算访问时间
     * @author suwenguang
     * @date 2019/5/24
     */
    private void getUriCostTime() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        Long startTime = (Long) context.get("startTime");
        String uri = request.getRequestURI();
        long duration = System.currentTimeMillis() - startTime;
        log.info("uri: " + uri + ", duration: " + duration / 100 + "ms");
    }
}
