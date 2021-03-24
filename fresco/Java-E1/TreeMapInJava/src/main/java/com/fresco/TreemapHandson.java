package com.fresco;

import java.util.*;
import java.util.stream.Collectors;


public class TreemapHandson {

    public TreeMap<Integer, String> createPlayerPositionMap(String cricketDataset) {
        String[] individualPlayers = cricketDataset.split("\\|");
        TreeMap<Integer, String> map = new TreeMap<>();
        for (String player : individualPlayers) {
            String[] playerDetails = player.split(",");
            map.put(Integer.parseInt(playerDetails[0]), playerDetails[1]);
        }
        return map;
    }

    public TreeMap<String, Integer> createPlayerScoreMap(String cricketDataset) {
        String[] individualPlayers = cricketDataset.split("\\|");
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String player : individualPlayers) {
            String[] playerDetails = player.split(",");
            map.put(playerDetails[1], Integer.parseInt(playerDetails[2]));
        }
        return map;
    }

    public TreeMap<String, Double> createMatchesMap(String cricketDataset) {
        String[] individualMatchs = cricketDataset.split("\\n");
        TreeMap<String, Integer> playerScoreMap;
        TreeMap<Integer, String> playerPositionMap;
        Map<String, List<Integer>> res = new HashMap<>();
        for (String individualMatch : individualMatchs) {
            playerPositionMap = createPlayerPositionMap(individualMatch);
            playerScoreMap = createPlayerScoreMap(individualMatch);
            String player = playerPositionMap.get(1);
            int score = playerScoreMap.get(player);
            if (res.containsKey(player)) {
                List<Integer> matchScore = res.get(player);
                matchScore.add(score);
            } else {
                List<Integer> matchScore = new ArrayList<>();
                matchScore.add(score);
                res.put(player, matchScore);
            }
        }

        Map<String, Double> collect = res.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stream().mapToInt(Integer::intValue).average().orElse(0)));
        String key = collect.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        TreeMap<String, Double> result = new TreeMap<>();
        result.put(key, collect.get(key));
        return result;
    }

    public String getQuery(String cricketDataset, String query) {
        String[] qString = new String[0];
        if (query.contains(" ")) {
            qString = query.split(" ");
            query = qString[0];
        }
        TreeMap<Integer, String> map;
        StringBuilder res = new StringBuilder();
        switch (query) {
            case "1":
                map = createPlayerPositionMap(cricketDataset);
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    if (entry.getKey() < Integer.parseInt(qString[1])) {
                        continue;
                    } else if (entry.getKey() > Integer.parseInt(qString[2])) {
                        break;
                    } else {
                        res.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
                    }
                }
                return res.toString();
            case "2":
                map = createPlayerPositionMap(cricketDataset);
                TreeMap<String, Integer> playerScoreMap = createPlayerScoreMap(cricketDataset);
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    if (playerScoreMap.get(entry.getValue()) <= Integer.parseInt(qString[1])) {
                        continue;
                    } else {
                        res.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
                    }
                }
                return res.toString();
            case "3":
                return "The Efficient Opener is " + createMatchesMap(cricketDataset).keySet().iterator().next();
        }
        return null;
    }
}








