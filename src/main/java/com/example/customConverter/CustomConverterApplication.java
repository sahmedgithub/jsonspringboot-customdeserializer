package com.example.customConverter;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CustomConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomConverterApplication.class, args);
	}
}





@RestController()
class RestStuff {
	@PostMapping("/user")
	public String getUser(@RequestBody User user) {
		return user.getUserName() + user.getAge();
	}
}

@JsonDeserialize(using = PersonDeserializer.class)
class User {

	private String userName;
	private Integer age;

	public User(String name, int i) {
		this.userName = name;
		this.age = i;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
