package cn.mycloudway.filter;

import cn.mycloudway.pojo.Result;
import cn.mycloudway.util.JWTUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String[] urlWhiteList = {"/login"};
        String currentUrl = httpServletRequest.getRequestURL().toString();
        log.info("请求的URL：{}", currentUrl);

        for (String url : urlWhiteList) {
            if (currentUrl.contains(url)) {
                log.info("URL白名单，直接放行：{}", url);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        String token = httpServletRequest.getHeader("token");
        if (!StringUtils.hasLength(token)) {
            log.info("请求token为空，返回未登录信息");
            String notLogin = JSONObject.toJSONString(Result.error("NOT_LOGIN"));
            servletResponse.getWriter().write(notLogin);

            return;
        }

        try {
            jwtUtils.verifyJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录信息");
            String notLogin = JSONObject.toJSONString(Result.error("NOT_LOGIN"));
            servletResponse.getWriter().write(notLogin);

            return;
        }

        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
