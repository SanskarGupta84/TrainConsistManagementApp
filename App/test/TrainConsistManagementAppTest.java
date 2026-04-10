import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

  private List<Bogie> bogieList;

  // Helper method extracted from UC8 logic so tests can call it directly
  List<Bogie> filterByCapacity(List<Bogie> list, int threshold) {
    return list.stream()
        .filter(b -> b.getCapacity() > threshold)
        .collect(Collectors.toList());
  }

  @BeforeEach
  void setUp() {
    bogieList = new ArrayList<>();
    bogieList.add(new Bogie("Sleeper", 72));
    bogieList.add(new Bogie("AC Chair", 60));
    bogieList.add(new Bogie("First Class", 40));
  }

  @Test
  void testFilter_CapacityGreaterThanThreshold() {
    List<Bogie> result = filterByCapacity(bogieList, 60);
    assertEquals(1, result.size());
    assertEquals("Sleeper", result.get(0).getName());
  }

  @Test
  void testFilter_CapacityEqualToThreshold() {
    List<Bogie> result = filterByCapacity(bogieList, 60);
    // AC Chair has exactly 60 — must NOT appear (strict >)
    assertTrue(result.stream().noneMatch(b -> b.getCapacity() == 60));
  }

  @Test
  void testFilter_CapacityLessThanThreshold() {
    List<Bogie> result = filterByCapacity(bogieList, 60);
    // First Class has 40 — must NOT appear
    assertTrue(result.stream().noneMatch(b -> b.getCapacity() < 60));
  }

  @Test
  void testFilter_MultipleBogiesMatching() {
    bogieList.add(new Bogie("Express", 80)); // add one more qualifying bogie
    List<Bogie> result = filterByCapacity(bogieList, 60);
    assertEquals(2, result.size()); // Sleeper(72) + Express(80)
  }

  @Test
  void testFilter_NoBogiesMatching() {
    List<Bogie> result = filterByCapacity(bogieList, 100);
    assertTrue(result.isEmpty());
  }

  @Test
  void testFilter_AllBogiesMatching() {
    List<Bogie> result = filterByCapacity(bogieList, 0);
    assertEquals(bogieList.size(), result.size());
  }

  @Test
  void testFilter_OriginalListUnchanged() {
    int originalSize = bogieList.size();
    filterByCapacity(bogieList, 60);
    assertEquals(originalSize, bogieList.size()); // original must not change
  }
}
