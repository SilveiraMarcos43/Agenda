package com.totvs.compromisso.infra.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.totvs.compromisso.domain.fields.Description;
import com.totvs.compromisso.infra.MotoristModel;

public interface IMotoristModelRepository extends JpaRepository<MotoristModel, String> {
	
	public void findDescription(Description description);
	
	
}
