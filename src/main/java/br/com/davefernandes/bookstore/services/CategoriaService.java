package br.com.davefernandes.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.davefernandes.bookstore.domain.Categoria;
import br.com.davefernandes.bookstore.repositories.CategoriaRepository;
import br.com.davefernandes.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não Encontrado! Id: " + id + ", Tipo: " + Categoria.class.getSimpleName()));
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, Categoria obj) {
		// se existe traz, se não dispara erro 404
		findById(id);

		// se chegou aqui é pq existe
		obj.setId(id);
		return repository.save(obj);
	}
}
