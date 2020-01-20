package metier;

import java.util.List;

import dao.UserDAO;
import entities.User;

public class UserMetier implements IUserMetier {
	private UserDAO dao=new UserDAO();
	
	public void ajoutUser(User u) {
		dao.ajoutUser(u);
		
	}


	public List<User> afficher() {
		
		return dao.afficher();
	}

	public User getUserByLogin(String login) {
		return dao.getUserById(login);
	}

}
