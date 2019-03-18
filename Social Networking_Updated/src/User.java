import java.util.ArrayList;
import java.util.List;

public class User {
	String name;
	int age;
	int id;
	List<User> friends;
	
	public User(String name, int age, int id) {
		this.name=name;
		this.age=age;
		this.id=id;
		friends = new ArrayList<User>();
	}
	
}
