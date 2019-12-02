package cn.tedu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements 
		HandlerInterceptor{
	//1.表示在控制器方法之前执行。
	//2.方法的返回值如果为false，则不再继续向下执行
	 //                        表示请求到此结束。
	//3.方法的返回值如果为true，会继续执行控制器方法
	//适合做登录验证
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		//登录验证
		//1.获取session，从session获取Object obj
		HttpSession session = 
				request.getSession();
		Object obj = 
				session.getAttribute("user");
		//2.判断对象是否为null，如果为null，
		if(obj==null){
		//	转发到login.jsp,返回false
			request.getRequestDispatcher(
					"/WEB-INF/web/login.jsp").
					forward(request, response);
			return false;
		}else{
		//3.如果不为null；return true
			return true;
		}
	}
	//表示在控制器的方法之后，在响应页面之前执行
	//对响应视图对象进行处理
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("postHandle");
	}
	//当页面响应成功。
	//适合处理一些收尾的操作，比如性能测试
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
		
	}

}
