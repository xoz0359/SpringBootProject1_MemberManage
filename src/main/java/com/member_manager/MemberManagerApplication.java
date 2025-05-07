package com.member_manager;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class MemberManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberManagerApplication.class, args);
	}

}
