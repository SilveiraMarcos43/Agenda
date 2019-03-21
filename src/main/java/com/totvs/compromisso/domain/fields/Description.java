package com.totvs.compromisso.domain.fields;

import static com.totvs.compromisso.common.validation.ValidationUtils.assertIntegrity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Description {

    @NotNull(message = "sample.description.null")
    @Size(min = 10, message = "sample.description.size")
    private String _description;

    public Description(String description) {

        this._description = description;

        assertIntegrity(this);
    }

    public boolean equals(Object anObject) {

        boolean equalObjects = false;

        if (anObject != null && this.getClass() == anObject.getClass()) {

        	Description typedObject = (Description) anObject;
            equalObjects = this._description.equals(typedObject._description);
        }

        return equalObjects;
    }

    @Override
    public int hashCode() {

        int hashCodeValue = +(43685 * 83) + this._description.hashCode();

        return hashCodeValue;
    }

    @Override
    public String toString() {
        return _description;
    }
}
