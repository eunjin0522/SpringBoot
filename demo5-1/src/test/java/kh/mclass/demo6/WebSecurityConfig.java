package kh.mclass.demo6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
//참조하는 모양 자체가 없다!!! implement,extent가 없다?? 이걸 자동으로 해주는 Enable시리즈 어노테이션을 추가해주자 
public class WebSecurityConfig {
	
	@Bean //@EnableWebSecurity 안에 BCryptPasswordEncoder를 선언하면 암호화를 하겠다는 의미
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}

	@Bean //설정관련내용을 추가해서 Bean 객체 생성
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {// - HttpSecurity형태의 Bean객체를 하나달라
		//각종 detail한 설정을 넣어서 해당 객체를 완성하는 것
		//온갖 설정을 추가해서 해당 객체가 spring에 전달 -> springframework의 설정이 여기서 되는 것이다.
		//WebSecurityConfig에서 Security에 관련된 설정을 해당 method에서 설정하는 것이다
		// - http 객체에 각종 설정을 넣는다
		
		http.csrf(a -> a.disable()); //해당 param에 disacle을 걸어달라는 람다식
		//httpSecurityCsrfConfigurer는 이름이니까 보기쉬운 이름으로 하라
		
		//클릭재킹 공격 방지기능
		http.headers(httpSecurityHeadersConfigurer ->httpSecurityHeadersConfigurer.frameOptions(
				frameOptionsConfig ->frameOptionsConfig.sameOrigin() //같은사이트만 허락 - react 연동 h2 conosole사요시
				));
		//login + logout을 HttpSecurity 객체에 맡김 -> 설정값을 바꾼다는 의미
		http.formLogin(fr ->
				fr.loginPage("/demo6/login") //.loginPage("login") default설정 -> 굳이 적지 않음 
				.defaultSuccessUrl("/home")
				.failureUrl("/demo6/login?error") //화면상에 오류 메세지를 뿌릴 수 있게 해줌
				//.usernameParameter("email") // name에 email이라고 써준다 비추천 html의 name속성 username으로 그냥 쓰자 (default값으로 두자 나중에 헷갈림)
				);
		
		//ExceptionHandling ->
		//psring security에서 필터 거는법
		
		//인터셉터
		//front 에서의 name은 이 객체 안에 있는 이름으로 지정해줘야한다
		//http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		//UserDetailsService
//		http.userDetailsService(mainMemberService); // 내가 만들어 둔 방식으로 처리해달란 의미
		
		return http.build(); //throws exception 추가해줘야한다
	}

}
