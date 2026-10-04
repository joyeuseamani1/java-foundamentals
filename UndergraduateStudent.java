class UndergraduateStudent extends Student {
private double gpa;

public UndergraduateStudent(double gpa) {
this.gpa = gpa;
}

@Override
public double calculateStipend() {
double stipend = 500;

if (gpa > 3.5) {
stipend += 150;
}
return stipend;
}
}