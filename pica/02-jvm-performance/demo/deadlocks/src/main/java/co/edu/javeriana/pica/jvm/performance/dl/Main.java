package co.edu.javeriana.pica.jvm.performance.dl;

class Account {

    private int id;
    private long balance;

    public Account(int id, long balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}

class AccountTransfer implements Runnable {

    private Account firstAccount;
    private Account secondAccount;
    private long transferValue;

    public AccountTransfer(Account accountA, Account accountB, long transferValue, boolean fixed) {
        if (fixed) {
            if (accountA.getId() < accountB.getId()) {
                this.firstAccount = accountA;
                this.secondAccount = accountB;
            } else {
                this.firstAccount = accountB;
                this.secondAccount = accountA;
            }
        } else {
            this.firstAccount = accountA;
            this.secondAccount = accountB;
        }

        this.transferValue = transferValue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Obtaining lock for " + firstAccount.getId());
        synchronized (firstAccount) {
            System.out.println(Thread.currentThread().getName() + ": Locked obtain for " + firstAccount.getId());

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {}

            System.out.println(Thread.currentThread().getName() + ": Obtaining lock for " + secondAccount.getId());
            synchronized (secondAccount) {
                System.out.println(Thread.currentThread().getName() + ": Locked obtain for " + secondAccount.getId());

                firstAccount.setBalance(firstAccount.getBalance() - transferValue);
                secondAccount.setBalance(secondAccount.getBalance() + transferValue);

                System.out.println(Thread.currentThread().getName() + ": Account A new balance: " + firstAccount.getBalance());
                System.out.println(Thread.currentThread().getName() + ": Account B new balance: " + secondAccount.getBalance());
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        boolean fixed = args.length == 1;

        Account account1 = new Account(123, 100000);
        Account account2 = new Account(567, 50000);
        long transferValue1 = 25000;
        long transferValue2 = 10000;

        Thread t1 = new Thread(new AccountTransfer(account1, account2, transferValue1, fixed));
        t1.setName("Transfer-1");

        Thread t2 = new Thread(new AccountTransfer(account2, account1, transferValue2, fixed));
        t2.setName("Transfer-2");

        t1.start();
        t2.start();
    }
}
