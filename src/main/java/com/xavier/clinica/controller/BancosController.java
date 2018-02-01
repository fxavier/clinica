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

import com.xavier.clinica.model.Banco;
import com.xavier.clinica.service.CadastroBancoService;
import com.xavier.clinica.service.exception.CadastroBancoException;

@Controller
@RequestMapping("/bancos")
public class BancosController {
	
	@Autowired
	private CadastroBancoService service;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Banco banco) {
		ModelAndView mv = new ModelAndView("banco/CadastroBanco");
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Banco banco, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(banco);
		}
		
		try {
			service.salvar(banco);
		} catch(CadastroBancoException e) {
			result.rejectValue("mensagem", e.getMessage(), e.getMessage());
		}
		
		attributes.addFlashAttribute("mensagem","Banco adicionado com sucesso!");
		return new ModelAndView("redirect:/bancos/novo");
	}

}
