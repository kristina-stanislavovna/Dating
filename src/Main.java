import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person(11, "Pavel", 40, Gender.MALE),
                new Person(12, "Anna", 35, Gender.FEMALE),
                new Person(13, "Marta", 30, Gender.FEMALE),
                new Person(14, "Alex", 25, Gender.MALE)
        );
        PersonRepository personRepository = new PersonRepositoryImpl(people);
        Person p = personRepository.findById(13);
        System.out.println(p);
    }
}
