package com.totvs.compromisso.domain;

import static com.totvs.compromisso.common.validation.ValidationUtils.assertIntegrity;

import javax.validation.constraints.NotNull;

import com.totvs.compromisso.domain.fields.Description;
import com.totvs.compromisso.domain.fields.MotoristId;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Motorist {
	
	@NotNull(message = "sample.motorist.id.null")
	private final MotoristId id;
	
	@NotNull(message = "sample.description.id.null")
	private final Description description;
	

    public static Motorist of(final MotoristId id, final Description description) {
        return new Motorist(id, description);
    }

    public Motorist(MotoristId id, Description description) {

        this.id = id;
        this.description = description;

        assertIntegrity(this);
    }	
}
