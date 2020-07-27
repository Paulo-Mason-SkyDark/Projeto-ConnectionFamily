package br.com.techmason.connectionfamily.domain.mensagem;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.techmason.connectionfamily.domain.usuario.Usuario;

@Entity
public class Mensagens {
	
	@Id
	@GeneratedValue
	private int id;
	private LocalDateTime dataHora;
	private String texto;
	
	@ManyToOne
	private Usuario usuario;
	
	private int brilhante;
	
	public long calcularTempo(){
		
		return ChronoUnit.MINUTES.between(dataHora, LocalDateTime.now());
	}
	
	public void  brilhar(){
		
		brilhante++;
	}
	
	
	public int getId() {
		
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
		
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
		
	}
	
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
		
	}
	
	public String getTexto() {
		return texto;
		
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
		
	}
	
	public Usuario getUsuario() {
		
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		
		this.usuario = usuario;
	}
	
	public int getBrilhar() {
		
		return brilhante;
	}

}
