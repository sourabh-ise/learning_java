package com.fresco;

public class Aided extends Student {
    @Override
    public String result(String allMarks) {
        String[] sections = allMarks.split("\\|");
        String subjects = sections[0];
        String[] individualSubjects = subjects.split(",");

        String ncc = sections[1];
        String[] nccSection = ncc.split(",");
        boolean nccAwarded = nccSection[0].equals("1");

        String sports = sections[2];
        String[] sportsSection = sports.split(",");
        boolean sportsAwarded = sportsSection[0].equals("1");

        int creditPoints = 0;
        double gradePoint = 0;
        for (String subject : individualSubjects) {
            String[] s = subject.split(" ");
            creditPoints += 5;
            gradePoint += Integer.parseInt(s[1]) * met(s[0]);
        }
        if (nccAwarded) {
            creditPoints += 5;
            gradePoint += Integer.parseInt(nccSection[2]) * met(nccSection[1]) ;
        }
        if (sportsAwarded) {
            creditPoints += 5;
            gradePoint += Integer.parseInt(sportsSection[2]) * met(sportsSection[1]);
        }
        double cgpa = gradePoint / creditPoints;
        return String.format("%.2f", cgpa);
    }
}
