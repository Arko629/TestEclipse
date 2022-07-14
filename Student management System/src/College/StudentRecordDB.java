package College;
import java.util.Scanner;

import Model.Record;
import dao.StudentRecordDAOImpl;

public class StudentRecordDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating HumanResourceOffice Object.
				StudentRecordDAOImpl hr
				            = new StudentRecordDAOImpl();
				 
				        Record record = new Record();
//						 
				        // Creating Scanner Object to read input
				        Scanner input = new Scanner(System.in);
				 
				        // Creating option integer variable
				        int option = 0;
				 
				        // Do - While loop
				        do {
				            menu();
				            option = input.nextInt();
				 
				            // Switch case
				            switch (option) {
				 
				            // Case 1
				            case 1:
				 
				                // Display message
				                System.out.print(
				                    "What is the Student Roll Number ? ");
				 
				                int idNumber = input.nextInt();
				 
				                // Display message
				                System.out.print(
				                    "What is the Student contact Number ? ");
				 
				                int contactNumber = input.nextInt();
//				                input.nextLine();
//				                System.out.println(contactNumber);
				                // Display message
				                System.out.print(
				                    "What is the Student First Name ? ");
				 
				                String name = input.next();
				                
				                System.out.print(
					                    "What is the Student Joining Date(YYYY/MM/DD) ? ");
				                String d = input.next();
				 
				                // Create record object and pass constructor
				                // parameters.
				                record = new Record(idNumber,name,String.valueOf(contactNumber),d);
				                // Call add() record
				                hr.add(record);
				                System.out.println(record.toString());
				                System.out.println(record.getMobile());
				 
				                // Break statement used to terminate program
				                // from here only once it entered this case
				                break;
				 
				            case 2:
				       		 
				                // Display message
				                System.out.print(
				                    "What is the Student id number ? ");
				                int rId = input.nextInt();
				 
				                // Invoke remove/delete record
				                hr.delete(rId);
				 
				                break;
				 
				            // Case 3
				            case 3:
				 
				                // Display message
				                System.out.print(
				                    "What is the Student id number? ");
				 
				                int rIdNo = input.nextInt();
				                hr.update(rIdNo, input);
				 
				                break;
				 
				            // Case 4
				            case 4:
				       		 
				                // Display message
				                System.out.print(
				                    "What is the Student id ? ");
				                int bookId = input.nextInt();
				 
				                if (!hr.find(bookId)) {
				                    System.out.println(
				                        "Student id does not exist\n");
				                }
				 
				                break;
				             // Case 5
				            case 5:
				                hr.display();
				                break;
				 
				            // Case 6
				            case 6:
				       		 
				                // Display message
				                System.out.println(
				                    "\nThank you for using the program. Goodbye!\n");
				                System.exit(0);
				 
				                break;
				 
				            // Case 7: Default case
				            // If none above case executes
				            default:
				 
				                // Print statement
				                System.out.println("\nInvalid input\n");
				                break;
				            }
				        }
						 
				        // Checking condition
				        while (option != 6);
				               

	}
	// Method 2
    // Menu - Static menu for displaying options
    public static void menu()
    {
 
        // Printing statements displaying menu on console
        System.out.println("MENU");
        System.out.println("1: Add Student");
        System.out.println("2: Delete Student");
        System.out.println("3: Update Student");
        System.out.println("4: Search Student");
        System.out.println("5: Display Students");
        System.out.println("6: Exit program");
        System.out.print("Enter your selection : ");
    }

}
