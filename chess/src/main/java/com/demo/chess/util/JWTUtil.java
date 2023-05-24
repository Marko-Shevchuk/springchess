package com.demo.chess.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;

public class JWTUtil {
     public static String generateToken(String nickname) {
         return JWT.create().withSubject(nickname).withExpiresAt(Instant.now().plusSeconds(1800)).sign(Algorithm.HMAC256("secret".getBytes()));
     }
}
