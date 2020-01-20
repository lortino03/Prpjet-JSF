package dao;

import java.util.List;


import entities.User;

public interface IUserDAO {
	public void ajoutUser(User u);
	public List<User> afficher();


}
