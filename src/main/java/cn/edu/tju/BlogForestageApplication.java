package cn.edu.tju;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.edu.tju.mapper")
@SpringBootApplication
public class BlogForestageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogForestageApplication.class, args);
	}
}
 