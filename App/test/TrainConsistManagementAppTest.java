import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

  private List<Bogie> bogieList;

  List<Bogie> filterByCapacity(List<Bogie> list, int threshold) {
    return list.stream()
        .filter(b -> b.getCapacity() > threshold)
        .collect(Collectors.toList());
  }

  Map<String, List<Bogie>> groupByType(List<Bogie> list) {
    return list.stream()
        .collect(Collectors.groupingBy(Bogie::getName));
  }

  @BeforeEach
  void setUp() {
    bogieList = new ArrayList<>();
    bogieList.add(new Bogie("Sleeper", 72));
    bogieList.add(new Bogie("AC Chair", 60));
    bogieList.add(new Bogie("First Class", 40));
    bogieList.add(new Bogie("Sleeper", 80));
    bogieList.add(new Bogie("AC Chair", 55));
  }

  // =====================
  // UC8 Tests
  // =====================
  @Test
  void testFilter_CapacityGreaterThanThreshold() {
    List<Bogie> result = filterByCapacity(bogieList, 60);
    assertEquals(2, result.size());
    assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
  }

  @Test
  void testFilter_CapacityEqualToThreshold() {
    List<Bogie> result = filterByCapacity(bogieList, 60);
    assertTrue(result.stream().noneMatch(b -> b.getCapacity() == 60));
  }

  @Test
  void testFilter_CapacityLessThanThreshold() {
    List<Bogie> result = filterByCapacity(bogieList, 60);
    assertTrue(result.stream().noneMatch(b -> b.getCapacity() < 60));
  }

  @Test
  void testFilter_MultipleBogiesMatching() {
    bogieList.add(new Bogie("Express", 90));
    List<Bogie> result = filterByCapacity(bogieList, 60);
    assertEquals(3, result.size());
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
    assertEquals(originalSize, bogieList.size());
  }

  // =====================
  // UC9 Tests
  // =====================
  @Test
  void testGrouping_BogiesGroupedByType() {
    Map<String, List<Bogie>> result = groupByType(bogieList);
    assertTrue(result.containsKey("Sleeper"));
    assertTrue(result.containsKey("AC Chair"));
    assertTrue(result.containsKey("First Class"));
  }

  @Test
  void testGrouping_MultipleBogiesInSameGroup() {
    Map<String, List<Bogie>> result = groupByType(bogieList);
    assertEquals(2, result.get("Sleeper").size());
    assertEquals(2, result.get("AC Chair").size());
  }

  @Test
  void testGrouping_DifferentBogieTypes() {
    Map<String, List<Bogie>> result = groupByType(bogieList);
    assertEquals(3, result.size());
  }

  @Test
  void testGrouping_EmptyBogieList() {
    Map<String, List<Bogie>> result = groupByType(new ArrayList<>());
    assertTrue(result.isEmpty());
  }

  @Test
  void testGrouping_SingleBogieCategory() {
    List<Bogie> single = new ArrayList<>();
    single.add(new Bogie("Sleeper", 72));
    single.add(new Bogie("Sleeper", 80));
    Map<String, List<Bogie>> result = groupByType(single);
    assertEquals(1, result.size());
    assertTrue(result.containsKey("Sleeper"));
  }

  @Test
  void testGrouping_MapContainsCorrectKeys() {
    Map<String, List<Bogie>> result = groupByType(bogieList);
    assertTrue(result.keySet().containsAll(
        List.of("Sleeper", "AC Chair", "First Class")));
  }

  @Test
  void testGrouping_GroupSizeValidation() {
    Map<String, List<Bogie>> result = groupByType(bogieList);
    assertEquals(2, result.get("Sleeper").size());
    assertEquals(1, result.get("First Class").size());
  }

  @Test
  void testGrouping_OriginalListUnchanged() {
    int originalSize = bogieList.size();
    groupByType(bogieList);
    assertEquals(originalSize, bogieList.size());
  }
}
