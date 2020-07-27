package br.com.techmason.connectionfamily.controle;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.techmason.connectionfamily.domain.mensagem.Mensagens;
import br.com.techmason.connectionfamily.domain.mensagem.RepositorioMensagens;
import br.com.techmason.connectionfamily.domain.usuario.RepositorioUsuario;
import br.com.techmason.connectionfamily.domain.usuario.Usuario;





@Controller
@RequestMapping("/mensagens")
public class ControleMensagens {
	
	@Autowired
	private RepositorioMensagens repositorioMensagens;
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	
	@GetMapping(path = "/nova")
	public String nova(Model model) {
		Mensagens mensagens = new Mensagens();
		model.addAttribute("mensagens", mensagens);
		List<Usuario> usuarios = repositorioUsuario.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		
		model.addAttribute("usuarios", usuarios);
		return "Criando-Mensagens";
		
	}
	
	@PostMapping(path = "/criar")
	public String criar(Mensagens mensagens) {
		if(!mensagens.getTexto().isEmpty()) {
			mensagens.setDataHora(LocalDateTime.now());
			repositorioMensagens.save(mensagens);
		}
		
		return "redirect:/mensagens/listar";
	}
	
	@GetMapping(path = "/listar")
	public String listandoMensagens(Model model) {
		List<Mensagens> mensagens = repositorioMensagens.findAll(Sort.by(Sort.Direction.DESC, "dataHora"));
		model.addAttribute("mensagens", mensagens);
		
		return "Listando-Mensagens";
		
	}
	
	@GetMapping(path = "/brilhar")
	public String brilhar(@RequestParam("msgId") int msgId) {
		
		Mensagens mensagens = repositorioMensagens.findById(msgId).orElseThrow(null);
		mensagens.brilhar();
		repositorioMensagens.save(mensagens);
		return "redirect:/mensagens/listar";
	}
	
}
