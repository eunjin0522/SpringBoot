package kh.mclass.demo5;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo5Application {

	public static void main(String[] args) {
		ApplicationContext appConext = SpringApplication.run(Demo5Application.class, args);
		//주입된 객체들 확인
		//TODO 재원재원 코드 확인하기!!!
		//String[] beansNameArr = appConext.getBean;
	}

}
