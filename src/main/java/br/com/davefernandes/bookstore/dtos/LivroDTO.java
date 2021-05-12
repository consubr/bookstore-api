package br.com.davefernandes.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.davefernandes.bookstore.domain.Livro;

public class LivroDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Campo TÍTULO é Obrigatório" )
	@Length(min = 3, max = 50, message = "TÍTULO deve ter no Mínimo 3 e no Máximo 50 Caracteres!")
	private String titulo;
	
	@NotEmpty(message = "Campo NOME_AUTOR é Obrigatório" )
	@Length(min = 3, max = 100, message = "NOME_AUTOR deve ter no Mínimo 3 e no Máximo 100 Caracteres!")
	private String nome_autor;
	
	public LivroDTO() {
		super();
	}

	public LivroDTO(Livro obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.nome_autor = obj.getNome_autor();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroDTO other = (LivroDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}
