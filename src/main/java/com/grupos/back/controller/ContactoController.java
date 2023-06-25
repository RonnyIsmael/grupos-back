package com.grupos.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupos.back.model.Contacto;
import com.grupos.back.repository.ContactoRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("contactos")
public class ContactoController {
	@Autowired
	ContactoRepository contactoRepository;
	@GetMapping("")
	public List<Contacto> listContacto(){
		return contactoRepository.findAll();
	}
}
