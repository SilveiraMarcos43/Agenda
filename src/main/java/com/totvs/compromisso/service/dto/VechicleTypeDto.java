package com.totvs.compromisso.service.dto;

import java.util.Objects;

public class VechicleTypeDto {
    private Long id;
    
    private String description;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}

	VechicleTypeDto vechicleTypeDto = (VechicleTypeDto) o;
	if (vechicleTypeDto.getId() == null || getId() == null) {
	    return false;
	}
	return Objects.equals(getId(), vechicleTypeDto.getId());
    }

    @Override
    public int hashCode() {
	return Objects.hashCode(getId());
    }    

	@Override
	public String toString() {
		return "VechicleTypeDto [id=" + id + ", description=" + description + "]";
	}

}
