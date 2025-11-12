package assignment7;

public class Student {

    private String firstName;
    private String lastName;
    private int id;
    private int attemptedCredits;
    private int passingCredits;
    private double qualityPoints;
    private double bearBucks;

    public Student(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.passingCredits = 0; //default value
        this.qualityPoints = 0.0; //default value
        this.bearBucks = 0.0; //default value
    }

    public String getLastName(){ //I know they didn't ask to make this, but I need it for the legacy method
        return lastName;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public int getId(){
        return id;
    }

    public int getTotalAttemptedCredits(){
        return attemptedCredits;
    }

    public int getTotalPassingCredits(){
        return passingCredits;
    }

    public double calculateGradePointAverage(){
        return qualityPoints/attemptedCredits;
    }

    public void submitGrade(double grade, int credits){
        attemptedCredits+=credits;
        if (grade>=1.7){
            passingCredits+=credits;
        }
        qualityPoints+=(grade*credits);
    }

    public String getClassStanding(){
        String output;
        if (passingCredits<30){
            output = "First Year";
        }
        else if (passingCredits<60){
            output = "Sophomore";
        }
        else if (passingCredits<90){
            output = "Junior";
        }
        else {
            output = "Senior";
        }
        return output;
    }

    public boolean isEligibleForPhiBetaKappa(){
        if (this.passingCredits >= 98 && this.calculateGradePointAverage() >= 3.60){
            return true;
        }
        else if (this.passingCredits >= 75 && this.calculateGradePointAverage() >= 3.80){
            return true;
        }
        else {
            return false;
        }
    }

    public void depositBearBucks(double amount){
        bearBucks+=amount;
    }

    public void deductBearBucks(double amount){
        if (bearBucks-amount>=0){
            bearBucks-=amount;
        }
        else {
            bearBucks = 0.0;
        }
    }

    public double getBearBucksBalance(){
        return bearBucks;
    }

    public double cashOutBearBucks(){
        double balance = bearBucks - 10;
        bearBucks = 0.0;
        if (balance>=0){
            return balance;
        }
        else{
            return 0.0;
        }
    }


    public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id){
        String legacyLastName;
        if (isHyphenated){
            legacyLastName = this.lastName + "-" + otherParent.getLastName();
        }
        else {
            legacyLastName = this.lastName;
        }
        Student legacy = new Student(firstName, legacyLastName, id);
        legacy.depositBearBucks(this.cashOutBearBucks());
        legacy.depositBearBucks(otherParent.cashOutBearBucks());
        return legacy;
    }

    public String toString(){
        return this.getFullName() + ": " + this.id;
    }


	
}
