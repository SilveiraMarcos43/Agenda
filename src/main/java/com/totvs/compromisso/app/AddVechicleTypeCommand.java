package com.totvs.compromisso.app;

import com.totvs.compromisso.domain.fields.Description;
import com.totvs.compromisso.domain.fields.VechicleTypeId;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class AddVechicleTypeCommand {

    public static AddVechicleTypeCommand of(final VechicleTypeId vechicleTypeId, final Description description) {
        return new AddVechicleTypeCommand(vechicleTypeId, description);
    }

    private VechicleTypeId vechicleTypeId;

    private Description description;

}
