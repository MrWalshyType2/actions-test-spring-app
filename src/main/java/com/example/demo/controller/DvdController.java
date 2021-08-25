package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.model.Dvd;
import com.example.demo.service.DvdService;

@RestController()
@RequestMapping("/dvds")
@CrossOrigin
public class DvdController {
	
	private DvdService dvdService;
	
	@Autowired
	public DvdController(DvdService dvdService) {
		this.dvdService = dvdService;
	}

	@GetMapping
	public ResponseEntity<List<Dvd>> get() {
		return ResponseEntity.ok(dvdService.get());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Dvd> get(@PathVariable("id") long id) {
		return ResponseEntity.ok(dvdService.get(id));
	}
	
	@PostMapping
	public ResponseEntity<Dvd> create(@RequestBody Dvd dvd) {
		Dvd newDvd = dvdService.create(dvd);
		URI uri = URI.create("http://localhost:8080/dvd/" + newDvd.getId());
		return ResponseEntity.created(uri)
							 .contentType(MediaType.APPLICATION_JSON)
							 .body(newDvd);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Dvd> update(@PathVariable("id") long id, @RequestBody Dvd dvd) {
		return ResponseEntity.accepted()
							 .body(dvdService.update(id, dvd));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		dvdService.delete(id);
		return ResponseEntity.noContent()
							 .build();
	}
}
