
package com.fresco;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentClass {


    public String getQuery(String studentData, String query) {
        String[] split = query.split(",");
        String queryType = split[0];
        switch (queryType) {
            case "1":
                return findByStartingLetter(studentData, split[1]);
            case "2":
                return findByBloodGroup(studentData, split[1], split[2]);
            case "3":return  findStudentsWhoScoredMoreThan(studentData, split[1]);
            case "4": return findAverage(studentData);
            case "5" : return findCGPA(studentData);
        }
        return null;
    }

    private String findCGPA(String studentData) {
        List<Double> studentMarks = new ArrayList<>();
        for(String student:studentData.split(" ")){
            studentMarks.add(Double.parseDouble(student));
        }
        Double average = studentMarks.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        return String.format("%.2f", average);
    }

    private String findAverage(String studentData) {
        List<Integer> studentMarks = new ArrayList<>();
        for(String student:studentData.split(" ")){
            studentMarks.add(Integer.parseInt(student));
        }
        Double average = studentMarks.stream().mapToInt(Integer::intValue).average().orElse(0);
        return String.format("%.2f", average);
    }

    private String findStudentsWhoScoredMoreThan(String studentData, String scoreMoreThan) {
        String[] studentScoreStr = studentData.split(" ");
        int score = Integer.parseInt(scoreMoreThan);
        List<Integer> studentMarks = new ArrayList<>();
        for(String student:studentScoreStr){
            studentMarks.add(Integer.parseInt(student));
        }
        long count = studentMarks.stream().filter(x -> x >= score).count();
        return String.valueOf(count)+" students scored "+scoreMoreThan+" above";
    }

    private String findByBloodGroup(String studentData, String respectiveBg, String requiredBg) {
        StringBuilder res = new StringBuilder();
        String[] students = studentData.split(" ");
        String[] bg = respectiveBg.split(" ");
        for (int i = 0; i < students.length; i++) {
           if(requiredBg.equals(bg[i])){
               res.append(students[i]+"\n");
           }
        }
        return res.toString();
    }

    private String findByStartingLetter(String studentData, String startsWith) {
        String[] s1 = studentData.split(" ");
        StringBuilder res = new StringBuilder();
        for (String student : s1) {
            if (student.toLowerCase().startsWith(startsWith)) {
                res.append(student);
                res.append("\n");
            }
        }
        return res.toString();
    }


}
