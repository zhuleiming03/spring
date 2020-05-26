package spring.cloud.zuul.exception;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class DefineErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

        Map<String, Object> result = super.getErrorAttributes(webRequest, includeStackTrace);
        // 打印异常信息后 隐藏异常详情
        System.out.println("异常详情：" + result);
        result.remove("error");
        result.remove("message");
        return result;
    }
}
