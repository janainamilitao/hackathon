package com.marketpay.hackathon.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketpay.hackathon.model.Usuario;
import com.querydsl.core.types.dsl.BooleanExpression;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Page<Usuario> findAll(BooleanExpression predicate, Pageable pageable);

}
