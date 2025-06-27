/*
 * Fitness Tracker Java Project
 * Based on the project requirements from the image provided
 */

// Import necessary libraries
import java.util.*;

// Model Classes
class FitnessActivity {
    String type;
    double duration; // in minutes
    double distance; // in kilometers
    double caloriesBurned;
    String notes;

    public FitnessActivity(String type, double duration, double distance, double caloriesBurned, String notes) {
        this.type = type;
        this.duration = duration;
        this.distance = distance;
        this.caloriesBurned = caloriesBurned;
        this.notes = notes;
    }
}

class UserProfile {
    String name;
    String email;
    String goal;
    List<FitnessActivity> activities = new ArrayList<>();

    public UserProfile(String name, String email, String goal) {
        this.name = name;
        this.email = email;
        this.goal = goal;
    }

    public void addActivity(FitnessActivity activity) {
        activities.add(activity);
    }

    public List<FitnessActivity> getActivityHistory() {
        return activities;
    }

    public void displayAnalytics() {
        double totalDuration = 0, totalDistance = 0, totalCalories = 0;
        for (FitnessActivity a : activities) {
            totalDuration += a.duration;
            totalDistance += a.distance;
            totalCalories += a.caloriesBurned;
        }
        System.out.println("Analytics for " + name);
        System.out.println("Total Duration: " + totalDuration + " mins");
        System.out.println("Total Distance: " + totalDistance + " km");
        System.out.println("Total Calories Burned: " + totalCalories + " cal");
    }
}

// Main Application
public class FitnessTrackerApp {
    static Map<String, UserProfile> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Simple CLI interaction
        System.out.println("Enter your name:");
        String name = sc.nextLine();

        System.out.println("Enter your email:");
        String email = sc.nextLine();

        System.out.println("Enter your fitness goal:");
        String goal = sc.nextLine();

        UserProfile user = new UserProfile(name, email, goal);
        users.put(email, user);

        while (true) {
            System.out.println("\n1. Log Activity\n2. View History\n3. View Analytics\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Activity Type:");
                String type = sc.nextLine();
                System.out.println("Duration (mins):");
                double duration = sc.nextDouble();
                System.out.println("Distance (km):");
                double distance = sc.nextDouble();
                System.out.println("Calories Burned:");
                double calories = sc.nextDouble();
                sc.nextLine();
                System.out.println("Notes:");
                String notes = sc.nextLine();

                FitnessActivity activity = new FitnessActivity(type, duration, distance, calories, notes);
                user.addActivity(activity);

            } else if (choice == 2) {
                for (FitnessActivity a : user.getActivityHistory()) {
                    System.out.println("Type: " + a.type + ", Duration: " + a.duration + " mins, Distance: " + a.distance +
                            " km, Calories: " + a.caloriesBurned + ", Notes: " + a.notes);
                }

            } else if (choice == 3) {
                user.displayAnalytics();

            } else if (choice == 4) {
                break;
            }
        }

        sc.close();
    }
}
