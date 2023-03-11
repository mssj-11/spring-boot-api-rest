package com.mss.springboot.web.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mss.springboot.web.app.models.Cliente;


@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
}