package edu.icet.ElecBilling.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JwtUtil {

    private String secret = "YourElectricityBillingAPIKeyHere";

    public String extractCustomername(String token){
        return extractClamis(token,Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClamis(token,Claims::getExpiration);
    }

    public <T> T extractClamis(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClamis(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClamis(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String customerName, String accountType) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("accountType", accountType);
        return createToken(claims, customerName);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String customername = extractCustomername(token);
        return (customername.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
