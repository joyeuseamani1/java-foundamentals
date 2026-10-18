public class Main {

public static void main(String[] args) {

Member publisher =
new PublisherMember(1, "ABC Publishing");

Member student =
new StudentMember(2, "Alice", "ST123");

Member librarian =
new LibrarianMember(3, "John");

System.out.println(
"Publisher Fee: " +
publisher.calculateFees());

System.out.println(
"Student Fee: " +
student.calculateFees());

System.out.println(
"Librarian Fee: " +
librarian.calculateFees());
}
}
