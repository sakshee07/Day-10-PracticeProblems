package com.bridgelabz.day10;

import java.util.ArrayList;
import java.util.Scanner;

class PersonInfo {
    String name;
    String address,city,state,zip,email;
    long phone;
// declare variables and initialize variables by constructor
    PersonInfo(String n, String add, String c, String s, String z,String mail,long ph) {
        name = n;
        address = add;
        city = c;
        state = s;
        zip =z;
        mail= email;
        phone = ph;
       }
    void display1() {
        System.out.println("Name:" + name + "\naddress: " + address + "\nPhoneNo:" + phone 
        		+ "\nState: "+state +"\ncity "+city+"\nzip "+zip+"\nemail"+email);
    }
}

class AddressBookCrud {
    ArrayList<PersonInfo> persons;

    AddressBookCrud() {
        persons = new ArrayList<PersonInfo>();
    }

    public void addPerson(String name, String address, String city,
    		String state, String zip, String email, long phone) {
        PersonInfo p = new PersonInfo(name, address,city,state,zip,email, phone);
        persons.add(p);
    }

    public void display() {
        for (int i = 0; i < persons.size(); i++) {
            // System.out.println(persons.get(i));
            PersonInfo p1 = persons.get(i); // data comes in nonRedable format like PersonInfo@432;
            // System.out.println(p1.name);
            p1.display1(); // it will call the method from PersonInfo and display the
            // values
        }
    }
    // 0 1 //index
    // 1 3 //values

    public void remove(String removeName) {
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p1 = persons.get(i);
            if (p1.name.equalsIgnoreCase(removeName)) {
                persons.remove(i);
                System.out.println("Record Successfully Removed");
                break;
            }
        }

    }

    public void update(String updateNametoSearch, String updateName,
    		String updateAddress, long updatePhoneno) {
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p1 = persons.get(i);
            if (p1.name.equalsIgnoreCase(updateNametoSearch)) {
                p1.name = updateName;
                p1.address = updateAddress;
                p1.phone = updatePhoneno;
                System.out.println("Data Updated Successfully");
                break;
            }
        }

    }
}

public class AddressBook {
    public static void main(String ar[]) {
        System.out.println("Welcome to AddressBook \n");
        Scanner s1 = new Scanner(System.in);
        int ch;
        String name, address,state,city,zip,email;
        long phoneno;
        String removeName;
        String updateNametoSearch;
        String updateName, updateAddress;
        long updatePhoneno;

        AddressBookCrud ab1 = new AddressBookCrud();
        while (true) {
            System.out.println("Please Select one option:");
            System.out.println("1.Add Deatils \n2.Display Details\n3.Remove Details"
            		+ "\n4.Update Deatils \n5.Exit");
            ch = s1.nextInt();
            switch (ch) {
                case 1:
                    Scanner s2 = new Scanner(System.in);
                    System.out.println("Enter you Name:");
                    name = s2.nextLine();
                    System.out.println("Enter your address:");
                    address = s2.nextLine();
                    System.out.println("Enter your state:");
                    state = s2.nextLine();
                    System.out.println("Enter your city : ");
                    city = s2.nextLine();
                    System.out.println("Enter your zip:");
                    zip = s2.nextLine();
                    System.out.println("Enter your email: ");
                    email = s2.nextLine();
                    System.out.println("Enter your Phone no:");
                    phoneno = s2.nextLong();
                    ab1.addPerson(name, address,state,city,zip,email,phoneno);
                    break;
                case 2:
                    ab1.display();
                    break;
                case 3:
                    Scanner s3 = new Scanner(System.in);
                    System.out.println("Enter name to remove:");
                    removeName = s3.nextLine();
                    ab1.remove(removeName);
                    break;
                case 4:
                    Scanner s4 = new Scanner(System.in);
                    System.out.println("Enter name to update search:");
                    updateNametoSearch = s4.nextLine();

                    System.out.println("Enter Data to Update..");
                    System.out.println("Enter Name to Update:");
                    updateName = s4.nextLine();
                    System.out.println("Enter address to update:");
                    updateAddress = s4.nextLine();
                    System.out.println("Enter Phone no to update:");
                    updatePhoneno = s4.nextLong();
                    ab1.update(updateNametoSearch, updateName, updateAddress, updatePhoneno);
                    break;
                case 5:
                    System.exit(0);
            }
         }
    }
}
        

