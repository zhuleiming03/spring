package spring.cloud.zuul.service.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


public class AccessFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        System.out.printf("send %s request to %s \n"
                , request.getMethod(), request.getRequestURI());

        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            System.out.println("access token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseBody("please input your token");
            requestContext.setResponseStatusCode(401);
            return null;
        } else {
            System.out.println("access token ok");
            return null;
        }
    }
}
