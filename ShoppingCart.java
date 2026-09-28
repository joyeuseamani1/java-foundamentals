import java.util.Scanner;

public class ShoppingCart {

private int totalItems;
private double totalPrice;

public void addItem(double price) {
totalItems++;
totalPrice += price;
getCartSummary("added");
}

public void removeItem(double price) {
if (totalItems > 0) {
totalItems--;
totalPrice -= price;
getCartSummary("removed");
} else {
System.out.println("Cart is empty.");
}
}

public void emptyCart() {
totalItems = 0;
totalPrice = 0.0;
}

private void getCartSummary(String action) {
System.out.println("Cart has " + totalItems + " items " + action + ". Total: $" + totalPrice);
}

public int getTotalItems() {
return totalItems;
}

public static void main(String[] args) {

Scanner input = new Scanner(System.in);
ShoppingCart cart = new ShoppingCart();

System.out.print("Enter Item Name: ");
String itemName = input.nextLine();

System.out.print("Enter Quantity: ");
int quantity = input.nextInt();

System.out.print("Enter Price: ");
double price = input.nextDouble();

for (int i = 0; i < quantity; i++) {
cart.addItem(price);
}

System.out.println("Item: " + itemName);
System.out.println("Products in Cart: " + cart.getTotalItems());

cart.removeItem(price);

System.out.println("Products Remaining: " + cart.getTotalItems());

input.close();
}
}

