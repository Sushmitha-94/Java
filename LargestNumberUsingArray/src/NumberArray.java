import java.util.ArrayList;
import java.util.List;

public class NumberArray {

	public static void numberToArray(int[] arrayStr) {
		List<Integer> list = new ArrayList<Integer>();
		String str,str1;
		Boolean isTrue=true;
		for(int array:arrayStr) {
			if(list.isEmpty()) {
				list.add(array);
			}
			else {
				int i=0;
				for(int addS:list) {
					str=String.valueOf(Integer.toString(array) + Integer.toString(addS));
					str1=String.valueOf(Integer.toString(addS) + Integer.toString(array));
					System.out.println("str"+str);
					System.out.println("str1"+str1);
					if(Integer.parseInt(str)>Integer.parseInt(str1)) {
						System.out.println("true");
						list.add(i, array);
						
						isTrue=false;
						break;
					}
					
					i++;
				}
				if(isTrue) {
					list.add(i,array);
				}
				System.out.println("list"+list);
			}
		}
		String finalString = null;
		for(int toAdd:list) {
			if(finalString!=null) {
				finalString+=Integer.toString(toAdd);
			}
			else {
				finalString=Integer.toString(toAdd);
			}
		}
		System.out.println("LargestNumber"+finalString);
	}
	
	public static void main(String[] args) {
		int[] numbers= {89,8,81,800,98,90,9};
		numberToArray(numbers);
	}
	
}
