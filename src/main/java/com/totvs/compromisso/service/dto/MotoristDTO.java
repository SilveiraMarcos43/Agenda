package com.totvs.compromisso.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@EqualsAndHashCode @ToString
public class MotoristDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
    private String description;
    
}
