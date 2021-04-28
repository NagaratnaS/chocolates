package com.wolken.wolkenapp.chocolates.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table(name = "choki")
public class ChocoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "chocoID")
	private int chocoID;
	@Column(name = "chocoBrand")
	private String chocoBrand;
	@Column(name = "chocoPrice")
	private int chocoPrice;
	@Column(name = "chocoColor")
	private String chocoColor;

}
