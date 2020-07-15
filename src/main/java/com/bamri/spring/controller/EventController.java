package com.bamri.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bamri.spring.model.Event;
import com.bamri.spring.repository.EventRepository;

@RestController
@RequestMapping(path = "/api/v1")
public class EventController {

	@Autowired
	EventRepository eventRepository;

	@GetMapping("/events")
	public List<Event> findEvents() {
		return this.eventRepository.findAll();
	}

	@GetMapping("/event/{id}")
	public Optional<Event> findEventById(@PathVariable Long id) {
		return this.eventRepository.findById(id);
	}

	@GetMapping("/event/{name}")
	public List<Event> findEventByName(@PathVariable String name) {
		return this.eventRepository.findEventByName(name);
	}

	@GetMapping("/event/{lieu}")
	public List<Event> findEventByLieu(@PathVariable String lieu) {
		return this.eventRepository.findEventByLieu(lieu);
	}

	@PostMapping("/events")
	public ResponseEntity<Event> addEvents(@Valid @RequestBody Event event) {
		List<Event> list = this.eventRepository.findAll();
		this.eventRepository.save(event);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}

	@PutMapping("/event/{id}")
	public ResponseEntity<Event> updateEvents(@Valid @RequestBody Event event, @PathVariable Long id) {

		Optional<Event> optinalEvent = this.eventRepository.findById(id);
		if (!optinalEvent.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		event.setId(id);
		this.eventRepository.save(event);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}

}
