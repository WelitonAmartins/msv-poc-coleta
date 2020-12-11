package br.com.lito.poc.coletor.util;


import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Service
public  class Util {

	private static ObjectMapper mapper;
	
	static {
		mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(new JavaTimeModule());
	}
	
	public static String paraJson(final Object obj) throws Exception {
		String jsonFormatado = null;
		try {
			jsonFormatado = mapper.writeValueAsString(obj);
		} catch (final JsonProcessingException e) {
			throw new Exception("Erro ao converter o DTO para Json.", e);
		}
		return jsonFormatado;
	}
}
