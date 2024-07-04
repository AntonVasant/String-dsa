package library;

import java.util.List;

public class Controller {

    private ServiceImp serviceImp;

    public Controller(ServiceImp serviceImp) {
        this.serviceImp = serviceImp;
    }

    public void registerUser(String userName){
        serviceImp.registerUser(userName);
    }

    public void barrowBook(String bookName,long id){
        serviceImp.barrowBook(bookName,id);
    }

    public void returnBook(String name,long id){
        serviceImp.returnBook(name,id);
    }

    public void getUserDetails(long id){
        User user = serviceImp.showDetails(id);
        System.out.println(user.toString());
    }
}
