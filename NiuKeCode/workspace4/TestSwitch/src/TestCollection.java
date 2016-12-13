import java.util.ArrayList;
import java.util.Collection;


public class TestCollection {
	
	private static PersonService personService = new PersonService();
	
	public static void main(String[] args) {
		
		Collection<Person> persons = new ArrayList<Person>();
		Collection<Person> items = personService.getPersons();
		
		Person person = new Person();
		for(Person p:items){
			person.setAge(p.getAge());
			person.setName(p.getName());
			persons.add(person);
		}
		
		System.out.println(persons);
		
	}

}
