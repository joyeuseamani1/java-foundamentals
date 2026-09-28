public class CafePOS {
    
public static double calculateTax(double amount, double taxRate) {
return amount + (amount * taxRate);
}

public static void generateReceipt(String name, double finalAmount) {
System.out.println("**************************");
System.out.println(" CAFE RECEIPT");
System.out.println("***************************");
System.out.println("Customer Name: " + name);
System.out.printf("Final Amount: $%.2f%n", finalAmount);
System.out.println("*************************");
}

public static void main(String[] args) {

String customerName = "Alex";
double coffeePrice = 4.50;
int quantity = 4;
boolean hasLoyaltyCard = true;

double baseTotal = coffeePrice * quantity;
double discountedTotal = baseTotal;

if (hasLoyaltyCard) {
discountedTotal -= 2.50;
} else if (baseTotal > 15.00) {
discountedTotal -= baseTotal * 0.10;
}

double finalAmount = calculateTax(discountedTotal, 0.08);

for (int i = 3; i >= 1; i--) {
System.out.println("Brewing in " + i + "...");
}

System.out.println("Coffee is ready!");

generateReceipt(customerName, finalAmount);
}
}g
