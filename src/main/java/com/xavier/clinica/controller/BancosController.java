package com.xavier.clinica.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xavier.clinica.controller.page.PageWrapper;
import com.xavier.clinica.model.Banco;
import com.xavier.clinica.repository.Bancos;
import com.xavier.clinica.repository.filter.BancoFilter;
import com.xavier.clinica.service.CadastroBancoService;
import com.xavier.clinica.service.exception.CadastroBancoException;

@Controller
@RequestMapping("/bancos")
public class BancosController {
	
	@Autowired
	private CadastroBancoService service;
	
	@Autowired
	private Bancos bancos;
	
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
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(banco);
		}
		
		attributes.addFlashAttribute("mensagem","Banco adicionado com sucesso!");
		return new ModelAndView("redirect:/bancos/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(BancoFilter bancoFilter, BindingResult result, 
			@PageableDefault(size = 5) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("banco/PesquisaBancos");
		PageWrapper<Banco> pageWrapper = new PageWrapper<>(bancos.filtrar(bancoFilter, pageable), httpServletRequest);
		mv.addObject("pagina", pageWrapper);
		return mv;
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable Long codigo) {
		Banco banco = bancos.findBycodigo(codigo);
		ModelAndView mv = novo(banco);
		mv.addObject(banco);
		return mv;
	}

}
