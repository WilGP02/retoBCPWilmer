package com.reto.api.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

	private String user;
	private String password;
	private String token;
}
