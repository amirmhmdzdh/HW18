package IO.utility;

import IO.connection.SessionFactorySingleton;
import IO.repository.PersonRepository;
import IO.service.PersonService;
import org.hibernate.SessionFactory;

public class ApplicationContext {
    private static final SessionFactory SESSION_FACTORY;

    private static final PersonRepository PERSON_REPOSITORY;
    private static final PersonService PERSON_SERVICE;

    static {

        SESSION_FACTORY = SessionFactorySingleton.getInstance();

        PERSON_REPOSITORY = new PersonRepository(SESSION_FACTORY);
        PERSON_SERVICE = new PersonService(PERSON_REPOSITORY, SESSION_FACTORY);
    }

    public static PersonService getPersonService() {
        return PERSON_SERVICE;
    }
}
