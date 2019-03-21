package com.totvs.compromisso.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.totvs.compromisso.domain.VechicleType;
import com.totvs.compromisso.infra.VechicleTypeDomainRepository;

@Service
@Transactional
public class VechicleTypeApplicationService {

    @Autowired
    private VechicleTypeDomainRepository vechicleTypeDomainRepository;

    public void handle(final AddVechicleTypeCommand addVechicleTypeCommand) {

    	VechicleType vechicleType = VechicleType.of(addVechicleTypeCommand.getVechicleTypeId(), addVechicleTypeCommand.getDescription());

    	vechicleTypeDomainRepository.store(vechicleType);
    }
}
