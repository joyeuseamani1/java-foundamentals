class GraduateStudent extends Student {
private int taHours;
private double yearlyResearchGrant;

public GraduateStudent(int taHours, double yearlyResearchGrant) {
this.taHours = taHours;
this.yearlyResearchGrant = yearlyResearchGrant;
}
@Override
public double calculateStipend() {
return 1200 + (taHours * 25) + (yearlyResearchGrant / 12);
}
}