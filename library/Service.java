package library;

import java.util.List;

public interface Service {

    void registerUser(String userName);

     void barrowBook(String bookName,long id);

     void returnBook(String bookName,long id);

     User showDetails(long id);
}
