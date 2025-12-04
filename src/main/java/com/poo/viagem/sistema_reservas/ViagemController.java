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
@RequestMapping("/api/viagem")
public class ViagemController {

	@Autowired
	ViagemRepository viagemRepository;
	
	@GetMapping
	public List<Viagem> listarViagens(){
		return viagemRepository.findAll();
	}
	
	@PostMapping
	public Viagem salvarViagem(@RequestBody Viagem viagem) {
		return viagemRepository.save(viagem);
	}
	
	@DeleteMapping("/{id}")
	   public void deletarViagem(@PathVariable Long id) {
		viagemRepository.deleteById(id);
	   }
	
	@PutMapping("/{id}")
	   public Viagem atualizarViagem(@PathVariable Long id, @RequestBody Viagem novaViagem) {
	       Optional<Viagem> optionalViagem = viagemRepository.findById(id);
	       if (optionalViagem.isPresent()) {
	    	   Viagem viagem = optionalViagem.get();
	    	   viagem.setData(novaViagem.getData());
	    	   viagem.setHora(novaViagem.getHora());
	    	   viagem.setEmpresa(novaViagem.getEmpresa());
	    	   viagem.setDestino(novaViagem.getDestino());
	           return viagemRepository.save(viagem);
	       }
	       return null;
	   }

	
}
