package LLD.librarysystem;


import java.util.List;

public class AdminService {

    private final Repository repository;
    public AdminService(Repository repository){
        this.repository = repository;
    }

    public List<Transaction> getTransactions(){
        return repository.getTransaction();
    }
}
