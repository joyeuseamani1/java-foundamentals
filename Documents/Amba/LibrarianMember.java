public class LibrarianMember extends Member {

public LibrarianMember(int memberId, String name) {
super(memberId, name);
}

@Override
public double calculateFees() {
return 0;
}
}