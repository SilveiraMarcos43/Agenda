package com.totvs.compromisso.app;

import com.totvs.compromisso.domain.fields.Description;
import com.totvs.compromisso.domain.fields.MotoristId;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class AddMotoristCommand {

    public static AddMotoristCommand of(final MotoristId motoristId, final Description description) {
        return new AddMotoristCommand(motoristId, description);
    }

    private MotoristId motoristId;

    private Description description;

}