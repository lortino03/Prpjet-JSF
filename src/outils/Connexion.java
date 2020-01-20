package outils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Connexion {

		private  SessionFactory factory;
		private Session session; 
		public static Connexion instance=null;
			
		private Connexion(){
			
			 Configuration configuration = new Configuration();
			 configuration.configure();
			 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
			configuration.getProperties()). buildServiceRegistry();
			 factory = configuration.buildSessionFactory(serviceRegistry);
			 session=factory.openSession();
			
		}
		
		public static  Connexion getInstance() {
			
			if(instance==null)
				instance=new Connexion();
			return instance;
		}

		public Session getSession() {
			return session;
		}

		public void setSession(Session session) {
			this.session = session;
		}
		    
		
		
		

	


}
