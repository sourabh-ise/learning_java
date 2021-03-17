package com.fresco;

public class SelfFinance extends Student {
    @Override
    public String result(String allMarks) {
        String[] sections = allMarks.split("\\|");
        String subjects = sections[0];
        String[] individualSubjects = subjects.split(",");



        String sports = sections[1];
        String[] sportsSection = sports.split(",");
        boolean sportsAwarded = sportsSection[0].equals("1");

        int creditPoints = 0;
        double gradePoint = 0;
        for (String subject : individualSubjects) {
            String[] s = subject.split(" ");
            creditPoints += 5;
            gradePoint += Integer.parseInt(s[1]) * met(s[0]);
        }

        if (sportsAwarded) {
            creditPoints += 5;
            gradePoint += Integer.parseInt(sportsSection[2]) * met(sportsSection[1]);
        }
        double cgpa = gradePoint / creditPoints;


        return String.format("%.2f", cgpa);
    }
}
