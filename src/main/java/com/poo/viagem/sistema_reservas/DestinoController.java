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
@RequestMapping("/api/destino")
public class DestinoController {

	@Autowired
	DestinoRepository destinoRepository;
	@GetMapping
	public List<Destino> listarDestinos(){
		return destinoRepository.findAll();
	}
	
	@PostMapping
	public Destino salvarDestino(@RequestBody Destino destino) {
		return destinoRepository.save(destino);
	}
	
	@DeleteMapping("/{id}")
	   public void deletarDestino(@PathVariable Long id) {
	       destinoRepository.deleteById(id);
	   }

	
	   @PutMapping("/{id}")
	   public Destino atualizarDestino(@PathVariable Long id, @RequestBody Destino novoDestino) {
	       Optional<Destino> optionalDestino = destinoRepository.findById(id);
	       if (optionalDestino.isPresent()) {
	    	   Destino destino = optionalDestino.get();
	    	   destino.setPais(novoDestino.getPais());
	    	   destino.setEstado(novoDestino.getEstado());
	    	   destino.setCidade(novoDestino.getCidade());
	           return destinoRepository.save(destino);
	       }
	       return null;
	   }

	
}