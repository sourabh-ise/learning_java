import java.util.Scanner;

//https://stackoverflow.com/a/65389652
class Task1 extends Thread {
    static int a = 0;
    static int beg = 0;

    public void run(){
        for(int i=beg;i < a;i++)
            Multithreading.threadArray[i] = i; // Multithreading.threadArray[i] = i+1; if  line 67 has && check
    }
}

class Task2 extends Thread {
    static int a = 0;
    static int beg = 0;

    public void run(){
        for(int i=beg; i< beg + a;i++)
            Multithreading.threadArray[i] = i;
    }
}

class Task3 extends Thread{
    static int a = 0;
    static int beg = 0;
    public void run(){
        for(int i=beg;i< a + beg;i++)
            Multithreading.threadArray[i] = i;
    }
}

public class Multithreading {
    public static final int[] threadArray = new int[300];
    public static volatile String i = 0 + "";

    public boolean test() throws InterruptedException {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Thread task2Thread = new Thread(task2);
        Thread task3Thread = new Thread(task3);
        task1.start();
        task2Thread.start();
        task1.join();
        task2Thread.join();
        task3Thread.start();
        int first = Task1.a + Task2.a;
        int containsSecondThread = Task1.a;
        String oneAndTwo = "";
        String sizeOfTask1 = "";
        for (int i = 0; i < first; i++) {
            oneAndTwo += threadArray[i] + " ";
        }
        for (int i = 0; i < containsSecondThread; i++) {
            sizeOfTask1 += threadArray[i] + " ";
        }
        int begOfTask3 = Task3.beg;
        String checkingString = "";
        for (int i = begOfTask3; i < threadArray.length; i++) {
            checkingString += i + " ";
        }
        String task3String = "";
        for (int j = begOfTask3; j < threadArray.length; j++) {
            task3String += threadArray[j] + " ";
        }
        if ((!oneAndTwo.contains(begOfTask3 + "") && sizeOfTask1.contains(Task2.beg + "")) || task3String.equals(checkingString)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Multithreading solution = new Multithreading();
        int one = sc.nextInt();
        Task1.a = one;
        Task1.beg = 0;
        int two = sc.nextInt();
        Task2.a = two;
        Task2.beg = one;
        int three = sc.nextInt();
        Task3.a = three;
        Task3.beg = one + two;
        System.out.print(solution.test());
    }
}
