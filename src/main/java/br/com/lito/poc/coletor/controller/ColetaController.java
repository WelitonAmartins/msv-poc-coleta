package br.com.lito.poc.coletor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lito.poc.coletor.service.ColetaService;

@Controller
@RequestMapping("v1/coleta")
public class ColetaController {
	
	@Autowired
	private ColetaService coletaService;
	
	@GetMapping
	public ResponseEntity<String> enviarColeta() throws Exception {
		this.coletaService.enviarColeta();
		return ResponseEntity.ok("Coleta enviado para a fila com sucesso!");
	}
	
	@GetMapping("/lote")
	public ResponseEntity<String> enviarColetaLote() throws Exception {
		this.coletaService.enviarLoteColeta();
		return ResponseEntity.ok("Lote de coleta enviado para a fila com sucesso!");
	}

}
