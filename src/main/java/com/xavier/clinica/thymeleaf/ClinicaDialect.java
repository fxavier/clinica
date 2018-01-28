package com.xavier.clinica.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import com.xavier.clinica.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import com.xavier.clinica.thymeleaf.processor.MenuAttributeTagProcessor;
import com.xavier.clinica.thymeleaf.processor.MessageElementTagProcessor;
import com.xavier.clinica.thymeleaf.processor.OrderElementTagProcessor;
import com.xavier.clinica.thymeleaf.processor.PaginationElementTagProcessor;



@Component
public class ClinicaDialect extends AbstractProcessorDialect {

	public ClinicaDialect() {
		super("Evolve clinica", "clinica", StandardDialect.PROCESSOR_PRECEDENCE);
	}
	
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		processadores.add(new OrderElementTagProcessor(dialectPrefix));
		processadores.add(new PaginationElementTagProcessor(dialectPrefix));
		processadores.add(new MenuAttributeTagProcessor(dialectPrefix));
		return processadores;
	}

}
