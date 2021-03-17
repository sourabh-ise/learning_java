
package com.fresco;


import java.util.*;


public class ScoreList<T> {
    ArrayList<String> x = new ArrayList<>();

    public void addElement(String e) {
        x.add(e);
    }

    public void removeElement(String e) {
        x.remove(e);
    }

    public String getElement(String e) {
        return x.get(x.indexOf(e));
    }

    public void averageValues() {

    }
}
