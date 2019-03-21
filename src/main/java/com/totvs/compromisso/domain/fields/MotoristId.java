package com.totvs.compromisso.domain.fields;

import java.util.UUID;

public class MotoristId extends UniqueId {

    protected MotoristId(UUID value) {
        super(value);
    }

    public static MotoristId generate() {
        return new MotoristId(UUID.randomUUID());
    }

    public static MotoristId fromString(String value) {
        return value == null ? null : new MotoristId(UUID.fromString(value));
    }
}