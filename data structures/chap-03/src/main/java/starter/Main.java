package starter;

public class Main {
  public static void main(String[] args) {
    Roster roster = new MoocRoster(100);
    roster.add(new Student("Jane Doe", "jane@gmail.com")); //dynamic dispatch of method in Roster

    

  }
}
