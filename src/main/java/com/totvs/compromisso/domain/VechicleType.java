package com.totvs.compromisso.domain;

import static com.totvs.compromisso.common.validation.ValidationUtils.assertIntegrity;

import javax.validation.constraints.NotNull;

import com.totvs.compromisso.domain.fields.Description;
import com.totvs.compromisso.domain.fields.VechicleTypeId;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VechicleType extends AuditModel {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "sample.vechicleType.id.null")
    private final VechicleTypeId id;

    @NotNull(message = "sample.vechicleType.description.null")
    private Description description;

    public static VechicleType of(final VechicleTypeId id, final Description description) {
        return new VechicleType(id, description);
    }

    public VechicleType(VechicleTypeId id, Description description) {

        this.id = id;
        this.description = description;

        assertIntegrity(this);
    }
}