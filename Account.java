public class Account {

    private String id;
    private String name;
    private int balance;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 0;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        if (amount > 0) {
            balance += amount;
            return balance;
        } else {
            System.out.println("Invalid amount");
            return balance;
        }
    }

    public int debit(int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return balance;
        } else {
            System.out.println("Amount exceeded balance");
            return balance;
        }
    }

    public int transferTo(Account anotherAccount, int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            anotherAccount.balance += amount;
            return balance;
        } else {
            System.out.println("Amount exceeded balance");
            return balance;
        }
    }

    @Override
    public String toString() {
        return "Account[" + "id='" + id + "\'" + ", name='" + name + "\'" + ", balance=" + balance + "]";
    }
}
