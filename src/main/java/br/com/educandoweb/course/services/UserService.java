package br.com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educandoweb.course.entities.User;
import br.com.educandoweb.course.repositories.UserRepository;

// SERVE COMO INTERMEDIADOR DO CONTROLLER COM O USUARIO

// TODOS SERVICE TEM QUE TER @Service 
@Service
public class UserService{
	
	@Autowired
	private UserRepository repository;
	
	// RETORNA TODOS OS USUARIOS DO REPOSITORIO
	public List<User> findAll(){
		return repository.findAll();
	}
	
	// BUSCA O USUARIO POR ID
	public User findById(Long id) {
		Optional<User> obj= repository.findById(id);
		return obj.get();
	}
	
	// SALVA NO BANCO DE DADOS UM USUARIO
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	// DELETE DO BANCO DE DADOS O USUARIO
	public void delete(Long id) {
		 repository.deleteById(id);
	}
	
	//ATUALIZAR UM USUARIO
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	// METODO RESPONSAVEL PELA ATUALIZACAO DAS INFORMAÇÕES
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
