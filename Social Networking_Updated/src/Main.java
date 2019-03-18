import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		SocialNetworking sN=new SocialNetworking();		
		Scanner scan= new Scanner(System.in);
		String input1;
		int input2, input3;
		Boolean exit=true;
		do {
			System.out.println("\n1.Create User\n2.Delete User\n3.Add Friend\n4.Delete Friend"
					+ "\n5.Display User details\n6.Mutual Friends?\n7.Exit");
			int option=scan.nextInt();
			switch(option) {
				case 1:
					System.out.println("Name:");
					input1=scan.next();
					System.out.println("Age:");
					input2=scan.nextInt();
					System.out.println("Id:");
					input3=scan.nextInt();
					sN.createUser(input1,input2,input3);
					System.out.println("User created\n");
					break;
				case 2:
					System.out.println("Enter Id:");
					input2=scan.nextInt();
					sN.deleteUser(input2);
					break;
				case 3:
					System.out.println("Id1:");
					input2=scan.nextInt();
					System.out.println("Id2:");
					input3=scan.nextInt();
					sN.addFriends(input2, input3);
					System.out.println("Connected as friends");
					break;
				case 4:
					System.out.println("Id1:");
					input2=scan.nextInt();
					System.out.println("Id2:");
					input3=scan.nextInt();
					sN.removeFriends(input2, input3);
					System.out.println("Removed");
					break;
				case 5:
					System.out.println("Id:");
					input3=scan.nextInt();
					sN.display(input3);
					break;
				case 6:
					System.out.println("Id1:");
					input2=scan.nextInt();
					System.out.println("Id2:");
					input3=scan.nextInt();
					sN.isMutual(input2, input3);
					break;
				case 7:
					exit=false;
					break;
				
			}
		}
		while(exit);
	}

}
