public class StudentMember extends Member {

private String studentId;

public StudentMember(int memberId,
String name,
String studentId) {
super(memberId, name);
this.studentId = studentId;
}

@Override
public double calculateFees() {

if(studentId != null && !studentId.isEmpty()) {
return 0;
}
return 5000;
}
}