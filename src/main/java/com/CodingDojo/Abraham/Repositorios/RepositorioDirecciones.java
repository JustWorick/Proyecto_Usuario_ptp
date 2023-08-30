package com.CodingDojo.Abraham.Repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.CodingDojo.Abraham.Modelos.Direccion;

public interface RepositorioDirecciones extends CrudRepository<Direccion, Long> {

	List<Direccion> findAll();
}
