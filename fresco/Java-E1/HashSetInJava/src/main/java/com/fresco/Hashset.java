package com.fresco;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Hashset {
    public static String getOut(int numberOfMatches, String squads, int squad1, int squad2) {
        String[] playersInEachMatch = squads.split("#");
        Set<String>  allMatches = Arrays.stream(playersInEachMatch[0].split(" ")).collect(Collectors.toSet());
        for(String match:playersInEachMatch){
            Set<String> tempSet = new HashSet<>();
            for(String player:match.split(" ")) {
                tempSet.add(player);
            }
            allMatches.retainAll(tempSet);
        }
        Set<String>  from = Arrays.stream(playersInEachMatch[squad1-1].split(" ")).collect(Collectors.toSet());
        Set<String>  req = Arrays.stream(playersInEachMatch[squad2-1].split(" ")).collect(Collectors.toSet());
        req.removeAll(from);
        StringBuilder b = new StringBuilder();
        allMatches.forEach(x->b.append(x+" "));
        b.append(", ");
        req.forEach(x->b.append(x+" "));
        return b.toString();
    }
}
