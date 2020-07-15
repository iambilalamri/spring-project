package com.bamri.spring.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.bamri.spring.validation.Vpn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data @AllArgsConstructor @NoArgsConstructor
public class Event extends Auditable<String>{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "the name of the event is mondatory")
	private String name;
	
	@NotBlank(message = "the lieu of the event is mondatory")
	private String lieu;
	
	@NotBlank(message = "the adresse of the event is mondatory")
	private String adresse;
	
	@NotNull(message = "the place of the event is mondatory")
	private int place;
	
	@NotNull(message = "the ticket price of the event is mondatory")
	private double montantTicket;
	
	@NotNull(message = "the ticket price of the event is mondatory")
	@Vpn(message = "The numbre of VPN is not acceptable")
	private Integer nombreVPN;
	
	private boolean vpn;
}
