public class Course {

     private String courseName;
     private int courseDuration;

     public Course(String courseName, int courseDuration) {
          this.courseName = courseName;
          this.courseDuration = courseDuration;
     }

     public String getCourseName() {
          return courseName;
     }

     public void setCourseName(String courseName) {
          this.courseName = courseName;
     }

     public int getCourseDuration() {
          return courseDuration;
     }

     public void setCourseDuration(int courseDuration) {
          this.courseDuration = courseDuration;
     }

     @Override
     public String toString() {
          return courseName + " - " + courseDuration + " hours.";
     }
}
