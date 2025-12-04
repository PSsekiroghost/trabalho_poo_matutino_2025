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
@RequestMapping("/api/empresa")
public class EmpresaController {


	@Autowired
	EmpresaRepository empresaRepository;
	@GetMapping
	public List<Empresa> listarEmpresas(){
		return empresaRepository.findAll();
	}
	
	@PostMapping
	public Empresa salvarEmpresa(@RequestBody Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	@DeleteMapping("/{id}")
	   public void deletarEmpresa(@PathVariable Long id) {
	       empresaRepository.deleteById(id);
	   }

	@PutMapping("/{id}")
	   public Empresa atualizarEmpresa(@PathVariable Long id, @RequestBody Empresa novaEmpresa) {
	       Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
	       if (optionalEmpresa.isPresent()) {
	           Empresa empresa = optionalEmpresa.get();
	           empresa.setNome(novaEmpresa.getNome());
	           empresa.setTipo(novaEmpresa.getTipo());
	           empresa.setContato(novaEmpresa.getContato());
	           return empresaRepository.save(empresa);
	       }
	       return null;
	   }

	
}
