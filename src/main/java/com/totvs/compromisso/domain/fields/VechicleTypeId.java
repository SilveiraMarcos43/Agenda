package com.totvs.compromisso.domain.fields;

import java.util.UUID;

public class VechicleTypeId extends UniqueId {

    protected VechicleTypeId(UUID value) {
        super(value);
    }

    public static VechicleTypeId generate() {
        return new VechicleTypeId(UUID.randomUUID());
    }

    public static VechicleTypeId fromString(String value) {
        return value == null ? null : new VechicleTypeId(UUID.fromString(value));
    }
}
