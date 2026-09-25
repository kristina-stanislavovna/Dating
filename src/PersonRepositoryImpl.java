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
    @Override
    public int total() {
        int total = 0;
        for (Person person : people) {
            total += person.getAge();
        }
        return total;
    }
    @Override
    public Person max() {
        Person maxPerson = null;
        int max = 0;
        for (Person person : people) {
            if (person.getAge() > max) {
                maxPerson = person;
                max = person.getAge();
            }
        }
        return maxPerson;
    }

    @Override
    public List<Person> gfindByName(String name) {
        List<Person> p = new ArrayList<>();
        for (Person person : people) {
            if (person.getName().equals(name)) {
                p.add(person);
            }
        }
        return p;
    }

}
