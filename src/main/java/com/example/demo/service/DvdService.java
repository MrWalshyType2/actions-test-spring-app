package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.model.Dvd;
import com.example.demo.data.repository.DvdRepository;

@Service
public class DvdService {
	
	private DvdRepository dvdRepository;
	
	@Autowired
	public DvdService(DvdRepository dvdRepository) {
		this.dvdRepository = dvdRepository;
	}
	
	public List<Dvd> get() {
		return this.dvdRepository.findAll();
	}

	public Dvd get(long id) {
		return this.dvdRepository.findById(id)
								 .orElseThrow(EntityNotFoundException::new);
	}

	public Dvd create(Dvd dvd) {
		return this.dvdRepository.save(dvd);
	}

	public Dvd update(long id, Dvd dvd) {
		Dvd dvdInDb = dvdRepository.getById(id);
		
		dvdInDb.setDescription(dvd.getDescription());
		dvdInDb.setReleaseYear(dvd.getReleaseYear());
		dvdInDb.setTitle(dvd.getTitle());
		
		return dvdRepository.save(dvdInDb);
	}

	public void delete(long id) {
		dvdRepository.findById(id)
					 .orElseThrow();
		dvdRepository.deleteById(id);
	}

}
