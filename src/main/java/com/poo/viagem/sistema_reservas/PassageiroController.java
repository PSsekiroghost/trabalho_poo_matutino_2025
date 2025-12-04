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
@RequestMapping("/api/passageiro")
public class PassageiroController {
	
	@Autowired
	PassageiroRepository passageiroRepository;
	
	@GetMapping
	public List<Passageiro> listarPassageiros(){
		return passageiroRepository.findAll();
	}
	
	@PostMapping
	public Passageiro salvarPassageiro(@RequestBody Passageiro passageiro) {
		return passageiroRepository.save(passageiro);
	}
	
	@DeleteMapping("/{id}")
	   public void deletarPassageiro(@PathVariable Long id) {
		passageiroRepository.deleteById(id);
	   }
	 
	@PutMapping("/{id}")
	   public Passageiro atualizarPassageiro(@PathVariable Long id, @RequestBody Passageiro novoPassageiro) {
	       Optional<Passageiro> optionalPassageiro = passageiroRepository.findById(id);
	       if (optionalPassageiro.isPresent()) {
	    	   Passageiro passageiro = optionalPassageiro.get();
	    	   passageiro.setNome(novoPassageiro.getNome());
	    	   passageiro.setEmail(novoPassageiro.getEmail());
	    	   passageiro.setDataNascimento(novoPassageiro.getDataNascimento());
	    	   passageiro.setTelefone(novoPassageiro.getTelefone());
	           return passageiroRepository.save(passageiro);
	       }
	       return null;
	   }


}
