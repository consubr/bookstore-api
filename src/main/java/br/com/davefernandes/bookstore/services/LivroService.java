package br.com.davefernandes.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.davefernandes.bookstore.domain.Categoria;
import br.com.davefernandes.bookstore.domain.Livro;
import br.com.davefernandes.bookstore.repositories.LivroRepository;
import br.com.davefernandes.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ModelMapper modelMapper;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não Encontrado! Id: " + id + ", Tipo: " + Livro.class.getSimpleName()));
	}

	public List<Livro> findAll() {
		return repository.findAll();
	}

	public Livro create(Integer id_cat, Livro obj) {
		//se não achar dispara erro 404
		Categoria objFinded  = categoriaService.findById(id_cat);

		obj.setId(null);
		obj.setCategoria(objFinded);
		return repository.save(obj);
	}

	public Livro update(Integer id, Livro obj) {
		// se existe traz, se não dispara erro 404
		Livro livro = findById(id);

		// se chegou aqui é pq existe
		obj.setId(id);
		obj.setCategoria(livro.getCategoria());
		return repository.save(obj);
	}
	
	public Livro updatePatch(Integer id, Livro obj) {
		// se existe traz, se não dispara erro 404
		Livro livro = findById(id);

		// se chegou aqui é pq existe
		//update parcial		
		obj.setId(id);
		return repository.save(modelMapper.map(obj, Livro.class));
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
