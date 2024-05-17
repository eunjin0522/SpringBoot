package kh.mclass.demo1;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		ApplicationContext appContext= SpringApplication.run(Demo1Application.class, args);
		
		//주입된 객체들 확인
		String[] beansNameArr = appContext.getBeanDefinitionNames();
		System.out.println("============================= start");
//		for (String beanName:beansNameArr) {
//			System.out.println(beanName);
//		}
		//for문 처럼 하나씩 뽑아서 출력하기
		Arrays.stream(appContext.getBeanDefinitionNames()).forEach(System.out::println); //람다식
		System.out.println("============================ 중간점검 filter");		
		Arrays.stream(appContext.getBeanDefinitionNames()).filter((s)->s.contains("demo")).forEach(System.out::println);
		//람다식 foreach, filter(찾아줘)
		System.out.println("============================ END");
	}
}
