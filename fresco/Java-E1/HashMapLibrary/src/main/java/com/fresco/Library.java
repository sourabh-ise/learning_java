package com.fresco;

import java.util.*;
import java.util.stream.Collectors;

class Library {

    String bookName;
    String author;

    Library() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.bookName);
        hash = 83 * hash + Objects.hashCode(this.author);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Library other = (Library) obj;
        if (!Objects.equals(this.bookName, other.bookName)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return true;
    }


    Library(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }


    public HashMap<Integer, Library> createLibraryMap(String booksInLibrary) {
        String[] bookList = booksInLibrary.split("\\|");
        HashMap<Integer, Library> lib = new HashMap<>();
        for (String bookDetails : bookList) {
            String[] bookDetail = bookDetails.split(",");
            lib.put(Integer.parseInt(bookDetail[0]), new Library(bookDetail[1], bookDetail[2]));
        }
        return lib;
    }

    public HashMap<Integer, Integer> createUserMap(String borrowedUsers) {
        String[] usersList = borrowedUsers.split("\\|");
        HashMap<Integer, Integer> userMap = new HashMap<>();
        for (String users : usersList) {
            String[] userDetails = users.split(",");
            userMap.put(Integer.parseInt(userDetails[0]), Integer.parseInt(userDetails[1]));
        }
        return userMap;
    }


    public String getQuery(String booksInLibrary, String borrowedUsers, String query) {
        HashMap<Integer, Library> libraryMap = createLibraryMap(booksInLibrary);
        HashMap<Integer, Integer> userMap = createUserMap(borrowedUsers);
        String[] queryDetails = query.split(",");
        StringBuilder res = new StringBuilder();
        switch (queryDetails[0]) {
            case "1":
                if (userMap.containsKey(Integer.parseInt(queryDetails[1]))) {
                    return "No Stock\nIt is owned by " + userMap.get(Integer.parseInt(queryDetails[1])) + "\n";
                } else {
                    Library bookDetails = libraryMap.get(Integer.parseInt(queryDetails[1]));
                    return "It is available\nAuthor is " + bookDetails.author + "\n";
                }

            case "2":
                Set<Integer> collect = userMap.keySet().stream().filter(key -> Integer.parseInt(queryDetails[1]) == userMap.get(key)).collect(Collectors.toSet());
                collect.stream().forEach(x -> res.append(x).append(" ").append(libraryMap.get(x).bookName).append("\n"));
                return res.toString();
            case "3":
                Set<Integer> booksByName = libraryMap.keySet().stream().filter(key->libraryMap.get(key).bookName.contains(queryDetails[1])).collect(Collectors.toSet());
                int inCounter = 0;
                int outCounter = 0;
                for (Integer book : booksByName) {
                    if (userMap.containsKey(book)) {
                        outCounter++;
                    } else {
                        inCounter++;
                    }
                }
                return res.append(outCounter+" out\n").append(inCounter+" in\n").toString();
            case "4":
                Set<Integer> booksByAuthor = libraryMap.keySet().stream().filter(key->libraryMap.get(key).author.contains(queryDetails[1])).collect(Collectors.toSet());
                for(int b:booksByAuthor){
                    res.append(libraryMap.get(b).bookName+"\n");
                }
                return res.toString();
            case "5":
                Set<Integer> booksBySName = libraryMap.keySet().stream().filter(key->libraryMap.get(key).bookName.toLowerCase().contains(queryDetails[1])).collect(Collectors.toSet());
                System.out.println(queryDetails[1]);
                System.out.println(queryDetails[1]);
                for(int b:booksBySName){
                    res.append(b + " "+libraryMap.get(b).bookName+"\n");
                }
                return res.toString();
        }
        return null;
    }

}

