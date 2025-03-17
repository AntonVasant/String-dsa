package LLD.librarysystem;

import java.util.List;

public class Controller {

    private final AdminService adminService;
    private final UserService userService;

    private final Repository repository;

    public Controller(AdminService adminService, UserService userService,Repository repository){
        this.adminService = adminService;
        this.userService = userService;
        this.repository = repository;
    }


    public void registerUser(String name,int contact){
        int n = userService.registerUser(name,contact);
        System.out.println("your id "+n);
    }

    public int addBook(String name,String author){
        Book book = new Book(author,name);
        repository.addBook(book);
        return book.getId();
    }

    public Book borrowBook(int userId,int bookId){
        Book book = userService.borrowBook(bookId, userId);
        return book;
    }

    public int returnBook(int userId,int bookId){
        int n = userService.returnBook(userId, bookId);
        return n;
    }

    public void getAllAvailableBooks(){
        List<Book> books = userService.getAvailableBooks();
        books.forEach(System.out::println);
    }

    public void viewTransaction(){
       List<Transaction> transactions =  adminService.getTransactions();
       transactions.forEach(System.out::println);
    }
}
