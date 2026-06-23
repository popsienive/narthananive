import java.util.ArrayList;
import java.util.Scanner;

class Item {
    int id;
    String name;
    String category;
    String borrower;
    String status;

    Item(int id, String name, String category, String borrower, String status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.borrower = borrower;
        this.status = status;
    }
}

public class CampusItemBorrowingSystems {

    static ArrayList<Item> items = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== CAMPUS ITEM BORROWING SYSTEM =====");
            System.out.println("1. Insert Item");
            System.out.println("2. Update Item");
            System.out.println("3. Delete Item");
            System.out.println("4. Display Items");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    insertItem();
                    break;

                case 2:
                    updateItem();
                    break;

                case 3:
                    deleteItem();
                    break;

                case 4:
                    displayItems();
                    break;

                case 5:
                    System.out.println("Program Closed...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 5);
    }


    static void insertItem() {

        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Borrower Name: ");
        String borrower = sc.nextLine();

        System.out.print("Enter Status (Borrowed/Available): ");
        String status = sc.nextLine();


        items.add(new Item(id,name,category,borrower,status));

        System.out.println("Item Added Successfully!");
    }


    static void updateItem() {

        System.out.print("Enter Item ID to Update: ");
        int id = sc.nextInt();

        sc.nextLine();

        for(Item i : items) {

            if(i.id == id) {

                System.out.print("Enter New Borrower Name: ");
                i.borrower = sc.nextLine();

                System.out.print("Enter New Status: ");
                i.status = sc.nextLine();

                System.out.println("Updated Successfully!");
                return;
            }
        }

        System.out.println("Item Not Found!");
    }



    static void deleteItem() {

        System.out.print("Enter Item ID to Delete: ");
        int id = sc.nextInt();


        for(Item i : items) {

            if(i.id == id) {

                items.remove(i);

                System.out.println("Deleted Successfully!");
                return;
            }
        }

        System.out.println("Item Not Found!");
    }



    static void displayItems() {

        if(items.isEmpty()) {
            System.out.println("No Items Available");
            return;
        }


        System.out.println("\n----- ITEM DETAILS -----");

        for(Item i : items) {

            System.out.println(
            "ID: "+i.id+
            "\nName: "+i.name+
            "\nCategory: "+i.category+
            "\nBorrower: "+i.borrower+
            "\nStatus: "+i.status+
            "\n----------------");
        }
    }
}