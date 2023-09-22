package starter;

public class Student {




  private String name;
  private String email;

  /**
   *
   * @param name e
   * @param email e
   */
  public Student(String name, String email) {
    this.name = name;
    this.email = email;
  }


  public String getName() {
    return name;


  }

  public String getEmail() {
    return email;
  }

  public String getName(String name) {
    return name;
  }


}