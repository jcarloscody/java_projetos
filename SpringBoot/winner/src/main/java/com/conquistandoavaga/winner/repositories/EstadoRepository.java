package com.conquistandoavaga.winner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.conquistandoavaga.winner.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

	

}
