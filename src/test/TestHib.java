package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import metier.ProduitMetier;

public class TestHib {
	
	public static SessionFactory factory;

	public static void main(String[] args) {
		
		 Configuration configuration = new Configuration();
		 configuration.configure();
		 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
		configuration.getProperties()). buildServiceRegistry();
		 factory = configuration.buildSessionFactory(serviceRegistry);
		 Session session=factory.openSession();
		
		
		 
	
	
	
	
	}

}
