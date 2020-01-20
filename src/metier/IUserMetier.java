package metier;

import java.util.List;

import entities.User;

public interface IUserMetier {
		public void ajoutUser(User u);
		public List<User> afficher();
}