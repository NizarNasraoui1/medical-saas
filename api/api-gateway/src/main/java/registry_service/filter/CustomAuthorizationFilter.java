//package registry_service.filter;
//
//import com.auth0.jwt.algorithms.Algorithm;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.springframework.http.HttpHeaders.AUTHORIZATION;
//import static org.springframework.http.HttpStatus.FORBIDDEN;
//import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
//
///**
// * @author Get Arrays (https://www.getarrays.io/)
// * @version 1.0
// * @since 7/10/2021
// */
//@Slf4j
//@Configuration
//public class CustomAuthorizationFilter extends OncePerRequestFilter {
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if(request.getServletPath().equals("/auth/token") || request.getServletPath().equals("/auth/register")) {
//            filterChain.doFilter(request, response);
//        } else {
//            String authorizationHeader = request.getHeader(AUTHORIZATION);
//            if(authorizationHeader != null) {
//                try {
//                    String token = authorizationHeader.substring("Bearer ".length());
//                    Claims claims = Jwts.parser()
//                            .setSigningKey("5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437")
//                            .parseClaimsJws(token)
//                            .getBody();
//                    String role = (String) claims.get("role");
//                    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//                    authorities.add(new SimpleGrantedAuthority(role));
//                    UsernamePasswordAuthenticationToken authenticationToken =
//                            new UsernamePasswordAuthenticationToken(claims.getSubject(), null, authorities);
//                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                    filterChain.doFilter(request, response);
//                }catch (Exception exception) {
//                    response.setHeader("error", exception.getMessage());
//                    response.setStatus(FORBIDDEN.value());
//                    //response.sendError(FORBIDDEN.value());
//                    Map<String, String> error = new HashMap<>();
//                    error.put("error_message", exception.getMessage());
//                    response.setContentType(APPLICATION_JSON_VALUE);
//                    new ObjectMapper().writeValue(response.getOutputStream(), error);
//                }
//            } else {
//                filterChain.doFilter(request, response);
//            }
//        }
//    }
//}
