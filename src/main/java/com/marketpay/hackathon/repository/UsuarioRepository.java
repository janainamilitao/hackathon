package com.marketpay.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketpay.hackathon.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{



}
