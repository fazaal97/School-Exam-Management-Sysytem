import java.util.Comparator;


public class MarksSorter implements Comparator<Student> {

    public int compare(Student one, Student another){
        if(one.gettotalMarks() > another.gettotalMarks()){
            return 1;
        }else {
            return 0;
        }
    }
}
