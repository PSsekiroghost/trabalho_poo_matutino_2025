package com.poo.viagem.sistema_reservas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/reserva")
public class ReservaController {
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@GetMapping
	public List<Reserva> listarReservas(){
		return reservaRepository.findAll();
	}
	
	@PostMapping
	public Reserva salvarReserva(@RequestBody Reserva reserva) {
		return reservaRepository.save(reserva);
	}
	
	@DeleteMapping("/{id}")
	   public void deletarPessoa(@PathVariable Long id) {
		reservaRepository.deleteById(id);
	   }
	
	@PutMapping("/{id}")
	   public Reserva atualizarReserva(@PathVariable Long id, @RequestBody Reserva novaReserva) {
	       Optional<Reserva> optionalReserva = reservaRepository.findById(id);
	       if (optionalReserva.isPresent()) {
	    	   Reserva reserva = optionalReserva.get();
	           reserva.setDataReserva(novaReserva.getDataReserva());
	           reserva.setStatus(novaReserva.getStatus());
	           reserva.setMeioPagamento(novaReserva.getMeioPagamento());
	           reserva.setViagem(novaReserva.getViagem());
	           reserva.setPassageiro(novaReserva.getPassageiro());
	           return reservaRepository.save(reserva);
	       }
	       return null;
	   }


}
