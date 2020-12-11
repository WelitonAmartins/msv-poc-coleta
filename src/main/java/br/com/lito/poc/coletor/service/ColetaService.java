package br.com.lito.poc.coletor.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lito.poc.coletor.dto.ColetaDTO;
import br.com.lito.poc.coletor.produce.EnviarColetaProduce;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ColetaService {

	@Autowired
	private EnviarColetaProduce enviarColetaProduce;

	public void enviarLoteColeta() throws Exception {

		
		ColetaDTO x = new ColetaDTO("batatinha", "frita", "katchup", LocalDate.now(), new BigDecimal(20));

		for (int j = 0; j < 2000; j++) {
			List<ColetaDTO> lsColeta = new ArrayList<>();
			for (int i = 0; i < 10000; i++) {
				lsColeta.add(x);
			}
			enviarColetaProduce.enviarLoteColeta(lsColeta);
		}

	}

	public void enviarColeta() throws Exception {
		int count = 1;

		for (int i = 0; i < 1000000; i++) {
			ColetaDTO x = new ColetaDTO("uni-cornio", "cabrito", "uni-brito", LocalDate.now(), new BigDecimal(20));
			enviarColetaProduce.enviarColeta(x);
			count += 1;
		}
		log.info("Enviado {} itens", count);

	}

}
