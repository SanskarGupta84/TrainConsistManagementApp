import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

  public static void main(String[] args) {

    // Welcome message
    System.out.println("=== Train Consist Management App ===");

    // Initialize empty train consist (list of bogies)
    List<String> trainConsist = new ArrayList<>();

    // Display initial bogie count
    System.out.println("Initial Bogie Count: " + trainConsist.size());

    // Program continues...
    System.out.println("Train system initialized successfully.");
  }
}
