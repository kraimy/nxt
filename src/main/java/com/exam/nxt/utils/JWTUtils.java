package com.exam.nxt.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.exam.nxt.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT工具类
 */
public class JWTUtils {

    /**
     * 根据用户id,账号生成token
     *
     * @param u
     * @return
     */
    public static String getToken(User u) {
        String token = "";
        try {
            //过期时间 为1970.1.1 0:0:0 至 过期时间  当前的毫秒值 + 有效时间
            Date expireDate = new Date(new Date().getTime() + 1000 * 60 * 60 * 2);
            //秘钥及加密算法                            秘钥自定义
            Algorithm algorithm = Algorithm.HMAC256("MtYang");
            //设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //携带id，账号信息，生成签名
            token = JWT.create()
                    .withHeader(header)   //第一部分
                    .withClaim("phone", u.getPhone())  //第二部分  想把哪些数据放进token里就加哪个
                    //.withClaim("id",u.getId())
                    .withClaim("id", u.getUserid()) // 普通人
                    .withExpiresAt(expireDate)
                    .sign(algorithm);     //第三部分
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }

    /**
     * 根据管理员id,账号生成token
     * @param a
     * @return
     */
/*    public static String getToken(User a) {

//        System.out.println(u);
        String token = "";
        try {
            //过期时间 为1970.1.1 0:0:0 至 过期时间  当前的毫秒值 + 有效时间
            Date expireDate = new Date(new Date().getTime() + 60*1000); // 1分钟
            //秘钥及加密算法                            秘钥自定义
            Algorithm algorithm = Algorithm.HMAC256("MtYang");
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带id，账号信息，生成签名
            token = JWT.create()
                    .withHeader(header)   //第一部分
                    .withClaim("uindex",a.getPhone())  //第二部分  想把哪些数据放进token里就加哪个
                    //.withClaim("id",a.getId())
                    .withClaim("flag",1) // 管理员
                    .withExpiresAt(expireDate)
                    .sign(algorithm);     //第三部分
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }

        return token;
    }*/

    /**
     * 验证token是否有效
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            //验签
            Algorithm algorithm = Algorithm.HMAC256("MtYang");
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {//当传过来的token如果有问题,抛出异常
            return false;
        }
    }

    /**
     * 获得token 中playload部分数据,按需使用
     *
     * @param token
     * @return
     */
    public static DecodedJWT getTokenInfo(String token) {

        return JWT.require(Algorithm.HMAC256("MtYang")).build().verify(token);
    }

    /**
     * 解析出token中封装的用户编号
     */
    public static Integer getTokenInfoIndex(String token) {

        DecodedJWT tokenInfo = JWT.require(Algorithm.HMAC256("MtYang")).build().verify(token);

        Integer index = tokenInfo.getClaim("uindex").asInt();

        return index;
    }

    /**
     * 解析出token中封装的用户电话号
     */
    public static String getTokenInfoPhone(String token) {

        DecodedJWT tokenInfo = JWT.require(Algorithm.HMAC256("MtYang")).build().verify(token);

        String phone = tokenInfo.getClaim("phone").asString();

        return phone;
    }

    /**
     * 解析出token中封装的用户身份证号
     */
    public static String getTokenInfoId(String token) {

        DecodedJWT tokenInfo = JWT.require(Algorithm.HMAC256("MtYang")).build().verify(token);

        String id = tokenInfo.getClaim("id").asString();

        return id;
    }

    /**
     * 解析出token中封装的用户标识
     */
    public static Integer getTokenFlag(String token) {
        DecodedJWT tokenInfo = JWT.require(Algorithm.HMAC256("MtYang")).build().verify(token);

        Integer flag = tokenInfo.getClaim("flag").asInt();

        return flag;
    }

}




