
package com.fresco;


import java.util.*;
import java.util.stream.Collectors;

public class StudentList<T> {

    ArrayList<String> x;

    public void addElement(String t) {
        x.add(t);
    }

    public void removeElement(String t) {
        x.remove(t);
    }



    public void getElement() {

    }

    public void bloodGroupOf() {

    }

    public void thresholdScore() {

    }
    public List<String> beginsWith(String string) {
        List<String> collect = x.stream().filter(x->x.toLowerCase().startsWith(string)).collect(Collectors.toList());
        return collect;
    }

}
