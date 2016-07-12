package demo;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jweng on 7/12/2016.
 */
public class CustomUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public CustomUsernamePasswordAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
        // TODO Auto-generated constructor stub
    }

    public CustomUsernamePasswordAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login","POST"));
        // TODO Auto-generated constructor stub
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
          {
        // String dbValue = request.getParameter("dbParam");
        // request.getSession().setAttribute("dbValue", dbValue);
        System.out.println("attempting to authentificate");
        while (request.getAttributeNames().hasMoreElements()) {
            String e = (String) request.getAttributeNames().nextElement();
            System.out.println("param name : " + e + " and param value : " + request.getAttribute(e));
        }
        return null;
    }
}