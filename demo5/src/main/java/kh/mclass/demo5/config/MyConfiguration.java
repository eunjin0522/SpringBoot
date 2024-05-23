package kh.mclass.demo5.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kh.mclass.demo5.filter.LoginInterceptor;

@Configuration
//WebMvcConfigurer -> url 관련 설정 //아래 코드들은 설정을 위한 코드들이다 설정해주면 이제 엥간하면 쓸 일 없음!!!
@EnableWebMvc  //bean 생성 가능
public class MyConfiguration implements WebMvcConfigurer{
	//new를 대신하는 .build() 메소드 
	
	
	@Autowired
	//필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다
//	방법1
//	private LoginInterceptor loginInterceptor;
	
	
	@Override //interceptors를 적용할 애들 지정해주기
	public void addInterceptors(InterceptorRegistry registry) {
//		방법1
//		registry.addInterceptor(loginInterceptor)
//			.addPathPatterns("/**")
//			.excludePathPatterns("/login")
//			.excludePathPatterns("/join")
//			.excludePathPatterns("/main/*");

//		방법2
		registry.addInterceptor(new HandlerInterceptor() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				System.out.println("hahha");
				//session 객체를 가져욤
				HttpSession session = request.getSession();
				//login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져욤
				Object obj = session.getAttribute("sslogin");
				if (obj == null) {
					response.sendRedirect(request.getContextPath()+"/login");
					return false;
				}else {
					return true;
				}
			}
		})
		.addPathPatterns("/**")
		.excludePathPatterns("/login")
		.excludePathPatterns("/join")
		.excludePathPatterns("/main/*")
		.excludePathPatterns("/css/**","/js/**","/image/**","/html/**")
		;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**")
				.addResourceLocations("classpath:/static/*");
		registry.addResourceHandler("/html/**")
			.addResourceLocations("classpath:/static/html");
		registry.addResourceHandler("/image/**")
			.addResourceLocations("classpath:/static/image");
		registry.addResourceHandler("/js/**")
		.addResourceLocations("classpath:/static/js");
	}	
	
	@Bean //bean으로 객체를 생성했고 return type은 object이다
	public Object mybean() {
		Object reObj = null;
		
		return reObj;
	}
}
