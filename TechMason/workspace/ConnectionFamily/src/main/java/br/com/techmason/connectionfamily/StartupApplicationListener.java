package br.com.techmason.connectionfamily;

import org.springframework.stereotype.Component;

import br.com.techmason.connectionfamily.domain.mensagem.Mensagens;
import br.com.techmason.connectionfamily.domain.mensagem.RepositorioMensagens;
import br.com.techmason.connectionfamily.domain.usuario.RepositorioUsuario;
import br.com.techmason.connectionfamily.domain.usuario.Usuario;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Component
public class StartupApplicationListener {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioMensagens repositorioMensagens;
	
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Usuario user1 = new Usuario();
		user1.setId("Tech");
		user1.setNome("TechMason");
		repositorioUsuario.save(user1);
		
		Usuario user2 = new Usuario();
		user2.setId("Sky");
		user2.setNome("TechMemory");
		repositorioUsuario.save(user2);
		
		
		Mensagens user1_m1 = new Mensagens();
		user1_m1.setDataHora(LocalDateTime.now().minusMinutes(45));
		user1_m1.setTexto("Bem vindo ao Conection family");
		user1_m1.setUsuario(user1);
		repositorioMensagens.save(user1_m1);
		
		Mensagens user1_m2 = new Mensagens();
		user1_m2.setDataHora(LocalDateTime.now().minusMinutes(42));
		user1_m1.setTexto("Conection Family conectando familias");
		user1_m1.setUsuario(user1);
		repositorioMensagens.save(user1_m1);
		
		
		Mensagens user2_m1 = new Mensagens();
		user2_m1.setDataHora(LocalDateTime.now().minusMinutes(27));
		user2_m1.setTexto("Familia! Vocês sabiam, que o mundo tecnologicos esta mudando rapidamente todos os dias");
		user2_m1.setUsuario(user2);
		repositorioMensagens.save(user2_m1);
		
		Mensagens user2_m2 = new Mensagens();
		user2_m2.setDataHora(LocalDateTime.now().minusMinutes(22));
		user2_m2.setUsuario(user2);
		user2_m2.setTexto("Todos temos liberdade, na tecnologia não é diferente.");
		repositorioMensagens.save(user2_m2);
		
		
		
	}

}
