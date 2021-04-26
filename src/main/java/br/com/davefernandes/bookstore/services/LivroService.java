package br.com.davefernandes.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.davefernandes.bookstore.domain.Livro;
import br.com.davefernandes.bookstore.repositories.LivroRepository;
import br.com.davefernandes.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não Encontrado! Id: " + id + ", Tipo: " + Livro.class.getSimpleName()));
	}

	public List<Livro> findAll() {
		return repository.findAll();
	}

	public Livro create(Livro obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Livro update(Integer id, Livro obj) {
		// se existe traz, se não dispara erro 404
		findById(id);

		// se chegou aqui é pq existe
		obj.setId(id);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		// se existe traz, se não dispara erro 404
		findById(id);

		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new br.com.davefernandes.bookstore.services.exceptions.DataIntegrityViolationException(
					"Livro não pode ser Deletado!, pois possui Registros associados");
		}
	}

	public List<Livro> findAllByIdCategoria(Integer id_cat) {
		//se não achar dispara erro 404
		categoriaService.findById(id_cat);
		
		return repository.finAllByIdCategoria(id_cat);
	}
}
