package com.poo.viagem.sistema_reservas;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
}