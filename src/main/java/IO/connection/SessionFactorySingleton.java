package IO.connection;

import IO.model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {
    private SessionFactorySingleton() {
    }

    private static class SessionFactoryHelper {
        static org.hibernate.service.ServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
        private static final SessionFactory INSTANCE =
                new MetadataSources(registry)
                        .addAnnotatedClass(Person.class)
                        .buildMetadata()
                        .buildSessionFactory();
    }

    public static SessionFactory getInstance() {
        return SessionFactoryHelper.INSTANCE;
    }
}
