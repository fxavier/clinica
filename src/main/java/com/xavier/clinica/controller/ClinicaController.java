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

import com.xavier.clinica.model.Clinica;
import com.xavier.clinica.repository.Clinicas;


@Controller
@RequestMapping("/clinicas")
public class ClinicaController {
	
	@Autowired
	private Clinicas clinicas;
	
	@RequestMapping("/nova")
	public ModelAndView nova(Clinica clinica) {
		ModelAndView mv = new ModelAndView("clinica/CadastroClinica");
		return mv;
	}
	

	@RequestMapping(value = "/nova", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Clinica clinica, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return nova(clinica);
		}
		
		clinicas.save(clinica);
		attributes.addFlashAttribute("mensagem", "Clinica Configurada com sucesso!");
		
		return new ModelAndView("redirect:/clinicas");
	}
	
//	public ModelAndView pesquisar(ClinicaFilter clinicaFilter, )
}
