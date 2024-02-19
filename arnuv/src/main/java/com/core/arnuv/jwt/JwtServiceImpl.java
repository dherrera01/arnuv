package com.core.arnuv.jwt;

import com.core.arnuv.service.IUsuarioDetalleService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements IJwtService {
    @Value("${token.signing.key}")
    private String jwtSigningKey;

    private String tokenSession;

    @Autowired
    private IUsuarioDetalleService serviceUsuarioDetalle;

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Override
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    @Override
    public Claims extraerTokenData() {
        return this.extractAllClaims(getTokenSession());
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        var diaexp = System.currentTimeMillis() + (1000 * 60 * 60 * 24); // expira al siguiente dia
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(diaexp))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

    @Override
    public HttpHeaders generaToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        var jwt = this.generateToken(extraClaims, userDetails);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", jwt);
        return responseHeaders;
    }

    @Override
    public HttpHeaders regeneraToken() {
//        var data = extraerTokenData();
//        String username = (String) data.get("username");
//        var entity = serviceUsuarioDetalle.buscarPorUsuario(username);
//
//        var jwt = this.generateToken(data, entity);
        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("token", jwt);
        return responseHeaders;
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token)
                .getBody();
    }

    @Override
    public void setTokenSession(String token) {
        this.tokenSession = token;
    }

    @Override
    public String getTokenSession() {
        return tokenSession;
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateTokenNuevoUser(Map<String, Object> extraClaims, UserDetails userDetails) {
        var diaexp = System.currentTimeMillis() + (1000 * 60 * 60); // expira en una hora
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(diaexp))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }
}
