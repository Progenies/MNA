package com.progenies.mna.dao.internal.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.progenies.mna.dao.impl.AbstractDAO;
import com.progenies.mna.dao.internal.UsersDAO;
import com.progenies.mna.model.internal.User;

@Repository(value="usersDAO")
public class JPAUsersDAO extends AbstractDAO implements UsersDAO
{
	

	@Override
	@Transactional(readOnly=true)
	public User getUserByID(Long idUser) {
		return em.find(User.class, idUser);
	}

	@Override
	@Transactional(readOnly=true)
	public User getUserByLogin(String login) {
		return em.createNamedQuery("findByLogin", User.class).setParameter("login", login).getSingleResult();
	}

	@Override
	@Transactional
	public User insertUser(User user) {
		em.persist(user);
		em.refresh(user);
		em.flush();
		return user;
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		return em.merge(user);
	}
	

	@Override
	@Transactional
	public void updateUserExceptPassword(User user)
	{
		//recupero el usuario original
		User origUser=getUserByID(user.getIdUser());
		
		//actualizo, del usuario a guardar, la contraseña
		user.setPassword(origUser.getPassword());
		
		//guardo, dejando la contraseña original
		em.merge(user);
		
	}

	@Override
	@Transactional
	public void deleteUser(User user)
	{
		//Es necesario hacer el merge por si el objeto está "desconectado" de la transaccion.
		//Dan igual sus valores, al fin y al cabo lo vamos a borrar
		em.remove(em.merge(user));
	}

	@Override
	public List<User> findAllUsers()
	{
		return em.createNamedQuery("findAllUsers", User.class).getResultList();
	}


}
