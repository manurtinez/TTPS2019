package ttps.spring.filter;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import ttps.spring.utils.TokenValidator;

/**
 * Servlet Filter implementation class JWTAuthenticationFilter
 */
@WebFilter(urlPatterns = "*")
public class JWTAuthenticationFilter implements Filter {

	private FilterConfig filterConf;
	 
    public JWTAuthenticationFilter() {}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.filterConf = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

        // El login del usuarios es publico
        if ("/HistoriaClinicaMascotas/autenticacion".equals(req.getRequestURI()) ||
                HttpMethod.OPTIONS.matches(req.getMethod())) {

            chain.doFilter(request, response);
            return;
        }

        String token = req.getHeader(HttpHeaders.AUTHORIZATION);

        if ( (token == null) || (TokenValidator.validateToken(token)!=null) ) {
            HttpServletResponse res = (HttpServletResponse) response;
            res.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }

        chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		 this.filterConf = fConfig;
	}

}
