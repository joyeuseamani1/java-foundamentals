public class BankAccount {

private String accountNumber;
private String accountHolderName;
private double balance;

public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {

this.accountNumber = accountNumber;
this.accountHolderName = accountHolderName;

if (initialBalance < 0) {
System.out.println("Warning: Invalid initial balance.");
this.balance = 0.0;
} else {
this.balance = initialBalance;
}
}

public String getAccountNumber() {
return accountNumber;
}

public String getAccountHolderName() {
return accountHolderName;
}

public double getBalance() {
return balance;
}

public void setAccountHolderName(String accountHolderName) {
this.accountHolderName = accountHolderName;
}

public void deposit(double amount) {
if (amount > 0) {
balance += amount;
} else {
System.out.println("Invalid deposit amount.");
}
}

public void withdraw(double amount) {
if (amount > 0 && balance >= amount) {
balance -= amount;
} else {
System.out.println("Insufficient funds or invalid amount.");
}
}

public double calculateLoan() {

if (balance <= 10000) {
return balance * 0.10;
} else if (balance <= 60000) {
return balance * 0.25;
} else {
return balance * 0.30;
}
}

public void displayAccountDetails() {
System.out.println("Account Number: " + accountNumber);
System.out.println("Account Holder: " + accountHolderName);
System.out.println("Balance: " + balance);
System.out.println("Eligible Loan: " + calculateLoan());
System.out.println();
}

public static void main(String[] args) {

BankAccount account1 = new BankAccount("ACC001", "John", 5000);
BankAccount account2 = new BankAccount("ACC002", "Alice", 30000);
BankAccount account3 = new BankAccount("ACC003", "Patrick", 80000);

account1.deposit(1000);
account2.withdraw(5000);
account3.deposit(2000);

account1.displayAccountDetails();
account2.displayAccountDetails();
account3.displayAccountDetails();
}
}