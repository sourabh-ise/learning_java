import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


class Result {
    public static String[] calculateGrade(int[][] students_marks) {
        return Arrays.stream(students_marks)
                .map(student -> Arrays.stream(student)
                .average()
                .orElse(0))
                .map(Result::getGrade)
                .toArray(String[]::new);
    }

    public static String getGrade(Double x){
        if(x<50){
            return "F";
        }else if(x>=50 && x<60){
            return "D";
        }else if(x>=60&&x<70){
            return "C";
        }else if(x>=70&&x<80){
            return "B";
        }else if(x>=80&&x<90){
            return "A";
        }else{
            return "A+";
        }
    }

}
public class Condition {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int students_marksRows = Integer.parseInt(sc.next().trim());
        int students_marksColumns = Integer.parseInt(sc.next().trim());


        int[][] students_marks = new int[students_marksRows][students_marksColumns];
        for(int i = 0; i < students_marksRows; i++)
        {
            for(int j = 0; j < students_marksColumns; j++)
            {
                students_marks[i][j] = Integer.parseInt(sc.next().trim());
            }
        }

        String[] result = Result.calculateGrade(students_marks);

        for(int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
            //bufferedWriter.write(result[i]+"\n");
        }
       // bufferedWriter.close();
    }
}
