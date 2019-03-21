package com.totvs.compromisso.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.totvs.compromisso.domain.Motorist;
import com.totvs.compromisso.infra.MotoristDomainRepository;

@Service
@Transactional
public class MotoristApplicationService {

    @Autowired
    private MotoristDomainRepository motoristDomainRepository;

    public void handle(final AddMotoristCommand addMotoristCommand) {

    	Motorist motorist = Motorist.of(addMotoristCommand.getMotoristId(), addMotoristCommand.getDescription());
    	if (motoristDomainRepository.findByName(motorist.getDescription()) != null) {
    	    //throw new BusinessAlertException("Já existe um Motorista com esse nome.");
    	} else {
    		motoristDomainRepository.store(motorist);
    	}
    }
}