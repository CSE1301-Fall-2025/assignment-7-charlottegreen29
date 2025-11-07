package assignment7;

public class Course {

    private String name;
    private int credits;
    private int capacity;
    private Student[] roster; 

    public Course(String name, int credits, int capacity) {
        this.name = name;
        this.credits = credits;
        this.capacity = capacity;
        this.roster = new Student[capacity];
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public int getUnfilledSeats() {
        int unfilledSeats = 0;
        for (Student student : roster){
            if (student == null){
                unfilledSeats ++;
            }
        }
        return unfilledSeats;
    }

    public int getSeatsRemaining(){
        return capacity - this.getUnfilledSeats();
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean addStudent(Student s){
        for (Student student : roster){ //seeing if student is already enrolled
            if (s == student){
                return false;
            }
        }
        if (this.getUnfilledSeats()==0){ //making sure there's space in the class
            return false;
        }
        else {
            for (int i = 0; i<capacity; i++){
                if (roster[i]==null){
                    roster[i]=s;
                    return true; //registers the student in the first empty slot
                }
            }
            return false; //this line of code only runs if there's some error and the student won't register
        }

    }

    public Student getStudentAt(int index){
        return this.roster[index];
    }

    public String generateRoster(){
        String output = "";
        for (Student student : this.roster){
            if (student != null){
                output+=student.getFullName();
                output+="\n";
            }
        }
        return output;
    }

    public double calculateAverageGPA(){
        double gpaSum = 0.0;
        int numStudents = this.getSeatsRemaining();
        for (Student student : this.roster){
            if (student != null){
                gpaSum+=student.calculateGradePointAverage();
            }
        }
        return gpaSum/numStudents;
    }
	
    public String toString(){
        return this.name + ", " + this.credits + " credits";
    }
    
}

// I still need to troubleshoot this, because only half of the tests passed
