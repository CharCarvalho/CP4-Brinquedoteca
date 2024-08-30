package com.brinquedoteca.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brinquedoteca.fiap.model.BrinquedotecaModel;

public interface BrinquedotecaRepository extends JpaRepository<BrinquedotecaModel, Long> {

}
