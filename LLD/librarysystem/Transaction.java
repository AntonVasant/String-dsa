package LLD.librarysystem;

public class Transaction {

    private static int idGen;

    private TransactionType transactionType;
    private int id;
    private int userId;
    private int bookId;

    public Transaction(int userId,int bookId,TransactionType transactionType){
        this.bookId = bookId;
        this.userId = userId;
        this.transactionType = transactionType;
        this.id = idGen++;
    }

    public static int getIdGen() {
        return idGen;
    }

    public static void setIdGen(int idGen) {
        Transaction.idGen = idGen;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
