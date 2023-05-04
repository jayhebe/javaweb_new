package cn.mycloudway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JWTUtils {
    @Autowired
    private JWTProperties jwtProperties;

    public String getJWT(Map<String, Object> claims) {

        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSignKey())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpire()))
                .compact();
    }

    public Claims verifyJWT(String jwtToken) {
        return Jwts.parser()
                .setSigningKey(jwtProperties.getSignKey())
                .parseClaimsJws(jwtToken)
                .getBody();
    }
}
