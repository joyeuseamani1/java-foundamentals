public abstract class Member {

private int memberId;
private String name;

public Member(int memberId, String name) {
this.memberId = memberId;
this.name = name;
}

public int getMemberId() {
return memberId;
}

public String getName() {
return name;
}

public void setMemberId(int memberId) {
this.memberId = memberId;
}

public void setName(String name) {
this.name = name;
}

public abstract double calculateFees();

@Override
public String toString() {
return "Member ID: " + memberId +
", Name: " + name;
}
}