package ttps.spring.utils;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;

@Component
public class TokenValidator {
	final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
    public String generateToken(String username, int segundos) {
        Date exp = getExpiration(new Date(), segundos);
        String jwts = Jwts.builder().setSubject(username).signWith(key).setExpiration(exp).compact();
        try {
        	assert Jwts.parser().setSigningKey(key).parseClaimsJws(jwts).getBody().getSubject().equals(username);
        	System.out.println("token generado: " + jwts);
        	return jwts;
        } catch (JwtException e) {
        	System.out.println("excepcion " + e.getMessage());
        	return null;
        }
    }

    private Date getExpiration(Date date, int segundos) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // Configuramos la fecha que se recibe
        calendar.add(Calendar.SECOND, segundos);
        return calendar.getTime();
    }

    public static Claims validateToken(String token) {
    	System.out.println("llega token " + token);
        String prefix = "Bearer";
        try {
            if (token.startsWith(prefix)) {
                token = token.substring(prefix.length()).trim();
            }
            System.out.println("token sin bearer: " + token);
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();//payload
  
            return claims;
            
        } catch (ExpiredJwtException exp) {
        	return null;
        } catch (JwtException e) {
            // Algo salio mal en la verificacion
        	//reportar este tipo de errores
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
