package br.com.lito.poc.coletor.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColetaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String ic;
	private String componente;
	private String elemento;
	private LocalDate data;
	private BigDecimal valor;
	
}
