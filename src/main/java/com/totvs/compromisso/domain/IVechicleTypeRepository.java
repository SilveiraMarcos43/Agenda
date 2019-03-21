package com.totvs.compromisso.domain;

import java.util.List;
import java.util.Optional;

import com.totvs.compromisso.domain.fields.UniqueId;

public interface IVechicleTypeRepository {

    public Optional<VechicleType> get(final UniqueId id);

    public void store(final VechicleType vechicleType);
    
    public List<VechicleType> findAll();
    
}
