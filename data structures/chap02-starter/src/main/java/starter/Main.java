package starter;


public class Main {
  public static void main(String[] args) {
    Roster roster = new Roster(10);
    GradStudent jane = new GradStudent("Jane Doe", "jane@gmail.com", "Dr. S");

    greetAdvisor(jane); //implicit upcasting when mapped to parameter

    //upcasting - static (compile-time) polymorphism
    Student matt = new GradStudent("Matt Doe", "matt@gmail.com", "Dr. Madooei");
    //apparent (static) type = Student
    //actual (dynamic) type = GradStudent
    //declaration vs instantiation
    //cannot getAdvisor(), method not available


    greetAdvisor(matt);
    //dynamic type is gradstudent


    Student john = new Student("John Doe", "john@gmail.com");
    greetAdvisor(john);

    //dynamic (runtime) polymorphism
    //matt.getName() is run from dynamic type,
    //then goes up hierarchy until encounters getName()

  }

  public static void greetAdvisor(Student s) {

    if (s instanceof GradStudent) {


      GradStudent grad = (GradStudent) s; //explicit downcast
      System.out.println("hello, " + grad.getAdvisor() + "!");
    } else {
      System.out.println("I dont have an advisor.");
    }
  }
}