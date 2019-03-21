package com.totvs.compromisso.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.totvs.compromisso.domain.VechicleType;
import com.totvs.compromisso.domain.fields.Description;
import com.totvs.compromisso.domain.fields.VechicleTypeId;
import com.totvs.compromisso.infra.VechicleTypeModel;

@Component
public class VechicleTypeMapper {
	
    @Lazy
    @Autowired
    private ConversionService conversionService;
	
	@Component
	public class VechicleTypeModelToEntity implements Converter<VechicleTypeModel, VechicleType> {	
	
        @Override
        public VechicleType convert(final VechicleTypeModel source) {
            return VechicleType.builder().id(VechicleTypeId.fromString(source.getId())).description(new Description(source.getDescription())).build();
        }
    }

    @Component
    public class VechicleTypeEntityToModel implements Converter<VechicleType, VechicleTypeModel> {

        @Override
        public VechicleTypeModel convert(final VechicleType source) {
            return VechicleTypeModel.builder().id(source.getId().toString()).description(source.getDescription().toString()).build();
        }
    }

}

