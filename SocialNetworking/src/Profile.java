import java.util.LinkedList;

public class Profile {

	int id;
	String name;
	LinkedList<Integer> friends=new LinkedList<Integer>();
	int popularity;
	
	Profile(int id,int popularity,String name){
		this.id=id;
		this.name=name;
		this.popularity=popularity;
	}
	
	
}
