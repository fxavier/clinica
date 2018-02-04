package com.xavier.clinica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xavier.clinica.model.Entidade;
import com.xavier.clinica.service.EntidadeService;
import com.xavier.clinica.service.exception.CadastroEntidadeException;


@Controller
@RequestMapping("/entidades")
public class Entidadescontroller {
	
	@Autowired
	private EntidadeService entidadeService;
	
	
	@RequestMapping("/nova")
	public ModelAndView nova(Entidade entidade) {
		ModelAndView mv = new ModelAndView("entidade/CadastroEntidade");
		return mv;
	}
	
	@RequestMapping(value = "/nova", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Entidade entidade, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return nova(entidade);
		}
		
		try {
			entidadeService.salvar(entidade);
		} catch(CadastroEntidadeException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return nova(entidade);
		}
		
		attributes.addFlashAttribute("mensagem", "Entidade  " + entidade.getNome()+ "   adicionado com sucesso!");
		return new ModelAndView("redirect:/entidades/nova");
	}

}
