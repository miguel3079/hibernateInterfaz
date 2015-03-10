package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtil {
	private static SessionFactory sessionFactory;
	 private static ServiceRegistry serviceRegistry;
	 static {
	 Configuration configuration = new Configuration();
	 configuration.configure();
	 serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	 configuration.getProperties()).build();
	 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	 }


	 public static SessionFactory getSessionFactory(){
	 return sessionFactory;
	 }
}
