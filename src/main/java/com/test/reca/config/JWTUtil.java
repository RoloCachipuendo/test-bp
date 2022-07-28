package com.test.reca.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JWTUtil {
    private static final String KEY = "YP50QG5/NT7ZefNQ8vu2ouhpCl+n0bDDKYPR2LP5X2c=";

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256,KEY)
                .compact();
    }


    public boolean validateToken(String token, UserDetails userDetails){
        return userDetails.getUsername().equals(extractUsername(token)) && isTokenExpire(token);

    }

    public String extractUsername(String token){
        log.info(getClaims(token).getSubject());
        return getClaims(token).getSubject();
    }

    public boolean isTokenExpire(String token){
        return getClaims(token).getExpiration().after(new Date());
    }

    private Claims getClaims(String token){
        return  Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }
}
