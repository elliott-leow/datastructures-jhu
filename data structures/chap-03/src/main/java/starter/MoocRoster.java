package starter;

public class MoocRoster implements Roster {

  private Student[] students;
  private int numStudents;

  public MoocRoster(int size) { //removes implicitly defined constructor (default constructor - with no parameters)
    students = new Student[size];
    numStudents = size;
  }

  @Override
  public void add(Student s) {
    // implementation skipped for time
    //direct addition (not sorted)
  }

  @Override
  public void remove(Student s) {
    // implementation skipped for time
  }

  @Override
  public Student find(String email) {
    // implementation skipped for time
    //implements linear search
    return null;
  }
}
