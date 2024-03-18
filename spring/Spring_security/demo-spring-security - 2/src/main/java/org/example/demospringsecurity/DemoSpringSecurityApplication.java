package org.example.demospringsecurity;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.SecretKey;

@SpringBootApplication
public class DemoSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringSecurityApplication.class, args);

		//Méthode pour gérer un jwt

//		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//
//		String baseKey = Encoders.BASE64.encode(key.getEncoded());
//		System.out.println(baseKey);

	}

}
