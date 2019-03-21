package com.totvs.compromisso.domain;

import java.util.List;
import java.util.Optional;

import com.totvs.compromisso.domain.fields.UniqueId;

public interface IMotoristRepository {

    public Optional<Motorist> get(final UniqueId id);

    public void store(final Motorist motorist);
    
    public List<Motorist> findAll();
    
}
