import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Student {
    private int id;
    private String firstName;
    private int age;
    private String gender;
    private String dept;
    private String city;
    private int rank;
    private List<String> contacts;

    public Student() {
    }

    public Student(int id, String firstName, int age, String gender,
                   String dept, String city, int rank, List<String> contacts) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
        this.dept = dept;
        this.city = city;
        this.rank = rank;
        this.contacts = contacts;
    }

    public static void main(String[] args) {
        List<Student> studentList = List.of(
                new Student(1, "Moeen", 24, "Male", "CSE", "Dhaka", 50, List.of("01718008604", "01718008605")),
                new Student(2, "John", 22, "Male", "CSE", "New York", 40, List.of("01718008606", "01718008607")),
                new Student(3, "Alice", 23, "Female", "Physics", "Dhaka", 45, List.of("01718008618", "01718008619")),
                new Student(4, "Bob", 25, "Male", "Chemistry", "Paris", 35, List.of("01718008620", "01718008621")),
                new Student(5, "Eva", 21, "Female", "Biology", "Berlin", 55, List.of("01718008622", "01718008623")),
                new Student(6, "David", 24, "Male", "Economics", "Tokyo", 48, List.of("01718008624", "01718008625")),
                new Student(7, "Grace", 22, "Female", "History", "Sydney", 42, List.of("01718008626", "01718008627")),
                new Student(8, "Sam", 23, "Male", "Geography", "Toronto", 47, List.of("01718008628", "01718008629")),
                new Student(9, "Sophie", 25, "Female", "Political Science", "Washington", 38, List.of("01718008630", "01718008631")),
                new Student(10, "Michael", 22, "Male", "Engineering", "Mumbai", 51, List.of("01718008632", "01718008633"))
        );
//        studentList.forEach(System.out::println);

        //    q1.

        List<String> studentName = studentList.stream()
                .map(Student::getFirstName).toList();

//        studentName.forEach(System.out::println);

        // Q1 : Find The list of students whose rank is in  between 20 and 50

        List<?> getRankList = studentList.stream().filter(s -> s.getRank() > 20 && s.getRank() < 50)
                .map(Student::getFirstName)
                .toList();

//        getRankList.forEach(System.out::println);

//        Q2. Find the Student form city Dhaka amd Sort By there name

        List<Student> studentByCity = studentList.stream().filter(s -> s.getCity().equals("Dhaka"))
                .sorted(Comparator.comparing(Student::getFirstName, Comparator.reverseOrder())).toList();

//        studentByCity.forEach(System.out::println);

//        Q3. Find all Department Name
        List<String> deptName = studentList.stream().map(Student::getDept).sorted().distinct().toList();
//        deptName.forEach(System.out::println);

//      Q4 . find all Contact Number
        List<List<String>> studentContact = studentList.stream()
                .map(Student::getContacts).toList();

        List<String> contactList = studentList.stream()
                .flatMap(student -> student.getContacts().stream()).toList();

//        contactList.forEach(System.out::println);


//        Q5. Group The Student By Department

        Map<String, List<Student>> collect =
                studentList.stream().collect(Collectors.groupingBy(Student::getDept));

        System.out.println(collect);

        Map<String, Long> countStudent =
                studentList.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.counting()));

        System.out.println(countStudent);

//        Q6 Find Which department have more student

        Map.Entry<String, Long> maxDept =
                studentList.stream()
                        .collect(Collectors.groupingBy(Student::getDept,Collectors.counting()))
                        .entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println(maxDept);

//        Q7 find male female Average age

        Map<String, Double> studentByGender =
                studentList.stream()
                        .collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge)));

        System.out.println(studentByGender);

//        Q8 find Highest Rank Of each Department

        Map<String, Optional<Student>> studentRank = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept,
                        Collectors.minBy(Comparator.comparing(Student::getRank))));

        System.out.println(studentRank);

//        Q9 find second rank Student

        Optional<Student> first = studentList.stream().sorted(Comparator.comparing(Student::getRank, Comparator.reverseOrder())).skip(1).findFirst();

        System.out.println(first);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", dept='" + dept + '\'' +
                ", city='" + city + '\'' +
                ", rank=" + rank +
                ", contacts=" + contacts +
                '}';
    }
}

