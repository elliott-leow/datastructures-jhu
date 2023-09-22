package starter;

public class GradStudent extends Student {
  private String advisor;

  public GradStudent(String name, String email, String advisor) {
    super(name, email);
    this.advisor = advisor;
  }

  public String getAdvisor() {
    return advisor;
  }

  public void setAdvisor(String advisor) {
    this.advisor = advisor;
  }

  @Override
  public String getName() {
    return super.getName() + " the Grad Student";
  }

  @Override
  public String toString() {
    return getName() + " " + getEmail();
  }

  @Override
  public void method() {
    //broader override access is allowed
    //can override to public, not private
  }

}