package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import entities.User;
import outils.Connexion;

public class UserDAO implements IUserDAO{
	private Session session;

	public UserDAO() {

		session = Connexion.getInstance().getSession();
	}

	public void ajoutUser(User u) {

		Transaction transaction = session.beginTransaction();
		session.persist(u);
		transaction.commit();

	}

	@Override
	public List<User> afficher() {
		List<User> users=session.createQuery(" from Utilisateur u ").list();
        if (!users.isEmpty()) {
            System.out.println(users);
            return users;
        }
        else {
            System.err.println("Il n'y a pas d'utilisateur.");
        }
		return null;
	}
	public User getUserById(String login) {
		List<User> users= session.createQuery(" from User u where u.login=:login").setParameter("login", login).list();
		if(!users.isEmpty())
		return users.get(0);
		return null;
	}

}
