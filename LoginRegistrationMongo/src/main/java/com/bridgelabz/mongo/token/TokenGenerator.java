package com.bridgelabz.mongo.token;

import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import com.bridgelabz.mongo.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenGenerator {
	final static String KEY = "lakshmi";

	public String generator(User user) {
		String userName = user.getUserName();
		String passkey = user.getPassword();
		long time = System.currentTimeMillis();
		long nowMillis = System.currentTimeMillis() + (1 * 60);
		Date now = new Date(nowMillis);
		JwtBuilder builder = Jwts.builder().setId(passkey).setIssuedAt(now).setSubject(userName)
				.signWith(SignatureAlgorithm.HS256, KEY);
		if (time >= 0) {

		}
		return builder.compact();
	}

	public void parseJWT(String jwt) {

		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(KEY)).parseClaimsJws(jwt)
				.getBody();
		System.out.println("Id: " + claims.getId());
		System.out.println("Sub: " + claims.getSubject());
	}
}
