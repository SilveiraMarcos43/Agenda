package com.totvs.compromisso.infra.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.totvs.compromisso.infra.VechicleTypeModel;

public interface IVechicleTypeModelRepository extends JpaRepository<VechicleTypeModel, String> {
}
