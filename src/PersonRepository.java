import java.util.List;

public interface PersonRepository {

    Person findById(int id);

    int total();

    Person max();

    List<Person> gfindByName(String name);
}
