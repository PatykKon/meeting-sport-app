package com.meeting.sport.app;

import com.meeting.sport.app.user.dto.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {

//    @Value("${application.security.jwt.secret-key}")
//    private String secretKey;
//    @Value("${application.security.jwt.expiration}")
//    private long jwtExpiration;
//    @Value("${application.security.jwt.refresh-token.expiration}")
//    private long refreshExpiration;

    private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
    private static final Long EXPIRATION = 86400000L;
    private static final Long EXPIRATION_REFRESH = 604800000L;


    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDTO userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    private String generateToken(
            Map<String, Object> extraClaims,
            UserDTO userDetails
    ) {
        return buildToken(extraClaims, userDetails, EXPIRATION);
    }

    public String generateRefreshToken(
            UserDTO userDetails
    ) {
        return buildToken(new HashMap<>(), userDetails, EXPIRATION_REFRESH);
    }

    private String buildToken(
            Map<String, Object> extraClaims,
            UserDTO userDetails,
            long expiration
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.email())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDTO user) {
        final String username = extractUsername(token);
        return (username.equals(user.email())) && !isTokenExpired(token);
    }

    public String getEmailFormJwtToken(String jwt){
        jwt =jwt.substring(7);
        Claims claims = Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(jwt).getBody();
        return String.valueOf(claims.get("sub"));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
