package LLD.atm;

import LLD.atm.exception.AccountNotFoundException;

public class ATMService {
    private final ATMRepository repository;

    public ATMService(ATMRepository repository) {
        this.repository = repository;
    }

    public double depositCash(double amount, String card,int id) throws AccountNotFoundException {
        Card card1 = repository.findCardByHolderId(id);
        if (CardReader.validateCard(card, card1)) {
            Account account = repository.getAccountByNumber(card1.getCardHolderId());
            account.setBalance(account.getBalance() + amount);
            repository.update(account);
            return account.getBalance();
        }
        throw new AccountNotFoundException("Account not found");
    }

    private boolean validateBalance(Account account,double amount){
        return account.getBalance() >= amount;
    }

    public long createAccount(String name) {
        Customer customer = new Customer(name);
        Card card = new Card(customer.getId());
        Account account = new Account(customer.getAccountNumber(),customer.getId(),card.getCardNo());
        repository.add(customer,card,account);
        return customer.getAccountNumber();
    }
}
