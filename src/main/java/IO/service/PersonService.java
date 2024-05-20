package IO.service;

import IO.model.Person;
import IO.repository.PersonRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersonService {

    private PersonRepository personRepository;
    private SessionFactory sessionFactory;

    public PersonService(PersonRepository personRepository, SessionFactory sessionFactory) {
        this.personRepository = personRepository;
        this.sessionFactory = sessionFactory;
    }

    public Person saveOrUpdate(Person person) {
        Transaction transaction = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();

            personRepository.saveOrUpdate(person);

            transaction.commit();
            session.close();
            return person;
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            System.out.println(e.getMessage());
            return null;
        }
    }
}
