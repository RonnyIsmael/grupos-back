package com.grupos.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.grupos.back.model.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer>{
	
}