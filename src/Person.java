import java.util.Calendar;

public class Person {
    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        validateAge(YOB);
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) { this.title = title; }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        validateAge(YOB);
        this.YOB = YOB;
    }

    private void validateAge(int YOB) throws ExceptionInInitializerError {
        if (!(YOB >= 1940 && YOB <= 2010)) {
            throw new ExceptionInInitializerError("YOB must be between 1940 and 2010.");
        }
    }

    public String fullName() { return this.firstName + " " + this.lastName; }

    public String formalName() { return this.title + " " + fullName(); }

    public static int getAge(int year) {
        int date = Calendar.getInstance().get(Calendar.YEAR);
        int age = date - year;
        return age;
    }

    public String toCSVDataRecord() { return this.ID + ", " + this.lastName + ", " + this.firstName + ", " + this.title + ", " + this.YOB; }
}
