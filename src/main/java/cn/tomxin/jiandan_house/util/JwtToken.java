package cn.tomxin.jiandan_house.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtToken {
    public static String SECRET ="jiandan";

    /**
     * 创建Token/Token加密
     * @return
     * @throws Exception
     */
    public static String createToken(String openId) throws Exception{
        // 签发时间
        Date iatDate = new Date();
        // 过期时间
        Calendar nowTime = Calendar.getInstance();
        //数字代表几分钟过期/7天后过期
        nowTime.add(Calendar.MINUTE,60*24*7);
        Date expiresDate = nowTime.getTime();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        String token = JWT.create()
                .withHeader(map)
                .withClaim("openId",openId)
                .withExpiresAt(expiresDate)
                .withIssuedAt(iatDate)
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    /**
     * Token解密
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET))
                .build();
        DecodedJWT jwt = null;
        try{
            jwt = verifier.verify(token);
        }catch (Exception E){
            log.info("token 验证失败");
            throw new RuntimeException("token 验证失败");
        }
        return jwt.getClaims();
    }

    /**
     * 获取用户的openid
     * @param request
     * @return
     * @throws Exception
     */
    public static String getUserOpenId(HttpServletRequest request) throws Exception {
        String access_token = request.getHeader("Authorization");
        Map<String, Claim> tokenMap = JwtToken.verifyToken(access_token);
        String openId = tokenMap.get("openId").asString();
        return openId;
    }
}
