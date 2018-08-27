package learn.util;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorTest extends HandlerInterceptorAdapter {
	@SuppressWarnings({ "unused"})
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String a = request.getRequestURL().toString();
		String b = request.getContextPath();
		String c = request.getQueryString();
		String d = request.getRequestURI();
		String e = request.getRequestURL().toString();
		String f = request.getMethod();
		String g = request.getServletPath();
		ServletContext sc = request.getServletContext();
		String h = sc.getContextPath();
		String i = sc.getInitParameter("contextConfigLocation");
		String j = sc.getServerInfo();
		String k = sc.getServletContextName();
		return true;
	}

}
