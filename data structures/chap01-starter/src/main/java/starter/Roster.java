package starter;

@SuppressWarnings("all")
public class Roster {

  private int numStudents;

  private Student[] students;

  public Roster(int size) {
    students = new Student[size];
  }

  public void add(Student s) {

  }

  public void remove(Student s) {

  }

  //Assumption: student emails are unique
//  public Student find(String email) {
//
//    for (int i = 0; i < numStudents; i++) {
//      if (email.equals(students[i].getEmail())) {
//        return students[i];
//      }
//    }
//
//    return null;
//  }

  public Student find(String email) {
    return find(email, 0, numStudents-1);
  }

  private Student find(String email, int first, int last) {

    if (first > last) {
      return null;
    }
    else {
      int mid = (first + last)/2;
      int comparisonResult = email.compareTo(students[mid].getEmail());
      if (comparisonResult == 0) {
        return students[mid];
      }
      else if (comparisonResult < 0) {
        return find(email, first, mid-1);
      }
      else {
        return find(email, mid+1, last);
      }
    }

    //if the range is invalid
      //element is not present
    //else
      //find midpoint of range
      //compare target to midpoint
      //if equal
        //found
      //else if less than
        //recurse on lefthand side
      //else (greater than)
        //recurse on righthand side

    
  }

}
