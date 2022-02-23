//package com.powernow.usm.interceptor;
//
//import com.powernow.usm.annotation.IgnoreAuth;
//import com.powernow.usm.annotation.IpVerify;
//import com.powernow.usm.common.Constans;
//import com.powernow.usm.common.ErrorEnum;
//import com.powernow.usm.config.NoRegisterException;
//import com.powernow.usm.entity.SysUser;
//import com.powernow.usm.service.RedisService;
//import com.powernow.usm.service.SysIpWhiteService;
//import com.powernow.usm.service.SysUserService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.concurrent.TimeUnit;
//
///**
// * 权限(Token)验证
// *
// * @author lipengjun
// * @email 939961241@qq.com
// * @gitee https://gitee.com/fuyang_lipengjun/platform
// * @date 2017-03-23 15:38
// */
//@Component
//@Slf4j
//public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
//
//    @Autowired
//    private RedisService redisService;
//    @Autowired
//    private SysUserService sysUserService;
//    @Autowired
//    private SysIpWhiteService sysIpWhiteService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//
//        //支持跨域请求
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,X-Nideshop-Token,X-URL-PATH,Content-Type");
//        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
//
//
//        IgnoreAuth annotation;
//        IpVerify ipVerify;
//        if (handler instanceof HandlerMethod) {
//            annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
//            ipVerify = ((HandlerMethod) handler).getMethodAnnotation(IpVerify.class);
//        } else {
//            return true;
//        }
//
//        //如果有@IgnoreAuth注解，则不验证token
//        if (annotation != null) {
//            return true;
//        }
//        String accessToken = request.getHeader(Constans.ACCESS_TOKEN);
//        if(StringUtils.isBlank(accessToken)){
//            throw new NoRegisterException(401, ErrorEnum.ACCESS_TOKEN_ERROR.text);
//        }
//
//        String value = redisService.stringGet(Constans.ACCESS_TOKEN_KEY+accessToken);
//        if(StringUtils.isBlank(value)){
//            throw new NoRegisterException(401, ErrorEnum.ACCESS_TOKEN_ERROR.text);
//        }
//
//        //如果有@whiteIpVerify注解并且value为ip，则验证ip白名单（内部人员也可直接访问相关接口）
//        if (ipVerify != null && isIp(value)){
//            // ip是否在白名单内
//            Integer ipCount = sysIpWhiteService.countByIp(request.getRemoteAddr());
//            if (ipCount == 0){
//                throw new NoRegisterException(500, ErrorEnum.NOT_TEST_USER_TO_LOGIN.text);
//            }
//        } else {
//            // 查询用户是否在白名单内
//            SysUser user = sysUserService.findByAddress(value);
//            if (user == null){
//                throw new NoRegisterException(401, ErrorEnum.NOT_TEST_USER_TO_LOGIN.text);
//            }
//            request.setAttribute(Constans.LOGIN_USER_INFO,user);
//        }
//
//        //token续期
//        redisService.expire(Constans.ACCESS_TOKEN_KEY+accessToken,Constans.ACCESS_TOKEN_EXPIRE, TimeUnit.MINUTES);
//        return true;
//    }
//
//    public boolean verifyAddress(String address, HttpServletRequest request){
//        if(StringUtils.isBlank(address)){
//            throw new NoRegisterException(401, ErrorEnum.ACCESS_TOKEN_ERROR.text);
//        }
//        // 查询用户是否在白名单内
//        SysUser user = sysUserService.findByAddress(address);
//        if (user == null){
//            throw new NoRegisterException(401, ErrorEnum.NOT_TEST_USER_TO_LOGIN.text);
//        }
//        request.setAttribute(Constans.LOGIN_USER_INFO,user);
//        return true;
//    }
//
//    public boolean isIp(String ip){//判断是否是一个IP
//        return ip.matches("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}");
//    }
//
//
//
//}
