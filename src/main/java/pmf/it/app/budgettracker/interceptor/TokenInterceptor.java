package pmf.it.app.budgettracker.interceptor;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Token;
import pmf.it.app.budgettracker.service.KorisnikService;
import pmf.it.app.budgettracker.service.TokenService;

public class TokenInterceptor implements HandlerInterceptor {
	@Autowired
	private TokenHolder tokenHolder;
	
	@Autowired
	KorisnikService ks;

	@Autowired
	TokenService ts;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		System.out.println(url);
		if(url.contains("auth") || url.contains("api") || url.contains("swagger")) return true;
		String token = request.getHeader("token");
		tokenHolder.setToken(token);
		tokenHolder.setKorisnik(ks.findByUsername(request.getHeader("user")));
		Token tok = ts.getToken(tokenHolder.getKorisnik());
		if(Objects.isNull(tok))
			throw new RuntimeException("bad user");
		if(!tok.getToken().equals(token))
			throw new RuntimeException("bad token");
		
		return true;
	}
	

}
