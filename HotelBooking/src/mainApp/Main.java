package mainApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import customer.Customer;
import roomBooking.RoomBooking;//import roombooking
import registration.Registration;//import registration package

public class Main {

static int roomNO=0;
static int registerID=0;

public static ArrayList<String> namearray=new ArrayList<String>();
public static ArrayList<String> emailarray=new ArrayList<String>();
public static ArrayList<Integer> bookedarray=new ArrayList<Integer>();
public static ArrayList<Integer> datearray=new ArrayList<Integer>();
public static ArrayList<Integer> registerIdarray=new ArrayList<Integer>();

public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub
String firstName=null;
String middleName=null;
String lastName=null;
String address=null;
String contactNumber = null ;
String email=null;
String proofType=null;
String proofID=null;
int registerID = 0;
int flag=0;
 boolean i=false;
 boolean j=false;
 boolean k=false;

BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
RoomBooking r1=new RoomBooking();
Registration reg=new Registration();
Customer cu=new Customer();

do
{
 
System.out.println("MENU \n\n1.REGISTER\n\n2.BOOKING\n\n3.CHECK ROOM BOOKING STATUS\n\n4.ALL BOOKINGS \n\n5.EMAIL\n\n6.ALL CUSTOMERS \n\n7.EXIT\n\nEnter your choice");
System.out.println("Do you want to book a room? if yes,then press 2\n\nEnter your choice");
String choice =br.readLine();

switch(choice)
{
case "1":
{

System.out.println("REGISTRATION");
do
{
System.out.println("Enter first name");
firstName=br.readLine();
namearray.add(firstName);
System.out.println("Enter middle name");
   middleName = br.readLine();
System.out.println("Enter last name");
lastName=br.readLine();
System.out.println("Enter address");
address=br.readLine();
System.out.println("Enter contact number");
contactNumber=br.readLine();
System.out.println("Enter email");
email=br.readLine();
emailarray.add(email);
System.out.println("Enter proof Type");
proofType=br.readLine();
System.out.println("Enter proof ID");
proofID=br.readLine();
System.out.println("Do u want to proceed? y/n");
char y = br.readLine().charAt(0);


if(y=='y')
{

	System.out.println("Thanks for registering "+firstName+",your registerID is "+ ++registerID);
	reg.register(firstName,middleName,lastName,address,contactNumber,email,proofType,proofID,registerID);
	reg.display();
	registerIdarray.add(registerID);
 
}
else
{
  i=false;
 
  System.out.println("Do you want to update the emailID?(y/n)");
  char z= br.readLine().charAt(0);
  if(z=='y')
  {
  System.out.println("Update email:\nEnter email id");
  email=br.readLine();
  reg.register(firstName,middleName,lastName,address,contactNumber,email,proofType,proofID,registerID);
  System.out.println();
  System.out.println("Email updated");
  System.out.println("Thanku for registartion");
  
       }
  else
  {
  System.out.println("go to registartion");
  i=true;
  }
 
 
}
System.out.println("Customer list");
System.out.println("The registered customers are");
System.out.println();
for(int m=0;m<registerID;m++)
{
System.out.print(registerIdarray.get(m));
System.out.println(" "+namearray.get(m));
}

System.out.println("Do you want to register again?(y/n)");
  char r= br.readLine().charAt(0);
  if(r=='y')
  i=true;
  else
      i=false;
 
}while(i);  


//reg.register(firstName,middleName,lastName,address,contactNumber,email,proofType,proofID);
}
break;
case "2":
{

System.out.println("Booking:");
do
{
System.out.println("Please choose the required service");
System.out.println("ac or non ac(AC/nAC)");
String type =br.readLine();
System.out.println("Cot(Single or Double)");
String cot=br.readLine();
System.out.println("With cable connection or without cable connection (c/nC)");
String cable=br.readLine();
System.out.println("Wifi needed or not (w/nW)");
String wifi=br.readLine();
System.out.println("laundary service needed  or not (l/nL)");
String laundry=br.readLine();
System.out.println("Enter the date of booking");
int date=Integer.parseInt(br.readLine());
datearray.add(date);
//dd[dates]=date;
r1.Book(type,cot,cable,wifi,laundry,date);
r1.display();
System.out.println("Do you want to proceed?(yes/no)");
String op1=br.readLine();
String op2="yes";
if(op1.equalsIgnoreCase(op2) && roomNO<registerID)
{

System.out.println("Thank you for booking.Your room number is "+ ++roomNO);

bookedarray.add(roomNO);

j=false;
}
else
{
j=false;

           System.out.println("Register before booking");
}
if(roomNO>registerID)
{
System.out.println("Room not available currently");
j=false;
System.out.println("Better luck next time");
}
}while(j);

}

break;


case "3":
{
flag=0;
System.out.println("Enter room number");
int  ch=Integer.parseInt(br.readLine());
if(ch>25)
System.out.println("Room unavailable");
else
for(int m=0;m<registerID;m++)
{

if(  bookedarray.get(m)==ch )
{

System.out.println("Room number "+ch+" is booked");

flag=1;
break;
}}
if(flag==0)
{
System.out.println("Room  available,book soon");

}


}break;
case "4":
{
System.out.println("Enter the start date");
int startdate=Integer.parseInt(br.readLine());
System.out.println("Enter the end date");
    int enddate=Integer.parseInt(br.readLine());
   
    for(int m=0;m<registerID;m++)
    {
    if(datearray.get(m)>=startdate && datearray.get(m)<=enddate)
    {
    System.out.println(m+1+"    " +namearray.get(m)+"  "+datearray.get(m));
    }
   
    }
}break;
case "5":
{

System.out.println("Enter current email id");
email=br.readLine();
System.out.println("Enter new email id");
String email2=br.readLine();

for(int m=0;m<registerID;m++)
{

if(email.equalsIgnoreCase(emailarray.get(m)))
{
cu.setEmail(email);
System.out.println(namearray.get(m)+"'s new email is "+email2);
}
else
continue;
}
}
break;

case "6":
{
System.out.println("Customer list");
System.out.println("The registered customers are");
System.out.println();
for(int m=0;m<registerID;m++)
{
System.out.print(registerIdarray.get(m));
System.out.println(" "+namearray.get(m));
}
}
break;
case "7":
{
System.exit(0);
}
break;

}
System.out.println("Do you want to continue?(yes/no)");
String op1=br.readLine();
String op2="yes";
if(op1.equalsIgnoreCase(op2))
{

System.out.println("Thanks");

k=true;
}
else
k=false;
}while(k);
}
}