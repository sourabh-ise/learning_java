
package com.fresco;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentClass {


    public String getQuery(String studentData, String query) {
        StudentList x = new StudentList();
        x.x = new ArrayList<String>(Arrays.asList(studentData.split(" ")));
        return String.join("\n", x.beginsWith(query.split(",")[1]))+"\n";
    }

}
