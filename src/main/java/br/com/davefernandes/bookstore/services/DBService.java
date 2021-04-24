package br.com.davefernandes.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.davefernandes.bookstore.domain.Categoria;
import br.com.davefernandes.bookstore.domain.Livro;
import br.com.davefernandes.bookstore.repositories.CategoriaRepository;
import br.com.davefernandes.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	LivroRepository livroRepository;
	
	public void instanciaDB() {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Livros de Ficção Científica");
		Categoria cat3 = new Categoria(null, "Biografia", "Livros de Biografias");
		
		Livro l1 = new Livro(null, "Clean Code", "Nome Autor", "texto do livro", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis5", "texto do livro", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "Wells", "texto do livro", cat2);
		Livro l4 = new Livro(null, "War of The Worlds", "H.G", "texto do livro", cat2);
		Livro l5 = new Livro(null, "II Robot", "Isaac Asimov", "texto do livro", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
		
	}

}
