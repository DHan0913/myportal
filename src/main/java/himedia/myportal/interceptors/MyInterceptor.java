package himedia.myportal.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
	private static Logger logger = 
			LoggerFactory.getLogger(MyInterceptor.class);
	//	URL 처리 핸들러 작동하기 이전에 호출
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		logger.debug("MyInterceptor::preHandle");
		//	true면 뒤쪽의 Interceptor 혹 HandlerMethod로 이동
		//	false면 이후의 Interceptor는 실행되지 않음
		return true;
	}

	//	URL 처리 핸들러 작동 이후
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("MyInterceptor::postHandle");
		//	handler 확인
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod)handler;
			//	호출된 컨트롤러 메서드 정보 추출
			String controllerName = handlerMethod.getBeanType().getName();
			//	호출된 메서드 이름 추출
			String methodName = handlerMethod.getMethod().getName();
			
			logger.debug("Controller: " + controllerName + 
					", Method: " + methodName);
			
		}
	}

	//	뷰 렌더링까지 마친 이후 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("MyInterceptor::afterCompletion");
	}
	

}
