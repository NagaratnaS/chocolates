package com.wolken.wolkenapp.chocolates.entity;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component
public class ResponseEntity {
	private ChocoEntity entity;
	private String message;

}
