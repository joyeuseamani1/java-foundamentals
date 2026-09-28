public class RideShareSurgePricer {
 public static void main(String[] args) {

double distanceInMiles = 18.0;
int timeOfDay = 18;
String weatherCondition = "Rain";

double fare;

switch (weatherCondition) {
case "Clear":
fare = 5.0;
break;
case "Rain":
fare = 7.5;
break;
case "Snow":
fare = 10.0;
break;
default:
fare = 5.0;
}

fare += distanceInMiles * 1.5;

if ((timeOfDay >= 17 && timeOfDay <= 19) || distanceInMiles > 15) {
fare += 3.0;
}

if (timeOfDay >= 0 && timeOfDay <= 5) {
fare = fare - (fare * 0.20);
}

System.out.printf("Final Fare: $%.2f%n", fare);
}
}   

