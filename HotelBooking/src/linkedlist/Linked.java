package linkedlist;
import java.io.*;
import java.util.LinkedList;

public class Linked {
	/*public static void main(String[]args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name");
		String firstName=br.readLine();
		linked_list(firstName);
	
	}*/
	public  void linked_list(String firstName, String middleName, String lastName, String email, int registerID)
	{
		LinkedList<String> al=new LinkedList<String>();  
		al.add(firstName);
		al.add(middleName);
		al.add(lastName);
		al.add(email);
		
		for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i)+"     ");
        }
	}

}
