package IO;

import IO.model.Person;
import IO.service.PersonService;
import IO.utility.ApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String filePath = "D:/JAVA107/weak25/HW18/src/main/java/IO/person.txt";
        PersonService personService = ApplicationContext.getPersonService();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] fields = line.split(",");

                if (fields.length == 4) {

                    String firstName = fields[0].trim();
                    String lastName = fields[1].trim();
                    String userName = fields[2].trim();
                    int age = Integer.parseInt(fields[3].trim());

                    Person person = new Person(firstName, lastName, userName, age);
                    personService.saveOrUpdate(person);
                }
            }
            System.out.println("The operation was done .");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
