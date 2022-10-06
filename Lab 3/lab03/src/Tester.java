public class Tester {
    public static void main(String[] args) {
        Student s = Student.getStudent("Tom cruise");
        System.out.println(s.getName());

        Student.destroyStudent();

        Student s2 = Student.getStudent("Brad pitt");
        System.out.println(s2.getName());
    }
}
