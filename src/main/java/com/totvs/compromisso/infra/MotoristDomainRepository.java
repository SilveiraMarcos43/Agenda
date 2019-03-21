package com.totvs.compromisso.infra;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.totvs.compromisso.domain.IMotoristRepository;
import com.totvs.compromisso.domain.Motorist;
import com.totvs.compromisso.domain.fields.Description;
import com.totvs.compromisso.domain.fields.UniqueId;
import com.totvs.compromisso.infra.interfaces.IMotoristModelRepository;

@Repository
public class MotoristDomainRepository implements IMotoristRepository{

    @Autowired
    private IMotoristModelRepository repository;

    @Lazy
    @Autowired
    private ConversionService conversionService;

    @Transactional(readOnly = true)
    public Optional<Motorist> get(final UniqueId id) {

        try {
            return id == null ? Optional.empty()
                    : Optional.ofNullable(conversionService.convert(repository.getOne(id.toString()), Motorist.class));
        } catch (EntityNotFoundException e) {
            return Optional.empty();
        }
    }

    public void store(final Motorist motorist) {
   		repository.save(conversionService.convert(motorist, MotoristModel.class));
    }
    
    public List<Motorist> findAll() {
        return repository.findAll().stream().map(motorist -> conversionService.convert(motorist, Motorist.class)).collect(Collectors.toList());
    }
    
    public Motorist findByName(Description description) {
    	try {
    		return findByName(description);	
    		
    	}catch (EntityNotFoundException e) {
            return null;
    	}    	
    }
}
