import java.util.ArrayList;
import java.util.Collection;


public class PersonService {
	
	private Collection<Person> persons = new ArrayList<Person>();
	public PersonService(){
		persons.add(new Person(11, "AA"));
		persons.add(new Person(12, "BB"));
		persons.add(new Person(13, "CC"));
	}
	
	public Collection<Person> getPersons(){
		
		return persons;
	}

}
