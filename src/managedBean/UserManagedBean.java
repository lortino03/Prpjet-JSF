package managedBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entities.User;
import metier.UserMetier;

public class UserManagedBean {
	
	private User user;
	private UserMetier umetier;
	private List<User> users;
	
	
	public UserManagedBean() {
		user= new User();
		umetier= new UserMetier();
		users=new ArrayList<>();
		
	}

	
					public User getUser() {
						return user;
					}
				
					public void setUser(User user) {
						this.user = user;
					}
				
					public UserMetier getUmetier() {
						return umetier;
					}
				
					public void setUmetier(UserMetier umetier) {
						this.umetier = umetier;
					}
					public List<User> getUsers() {
						return users;
					}

					public void setUsers(List<User> users) {
						this.users = users;
					}


	public UserManagedBean(User user, UserMetier umetier) {
		super();
		this.user = user;
		this.umetier = umetier;
	}

						
						@Override
						public String toString() {
							return "UserManagedBean [user=" + user + ", umetier=" + umetier + "]";
						}

	public void ajouter() {
		umetier.ajoutUser(user);
		user=new User();

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User added!",
				"login" + user.getLogin() + "mot de passe:" + user.getPwd()));

	}

	public void ajouterUser() throws IOException {
		User utilisateur=umetier.getUserByLogin(user.getLogin());
		umetier.ajoutUser(user);
		user=new User();
			
		FacesContext fcontex= FacesContext.getCurrentInstance();// on instancie l'obejt facescontex pour avoir acces aux donner de la requette
		ExternalContext externalcontext= fcontex.getExternalContext();
		externalcontext.redirect(externalcontext.getRequestContextPath()+"/home.xhtml");
		
		HttpSession session =(HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		// recuperer le login utilisateur
		session.setAttribute("login", utilisateur.getLogin());
		
	}
	
	public void authentifier() throws IOException {
		
		User utilisateur=umetier.getUserByLogin(user.getLogin()); 
		 
		if (utilisateur != null) {
			
			if (utilisateur.getPwd().equals(user.getPwd())) {
				FacesContext fcontext = FacesContext.getCurrentInstance();   
				ExternalContext externcontext = fcontext.getExternalContext();
				externcontext.redirect(externcontext.getRequestContextPath() + "/home.xhtml");

			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "probleme de connexion", "le pass n'est pas valide"));

			}
		}

		else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "probleme de connexion", "login invalide"));
			FacesContext fcontext = FacesContext.getCurrentInstance();
			//ExternalContext externcontext = fcontext.getExternalContext();
			//externcontext.redirect(externcontext.getRequestContextPath() + "/inscription.xhtml");
			
			// creer la session   Ajouter avec la prof-- user model ici est utilisateur
			HttpSession session =(HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			// recuperer le login utilisateur
			session.setAttribute("login", utilisateur.getLogin());
			
		}

	}
	
	public void logout() {
		
		FacesContext ctx= FacesContext.getCurrentInstance();
		ExternalContext extcontext= ctx.getExternalContext();
		extcontext.invalidateSession();
		try{
			extcontext.redirect(extcontext.getRequestContextPath()+"/inscription.xhtml");
		} catch (IOException e) {
			e.setStackTrace(null);
		}
	}

}
