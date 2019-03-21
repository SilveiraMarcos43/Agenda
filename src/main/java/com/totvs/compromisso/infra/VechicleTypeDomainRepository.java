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

import com.totvs.compromisso.domain.IVechicleTypeRepository;
import com.totvs.compromisso.domain.VechicleType;
import com.totvs.compromisso.domain.fields.UniqueId;
import com.totvs.compromisso.infra.interfaces.IVechicleTypeModelRepository;

@Repository
public class VechicleTypeDomainRepository implements IVechicleTypeRepository{

    @Autowired
    private IVechicleTypeModelRepository repository;

    @Lazy
    @Autowired
    private ConversionService conversionService;

    @Transactional(readOnly = true)
    public Optional<VechicleType> get(final UniqueId id) {

        try {
            return id == null ? Optional.empty()
                    : Optional.ofNullable(conversionService.convert(repository.getOne(id.toString()), VechicleType.class));
        } catch (EntityNotFoundException e) {
            return Optional.empty();
        }
    }

    public void store(final VechicleType vechicleType) {
        repository.save(conversionService.convert(vechicleType, VechicleTypeModel.class));
    }
    
    public List<VechicleType> findAll() {
        return repository.findAll().stream().map(vechicleType -> conversionService.convert(vechicleType, VechicleType.class)).collect(Collectors.toList());
    }
}
