package IO.repository;

import IO.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersonRepository {

    private SessionFactory sessionFactory;

    public PersonRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Person saveOrUpdate(Person person) {
        Session session = sessionFactory.getCurrentSession();
        if (person.getId() == null)
            session.persist(person);
        else
            session.merge(person);
        return person;
    }


}
