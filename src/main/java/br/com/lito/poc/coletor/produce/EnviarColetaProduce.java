package br.com.lito.poc.coletor.produce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.lito.poc.coletor.dto.ColetaDTO;
import br.com.lito.poc.coletor.util.Util;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EnviarColetaProduce {

	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${topic.kafka.fila.coleta}")
	private String topicoColeta;
	
	
	@Value("${topic.kafka.fila.coleta_lista}")
	private String topicoColetaLista;
	
	
	
	
	
	public void enviarColeta(ColetaDTO coleta) throws Exception {
			log.info("Postando mensagem no topico: {}", topicoColeta);
			kafkaTemplate.send(topicoColeta, Util.paraJson(coleta));
	}
	
	public void enviarLoteColeta(List<ColetaDTO> coleta) throws Exception {
		log.info("Postando mensagem no topico: {}", topicoColetaLista);
//		kafkaTemplate.send(topicoColetaLista, Util.paraJson(coleta) );
		kafkaTemplate.send(topicoColetaLista, "testando");
		log.info("mensagem postada");
}
}
