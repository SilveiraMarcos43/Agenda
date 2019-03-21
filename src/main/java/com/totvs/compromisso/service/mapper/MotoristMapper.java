package com.totvs.compromisso.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.totvs.compromisso.domain.Motorist;
import com.totvs.compromisso.domain.fields.Description;
import com.totvs.compromisso.domain.fields.MotoristId;
import com.totvs.compromisso.infra.MotoristModel;

@Component
public class MotoristMapper {
	
    @Lazy
    @Autowired
    private ConversionService conversionService;
	
	@Component
	public class MotoristModelToEntity implements Converter<MotoristModel, Motorist> {	
	
        @Override
        public Motorist convert(final MotoristModel source) {
            return Motorist.builder().id(MotoristId.fromString(source.getId())).description(new Description(source.getDescription())).build();
        }
    }

    @Component
    public class MotoristEntityToModel implements Converter<Motorist, MotoristModel> {

        @Override
        public MotoristModel convert(final Motorist source) {
            return MotoristModel.builder().id(source.getId().toString()).description(source.getDescription().toString()).build();
        }
    }

}

