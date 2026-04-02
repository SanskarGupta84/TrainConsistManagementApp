import java.util.*;

public class TrainConsistManagementApp {

  public static void main(String[] args) {

    // =========================
    // UC1: Initialize Train
    // =========================
    System.out.println("=== Train Consist Management App ===");

    List<String> trainConsist = new ArrayList<>();
    System.out.println("Initial Bogie Count: " + trainConsist.size());

    // =========================
    // UC2: Passenger Bogies
    // =========================
    List<String> passengerBogies = new ArrayList<>();

    passengerBogies.add("Sleeper");
    passengerBogies.add("AC Chair");
    passengerBogies.add("First Class");

    System.out.println("\nPassenger Bogies after addition:");
    System.out.println(passengerBogies);

    passengerBogies.remove("AC Chair");

    System.out.println("\nPassenger Bogies after removal:");
    System.out.println(passengerBogies);

    System.out.println("\nIs Sleeper present? " + passengerBogies.contains("Sleeper"));

    System.out.println("Final Passenger Bogie List:");
    System.out.println(passengerBogies);

    // =========================
    // UC3: Unique Bogie IDs
    // =========================
    Set<String> bogieIds = new HashSet<>();

    bogieIds.add("BG101");
    bogieIds.add("BG102");
    bogieIds.add("BG103");
    bogieIds.add("BG101"); // duplicate

    System.out.println("\nUnique Bogie IDs:");
    System.out.println(bogieIds);

    // =========================
    // UC4: Ordered Train Consist (LinkedList)
    // =========================
    LinkedList<String> consist = new LinkedList<>();

    consist.add("Engine");
    consist.add("Sleeper");
    consist.add("AC");
    consist.add("Cargo");
    consist.add("Guard");

    System.out.println("\nInitial Train Consist:");
    System.out.println(consist);

    consist.add(2, "Pantry");

    System.out.println("\nAfter adding Pantry:");
    System.out.println(consist);

    consist.removeFirst();
    consist.removeLast();

    System.out.println("\nFinal Train Consist:");
    System.out.println(consist);

    // =========================
    // UC5: LinkedHashSet (Ordered + Unique)
    // =========================
    Set<String> formation = new LinkedHashSet<>();

    formation.add("Engine");
    formation.add("Sleeper");
    formation.add("Cargo");
    formation.add("Guard");
    formation.add("Sleeper"); // duplicate ignored

    System.out.println("\nTrain Formation (LinkedHashSet):");
    System.out.println(formation);

    // =========================
    // UC6: HashMap (Bogie → Capacity)
    // =========================
    Map<String, Integer> bogieCapacity = new HashMap<>();

    bogieCapacity.put("Sleeper", 72);
    bogieCapacity.put("AC Chair", 60);
    bogieCapacity.put("First Class", 40);

    System.out.println("\nBogie Capacity Details:");

    for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
      System.out.println(entry.getKey() + " → Capacity: " + entry.getValue());
    }

    // =========================
    // UC7: Sort Bogies by Capacity
    // =========================
    List<Bogie> bogieList = new ArrayList<>();

    bogieList.add(new Bogie("Sleeper", 72));
    bogieList.add(new Bogie("AC Chair", 60));
    bogieList.add(new Bogie("First Class", 40));

    // Sort by capacity
    bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));

    System.out.println("\nBogies Sorted by Capacity:");

    for (Bogie b : bogieList) {
      System.out.println(b.getName() + " → Capacity: " + b.getCapacity());
    }
  }
}

// =========================
// Bogie Class (UC7)
// =========================
class Bogie {
  private String name;
  private int capacity;

  public Bogie(String name, int capacity) {
    this.name = name;
    this.capacity = capacity;
  }

  public String getName() {
    return name;
  }

  public int getCapacity() {
    return capacity;
  }
}
