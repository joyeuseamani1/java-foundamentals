public class PublisherMember extends Member {

public PublisherMember(int memberId, String name) {
super(memberId, name);
}

@Override
public double calculateFees() {
return 5000 + (5000 * 0.05) + 20000;
}
}