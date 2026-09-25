import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {
    private List<Person> people;

    public PersonRepositoryImpl(List<Person> people) {
        this.people = people;
    }

    @Override
    public Person findById(int id) {
        Person p = null;
        for (Person person : people) {
            if (person.getId() == id) {
                p = person;
            }
        }
        return p;
    }
}
