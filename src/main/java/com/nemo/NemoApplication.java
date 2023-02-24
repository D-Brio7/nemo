package com.nemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins="*")
@RestController
@SpringBootApplication
public class NemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(NemoApplication.class, args);
	}
}
