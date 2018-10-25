import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class SocialNetwork {
	
	static HashMap<Integer,Profile> idProfileMap=new HashMap<Integer,Profile>();
	static HashMap<Integer,Integer> popularityMap=new HashMap<Integer,Integer>();
	static int highestPopularity;
	
	//display popular profile
	public static void displayPopular() {
		calculatePopular();
		System.out.println("Highest Popularity :"+highestPopularity);
		System.out.println("Popular profile is : "+popularityMap.get(highestPopularity));
	}
	
	//calculate Popular Profile
	public static void calculatePopular() {
		Iterator<Integer> it=popularityMap.keySet().iterator();
		int[] heapValue=new int[idProfileMap.size()];
		int j=0;
		while(it.hasNext()) {
			heapValue[j++]=(int) it.next();
		}
		
		for(int i=((heapValue.length-1)/2);i>=0;i--) {
			heapValue=heapify(heapValue,i,heapValue.length);
		}
		highestPopularity=heapValue[0];
	}
	public static int[] heapify(int[] heapValue,int i,int n) {
		int left=(i*2)+1;
		int right=(i*2)+2;
		int largest=i;
		if(i>=0) {
			if(left<n && left>=0 && heapValue[left]>heapValue[largest]) {
				largest=left;
			}
			if(right<n && right>=0 && heapValue[right]>heapValue[largest]) {
				largest=right;
			}
		}
		
		if(largest!=i) {
			int temp=heapValue[i];
			heapValue[i]=heapValue[largest];
			heapValue[largest]=temp;
		}
		return heapValue;
	}
	
	//Create Users
	public static void createUser(int id,int popularity,String name) {
		Profile newProfile=new Profile(id,popularity,name);
		idProfileMap.put(id,newProfile);
		popularityMap.put(popularity,id);
	}
	
	//Add friend
	public static void addFriend(int id1, int id2) {
		if(idProfileMap.get(id1)!=null && idProfileMap.get(id2)!=null) {
			idProfileMap.get(id1).friends.add(id2);
			idProfileMap.get(id2).friends.add(id1);
		}
		else
		{
			System.out.println("User not found");
		}
	}
	
	//user detail
	public static void userDetail(int id1) {
		Profile userDetail=idProfileMap.get(id1);
		if(userDetail!=null) {
			System.out.println("\n\nUser detail:\nID : "+userDetail.id+"\nName : "+userDetail.name+"\nFriends : ");
			for(int friend:userDetail.friends) {
				System.out.print(friend+" ");
			}
			
		}
		else {
			System.out.println("User not found");
		}
	}
	
	//delete User
	public static void deleteUser(int id) {
		Profile userDetail=idProfileMap.get(id);
		if(userDetail!=null) {
			for(int friend:userDetail.friends) {
				idProfileMap.get(friend).friends.remove(id);
			}
			idProfileMap.remove(id);
		}	
		else {
			System.out.println("User not found");
		}
		popularityMap.remove(userDetail.popularity);
	}
	
	// shortest path between two profiles
	public static int shortestPath(int id1,int id2) {
		int count=0;
		HashMap<Integer,Integer> countPath=new HashMap<Integer,Integer>();
		Iterator<Integer> it=idProfileMap.keySet().iterator();
		while(it.hasNext()) {
			countPath.put(it.next(), 0);
		}
		LinkedList<Integer> queue=new LinkedList<Integer>();
		HashSet<Integer> isVisited=new HashSet<Integer>();
		queue.addLast(id1);
		while(!queue.isEmpty()) {
			Integer firstId=queue.removeFirst();
			LinkedList<Integer> friends=idProfileMap.get(firstId).friends;
			isVisited.add(firstId);
			for(int id:friends) {
				if(!isVisited.contains(id) && !queue.contains(id)) {
					queue.addLast(id);
					countPath.put(id, countPath.get(firstId)+1);
					if(id==id2)
						return countPath.get(id);
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		
	}

}
