package AddressBookBasic;
import java.util.Scanner;
import java.util.ArrayList;

// Contact class taking Name, Mobile Number and Address of a person.
class Contact{
	private String name;
	private long mobileNumber;
	private String address;
	
	public Contact(String name,long mobileNumber,String address) {
		this.name=name;
		this.mobileNumber=mobileNumber;
		this.address=address;
	}
	public String getName() {
		return name;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public String getAddress() {
		return address;
	}
}

// AddressBook class store the contacts of person and performs add,view,update and delete contact operations.
class AddressBook{
	ArrayList<Contact> contacts= new ArrayList<>();
	
	public void addContacts(Contact contact) {
		contacts.add(contact);
	}
	public void viewContacts() {
		System.out.println("\nADDRESS BOOK DETAILS:");
		for( Contact contact: contacts) {
			System.out.println("Name: "+contact.getName());
			System.out.println("Mobile Number: "+contact.getMobileNumber());
			System.out.println("Address: "+contact.getAddress()+"\n");
		}
		if(contacts.isEmpty()) {
		System.out.println("ADDRESS BOOK IS EMPTY!");
	 }
	}
	public void updateContacts(String name,Contact newContact) {
		for(int i=0;i<contacts.size();i++) {
			if(contacts.get(i).getName().equals(name)) {
				contacts.set(i, newContact);
				System.out.println("\nCONTACT UPDATED SUCCESSFULLY.\n");
				return;
			}
		}
		System.out.println("\nCONTACT NOT FOUND!\n");
	}
	public void deleteContacts(String deleteName) {
		for(Contact contact:contacts) {
			if(contact.getName().equals(deleteName)) {
				contacts.remove(contact);
				System.out.println("\nCONTACT DELETED SUCCESSFULLY.\n");
				return;
			}
		}
		System.out.println("\nCONTACT NOT FOUND!\n");
	}
}

public class Application {
public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	AddressBook addressBook= new AddressBook();
	while(true) {
	System.out.println("---------------------------");
	System.out.println("ADDRESS BOOK MENU: ");
	System.out.println("1. Add contact");
	System.out.println("2. View contact");
	System.out.println("3. Update contact");
	System.out.println("4. Delete contact");
	System.out.println("5. Exit!\n");
	System.out.print("Enter the choice: ");
	int choice=-1;
	while(choice<0) {
		if(input.hasNextInt()) {
			choice=input.nextInt();
		}else {
			System.out.print("INVALID CHOICE!\nEnter choice again: ");
			input.next(); // consume invalid input
		}
	}
	
	input.nextLine(); // this take new line character, so that "String Name" can take entered name.
	switch(choice) {
	case 1:
		System.out.print("\nName: ");
		String name=input.nextLine();
		
		long mobileNumber=-1;
		while(mobileNumber<0) {
			System.out.print("Mobile Number: ");
			if(input.hasNextLong()) {
				mobileNumber= input.nextLong();
			}else {
				System.out.println("INVALID MOBILE NUMBER, TRY AGAIN!");
				input.next(); // consume invalid input
			}
		}
		input.nextLine(); // consume the newline character
	
		System.out.print("Address: ");
		String address=input.nextLine();
		Contact contact= new Contact(name,mobileNumber,address);
		addressBook.addContacts(contact);
		System.out.println("\nNEW CONTACT ADDED SUCCESSFULLY.\n");
		break;
	case 2:
		addressBook.viewContacts();
		break;
	case 3:
		System.out.print("\nEnter contact name to be replaced: ");
		String existingName=input.nextLine();
		System.out.print("\nNew name: ");
		String newName=input.nextLine();
		
		long newMobileNumber=-1;
		while(newMobileNumber<0) {
			System.out.print("New Mobile Number: ");
			if(input.hasNextLong()) {
				newMobileNumber= input.nextLong();
			}else {
				System.out.println("Invalid mobile number, please enter in numerical formate.");
				input.next(); // consume invalid input
			}
		}
		input.nextLine(); // consume the newline character
		
		System.out.print("New address: ");
		String newAddress=input.nextLine();
		Contact newContact= new Contact(newName,newMobileNumber,newAddress);
		addressBook.updateContacts(existingName, newContact);
		break;
	case 4:
		System.out.print("\nEnter contact name to be deleted: ");
		String deleteName=input.nextLine();
		addressBook.deleteContacts(deleteName);
		break;
	case 5:
		System.out.println("Clossing the Address Book.");
		input.close(); // close the scanner
		System.exit(0); // terminate the current program
		default: System.out.println("INVALID CHOICE. TRY AGAIN!");
	}
}
}
}
