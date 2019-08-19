
public class Student {

    private String fName;
    private String lName;
    private String no;
    private int marksICT1;
    private int marksICT2;
    private int marksCWK1;
    private int marksCWK2;
    private int component1marks;
    private int component2marks;
    private int totalMarks;
    private String Grade;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }


    public int getmarksICT1() {
        return marksICT1;
    }

    public void setmarksICT1(int marksICT1) {
        this.marksICT1 = marksICT1;
    }

    public int getmarksICT2() {
        return marksICT2;
    }

    public void setmarksICT2(int marksICT2) {
        this.marksICT2 = marksICT2;
    }

    public int getmarksCWK1() {
        return marksCWK1;
    }

    public void setmarksCWK1(int marksCWK1) {
        this.marksCWK1 = marksCWK1;
    }

    public int getmarksCWK2() {
        return marksCWK2;
    }

    public void setmarksCWK2(int marksCWK2) {
        this.marksCWK2 = marksCWK2;
    }

    public int getcomponent1marks() {
        return component1marks;
    }

    public void setcomponent1marks(int component1marks) {
        this.component1marks = component1marks;
    }

    public int getcomponent2marks() {
        return component2marks;
    }

    public void setcomponent2marks(int component2marks) {
        this.component2marks = component2marks;
    }

    public int gettotalMarks() {
        this.totalMarks = totalMarks;

        return totalMarks;
    }

    public void settotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(int totalMarks) {
        if (component1marks >= 40 && component2marks >= 40) {
            if (totalMarks >= 70) {
                Grade = "First Class";
            } else if (totalMarks >= 60) {
                Grade = "Second Upper Class";
            } else if (totalMarks >= 50) {
                Grade = "Second Lower Class";
            } else if (totalMarks >= 40) {
                Grade = "General Pass";
            } else {
                Grade = "Resit";
            }
        } else if (totalMarks <= 40 && totalMarks >= 30) {
            Grade = "Resit";
        } else {
            Grade = "Retake";
        }
    }

    public Student(String rNo, String fName, String lName, int marksICT1, int marksICT2, int marksCWK1, int marksCWK2) {
        this.no = rNo;
        this.fName = fName;
        this.lName = lName;
        this.marksICT1 = marksICT1;
        this.marksICT2 = marksICT2;
        this.marksCWK1 = marksCWK1;
        this.marksCWK2 = marksCWK2;
    }

    public int compareTo(Student s) {
        return this.marksCWK2 - s.marksCWK2;
    }


    public String toString() {
        return "Student Name : " + getfName() + " " + getlName() + " | Total Marks " + gettotalMarks();
    }
}
