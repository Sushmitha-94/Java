import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class SocialNetworking {
	
	List<User> userList= new ArrayList<User>();
	HashMap<Integer,User> userById = new HashMap<Integer,User>();
	
	public void createUser(String name,int age, int id) {
		if(!userById.containsKey(id)) {
			User newUser= new User(name,age,id);
			userById.put(id, newUser);
			userList.add(newUser);
		}
		else
			System.out.println("User Id already exists");
	}
	
	public void deleteUser(int id) {
		if(userById.containsKey(id)) {
			User toRemove= userById.get(id);
			for(User friend:toRemove.friends) {
				friend.friends.remove(toRemove);
			}
			userList.remove(toRemove);
			userById.remove(id);			 
		}
		else
			System.out.println("User doesn't exists");
	}
	
	public void addFriends(int id1, int id2) {
		if(userById.containsKey(id1) && userById.containsKey(id2)) {
			User user1= userById.get(id1);
			User user2= userById.get(id2);
			if(!user1.friends.contains(user2)) {
				user1.friends.add(user2);
				user2.friends.add(user1);
			}
			else
				System.out.println("Users already connected");
		}
		else
			System.out.println("User doesn't exists");
	}
	
	public void removeFriends(int id1, int id2) {
		if(userById.containsKey(id1) && userById.containsKey(id2)) {
			User user1= userById.get(id1);
			User user2= userById.get(id2);
			if(user1.friends.contains(user2)) {
				user1.friends.remove(user2);
				user2.friends.remove(user1);
			}
			else
				System.out.println("Users are not connected");
		}
		else
			System.out.println("User doesn't exists");
	}
	
	public void isMutual(int id1, int id2) {
		int step=0;
		if(userById.containsKey(id1) && userById.containsKey(id2)) {
			Map<Integer,List<Integer>> idStep= new HashMap<Integer,List<Integer>>();
			int noOfStep=0;
			User friend = userById.get(id2);
			List<Integer> visitedNode=new ArrayList<Integer>();
			Queue<Integer> toVisit=new PriorityQueue<Integer>();
			Stack<Integer> toDisp=new Stack<Integer>();
			toVisit.add(id1);
			List<Integer> values=new ArrayList<Integer>();
			values.add(0);
			values.add(0);
			idStep.put(id1, values);
			while(!toVisit.isEmpty()) {
				int inLoop = toVisit.remove();
				User user= userById.get(inLoop);
				if(user.friends.contains(friend)) {
					toDisp.add(friend.id);	
					while(inLoop!=0) {
						toDisp.add(inLoop);
						inLoop=idStep.get(inLoop).get(1);
					}
				}
				else{
					visitedNode.add(inLoop);
					for(User friendL: user.friends) {
						if(!visitedNode.contains(friendL.id) && !toVisit.contains(friendL.id)) {
							toVisit.add(friendL.id);
							values=new ArrayList<Integer>();
							values.add(idStep.get(inLoop).get(0)+1);
							values.add(inLoop);
							idStep.put(friendL.id,values);
						}
					}
				}
			}
			if(!toDisp.isEmpty()) {
				System.out.println("Friends...");
				while(!toDisp.empty()) {
					System.out.println(toDisp.pop());
				}
			}
			else
				System.out.println("Not Friends...");
		}
		else
			System.out.println("User doesnt exist");
		
	}
	
	public void display(int id) {
		if(userById.containsKey(id)) {	
			User user= userById.get(id);
			System.out.println("\nName: "+user.name);
			System.out.println("Id: "+user.id);
			System.out.print("Friends: ");
			for(User friend: user.friends) {
				System.out.print(' '+friend.name);
			}
			
		}
		else
			System.out.println("User doesn't exists");
		
	}
}
 