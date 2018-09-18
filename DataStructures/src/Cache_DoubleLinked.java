 import java.util.HashMap;

public class Cache_DoubleLinked {
	
	public int size_Cache;
	public HashMap<Integer,NodeD> hashCache=new HashMap<Integer,NodeD>();
	DoublyLinkedList doubleL=new DoublyLinkedList();
	
	Cache_DoubleLinked(int size){
		this.size_Cache=size;
	}
	
	public void set(int key,int value) {
		if(hashCache.containsKey(key)) {
			NodeD newnode=hashCache.get(key);
			doubleL.remove(newnode);
			doubleL.addFirst(newnode);
			hashCache.put(key, newnode);
		}
		else {
			if(hashCache.size()>=size_Cache) {
				doubleL.removeLast();
			}
			NodeD newnode=new NodeD(key,value);
			doubleL.addFirst(newnode);
			hashCache.put(key, newnode);
		}
	}
	
	public void get(int key) {
		if(hashCache.containsKey(key)) {
			NodeD newNode=hashCache.get(key);
			doubleL.remove(newNode);
			doubleL.addFirst(newNode);
			hashCache.put(key, newNode);
		}
		else {
			System.out.println("No Key found");
		}
		
	}
	
	public void display() {
		doubleL.display();
	}
	
	public static void main(String[] args) {
		Cache_DoubleLinked cache=new Cache_DoubleLinked(5);
		cache.set(1, 11);
		cache.set(2, 22);
		cache.display();
		cache.set(16, 116);
		cache.get(2);
		cache.display();
	}

}
