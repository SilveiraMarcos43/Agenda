package com.totvs.compromisso.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.totvs.compromisso.app.AddMotoristCommand;
import com.totvs.compromisso.app.MotoristApplicationService;
import com.totvs.compromisso.config.ResponseModel;
import com.totvs.compromisso.controller.dto.AddMotoristCommandDTO;
import com.totvs.compromisso.controller.dto.AllMotoristDTO;
import com.totvs.compromisso.domain.fields.Description;
import com.totvs.compromisso.domain.fields.MotoristId;
import com.totvs.compromisso.infra.MotoristDomainRepository;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/motorist", produces = { MediaType.APPLICATION_JSON_VALUE })
public class MotoristController {
    @Autowired
    private MotoristApplicationService motoristApplicationService;

    @Autowired
    private MotoristDomainRepository motoristDomainRepository;        		

	@RequestMapping(value="/add", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<ResponseModel> salvar(@RequestBody AddMotoristCommandDTO dto){

		try {
	
			motoristApplicationService.handle(AddMotoristCommand.of(MotoristId.generate(), new Description(dto.description)));
	
			return new ResponseEntity<ResponseModel>(new ResponseModel(1,"Registro salvo com sucesso!"), HttpStatus.CREATED);
	
		}catch(Exception e) {
	
			return new ResponseEntity<ResponseModel>(new ResponseModel(0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
	
    @GetMapping(path = "/all")
    public List<AllMotoristDTO> findAll() {
    	try {
            return motoristDomainRepository.findAll()
                    .stream()
                    .map(motorist -> new AllMotoristDTO(motorist.getId().toString(), motorist.getDescription().toString()))
                    .collect(Collectors.toList());
        } catch(Exception e) {
        	new ResponseEntity<ResponseModel>( new ResponseModel(0, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        	return null;
        	
        }
	}
}
