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

import com.totvs.compromisso.app.AddVechicleTypeCommand;
import com.totvs.compromisso.app.VechicleTypeApplicationService;
import com.totvs.compromisso.config.ResponseModel;
import com.totvs.compromisso.controller.dto.AddVechicleTypeCommandDto;
import com.totvs.compromisso.controller.dto.VechicleTypeDTO;
import com.totvs.compromisso.domain.fields.Description;
import com.totvs.compromisso.domain.fields.VechicleTypeId;
import com.totvs.compromisso.infra.VechicleTypeDomainRepository;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/vechicleType", produces = { MediaType.APPLICATION_JSON_VALUE })
public class VechicleTypeController {
    @Autowired
    private VechicleTypeApplicationService vechicleTypeApplicationService;

    @Autowired
    private VechicleTypeDomainRepository vechicleTypeDomainRepository;        		

	@RequestMapping(value="/add", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<ResponseModel> salvar(@RequestBody AddVechicleTypeCommandDto dto){

		try {
	
			vechicleTypeApplicationService.handle(AddVechicleTypeCommand.of(VechicleTypeId.generate(), new Description(dto.description)));
	
			return new ResponseEntity<ResponseModel>(new ResponseModel(1,"Registro salvo com sucesso!"), HttpStatus.CREATED);
	
		}catch(Exception e) {
	
			return new ResponseEntity<ResponseModel>(new ResponseModel(0,e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
	
    @GetMapping(path = "/all")
    public List<VechicleTypeDTO> findAll() {
        return vechicleTypeDomainRepository.findAll()
                .stream()
                .map(vechicleType -> new VechicleTypeDTO(vechicleType.getId().toString(), vechicleType.getDescription().toString()))
                .collect(Collectors.toList());
    }
}