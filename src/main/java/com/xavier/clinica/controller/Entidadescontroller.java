package com.xavier.clinica.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xavier.clinica.controller.page.PageWrapper;
import com.xavier.clinica.model.Entidade;
import com.xavier.clinica.repository.Entidades;
import com.xavier.clinica.repository.filter.EntidadeFilter;
import com.xavier.clinica.service.EntidadeService;
import com.xavier.clinica.service.exception.CadastroEntidadeException;
import com.xavier.clinica.service.exception.ImpossivelExcluirEntidadeException;


@Controller
@RequestMapping("/entidades")
public class EntidadesController {
	
	@Autowired
	private EntidadeService entidadeService;
	
	@Autowired
	private Entidades entidades;
	
	
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
	
	@GetMapping
	public ModelAndView pesquisar(EntidadeFilter entidadeFilter, BindingResult result,
			@PageableDefault(size = 5) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("entidade/PesquisaEntidades");
		PageWrapper<Entidade> pageWrapper = new PageWrapper<>(entidades.filtrar(entidadeFilter, pageable), httpServletRequest);
		mv.addObject("pagina", pageWrapper);
		return mv;
				
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Entidade entidade) {
		ModelAndView mv = nova(entidade);
		mv.addObject(entidade);
		return mv;
	}
	
	@DeleteMapping("/{codigo}")
	public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Entidade entidade){
		try {
			entidadeService.excluir(entidade);
		} catch(ImpossivelExcluirEntidadeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok().build();
	}
}	
