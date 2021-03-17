//import java.util.Arrays;
//import java.util.Scanner;
//
//interface HockeyTeam {
//    int calculateHockeyScore();
//
//    int findHighestGoalByIndividualInHockey();
//}
//
//interface FootballTeam {
//
//    int calculateFootballScore();
//
//    int findHighestGoalByIndividualInFootball();
//}
//
//class Sport implements HockeyTeam, FootballTeam {
//    int[] hockeyPlayers, footballPlayers;
//
//    public Sport(int[] hockeyPlayers, int[] footballPlayers) {
//        this.hockeyPlayers = hockeyPlayers;
//        this.footballPlayers = footballPlayers;
//    }
//
//    @Override
//    public int calculateHockeyScore() {
//        return Arrays.stream(hockeyPlayers).sum();
//    }
//
//    @Override
//    public int findHighestGoalByIndividualInHockey() {
//        return Arrays.stream(hockeyPlayers).max().orElse(0);
//    }
//
//    @Override
//    public int calculateFootballScore() {
//        return Arrays.stream(footballPlayers).sum();
//    }
//
//    @Override
//    public int findHighestGoalByIndividualInFootball() {
//        return Arrays.stream(footballPlayers).max().orElse(0);
//    }
//}
//
//public class MultipleInheritance {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int[] hockeyPlayers = new int[11];
//        int[] footballPlayers = new int[11];
//
//        for (int i = 0; i < 11; i++) {
//            hockeyPlayers[i] = sc.nextInt();
//        }
//
//        for (int i = 0; i < 11; i++) {
//            footballPlayers[i] = sc.nextInt();
//        }
//
//        Sport s = new Sport(hockeyPlayers, footballPlayers);
//        try {
//            HockeyTeam.class.getMethod("calculateHockeyScore");
//            HockeyTeam.class.getMethod("findHighestGoalByIndividualInHockey");
//            FootballTeam.class.getMethod("calculateFootballScore");
//            FootballTeam.class.getMethod("findHighestGoalByIndividualInFootball");
//
//            if (s instanceof HockeyTeam && s instanceof FootballTeam) {
//                System.out.println(s.calculateHockeyScore());
//                System.out.println(s.calculateFootballScore());
//                System.out.println(s.findHighestGoalByIndividualInHockey());
//                System.out.println(s.findHighestGoalByIndividualInFootball());
//            }
//        } catch (NoSuchMethodException ex) {
//            System.out.println("No such function is exits");
//        }
//    }
//}
