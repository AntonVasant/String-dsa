package LLD.librarysystem;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private final Repository repository;

    public UserService(Repository repository){
        this.repository = repository;
    }

    public int registerUser(String name,int contact){
        User user = new User(name,contact);
        return repository.addUser(user);
    }

    public Book borrowBook(int bookId,int userId) {
        Book book = repository.getBook(bookId);
        if (book != null){
            book.setAvailable(false);
            Transaction transaction = new Transaction(userId,bookId,TransactionType.BORROW);
            repository.addTransaction(transaction);
        }
        return book;
    }

    public int returnBook(int userId,int bookId){
        Transaction transaction = new Transaction(userId,bookId,TransactionType.RETURN);
        repository.addTransaction(transaction);
        return transaction.getId();
    }

    public List<Book> getAvailableBooks(){
        List<Book> books = repository.getAllBooks();
        return books.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }
}
