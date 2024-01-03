import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeNthSalary {
    public static void main(String[] args) {
        Map<String, Integer> employeeNameAndSalary = new HashMap<>();

        employeeNameAndSalary.put("moeen", 123000);
        employeeNameAndSalary.put("arif", 1200);
        employeeNameAndSalary.put("banee", 800);
        employeeNameAndSalary.put("tuhin1", 1200);
        employeeNameAndSalary.put("banee1", 800);
        employeeNameAndSalary.put("tuhin2", 1200);

        List<Map.Entry<String, Integer>> list =
                employeeNameAndSalary.entrySet().stream().
                        sorted(Map.Entry.comparingByValue()).toList();

        System.out.println(list);

        Map.Entry<Integer, List<String>> integerListEntry = employeeNameAndSalary.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet().stream().toList().get(1);
        System.out.println(integerListEntry);

    }
}
