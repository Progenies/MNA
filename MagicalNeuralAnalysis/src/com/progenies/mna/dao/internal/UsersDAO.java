package com.progenies.mna.dao.internal;

import java.util.List;

import com.progenies.mna.model.internal.User;

public interface UsersDAO
{
	
	
	public User getUserByID(Long idUser);
	public User getUserByLogin(String login);
	
	public List<User> findAllUsers();
	
	public User insertUser(User user);
	public User updateUser(User user);
	public void deleteUser(User user);

}
