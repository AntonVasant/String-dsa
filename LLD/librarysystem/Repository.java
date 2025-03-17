package LLD.librarysystem;

import com.sun.source.tree.LambdaExpressionTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    private static int id = 1;
    private static Map<Integer,User> Usermap;
    private static Map<Integer, Book> bookMap;

    private static Map<Integer,Transaction> transactionMap;

    public Repository(){
        Usermap = new HashMap<>();
        bookMap = new HashMap<>();
        transactionMap = new HashMap<>();
    }

    public int addUser(User user){
        int idd = id++;
        user.setId(idd);
        Usermap.put(idd,user);
        return idd;
    }

    public void addBook(Book book){
        bookMap.put(book.getId(),book);
    }

    public void removeBook(int id){
            bookMap.remove(id);
    }

    public Book getBook(int bookId) {
        if (bookMap.containsKey(bookId))
            return bookMap.get(bookId);
        return null;
    }

    public void addTransaction(Transaction transaction){
        transactionMap.put(transaction.getId(), transaction);
        bookMap.get(transaction.getBookId()).setAvailable(true);
    }

    public List<Transaction> getTransaction(){
        return new ArrayList<>(transactionMap.values());
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookMap.values());
    }
}
