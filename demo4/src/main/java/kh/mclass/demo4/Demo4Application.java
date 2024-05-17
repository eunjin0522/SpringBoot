package kh.mclass.demo4;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo4Application {

	public static void main(String[] args) {
		System.out.println("---start");
		Arrays.stream(SpringApplication.run(Demo4Application.class, args).getBeanDefinitionNames()).forEach(System.out::println);;
		System.out.println("---end");
	}

}
