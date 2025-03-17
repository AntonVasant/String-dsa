package LLD.librarysystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        UserService userService = new UserService(repository);
        AdminService service = new AdminService(repository);
        Controller controller = new Controller(service,userService,repository);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Enter 1 for admin menu and 2 for user or 3 for exit");
            int menu = scanner.nextInt();
            switch (menu){
                case 1 ->{
                    System.out.println("Enter 1 for All transaction \nEnter 2 to add a book");
                    int n = scanner.nextInt();
                    if (n == 1){
                        controller.viewTransaction();
                    }
                    else{
                        System.out.println("Enter name and author");
                        String name = scanner.next();
                        String author = scanner.next();
                        int id = controller.addBook(name,author);
                        System.out.println("Book added and id "+id);
                    }
                }
                case 2 ->{
                    System.out.println("Enter 1 to borrow book\nEnter 2 to return a book\nEnter 3 to view all books\nEnter 4 to register user");
                    int n = scanner.nextInt();
                    switch (n){
                        case 1 -> {
                            System.out.println("Enter user id and book id");
                            int userId = scanner.nextInt();
                            int bookId = scanner.nextInt();
                            Book book = controller.borrowBook(userId,bookId);
                            System.out.println(book.toString());
                        }
                        case 3 -> {
                            controller.getAllAvailableBooks();
                        }
                        case 4-> {
                            System.out.println("Enter name and contact");
                            String name = scanner.next();
                            int num = scanner.nextInt();
                            controller.registerUser(name,num);
                        }
                    }
                }
                case 3 ->
                    flag = false;

            }

        }
    }
}
