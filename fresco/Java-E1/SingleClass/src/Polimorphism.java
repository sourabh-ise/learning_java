import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Polimorphism {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Parent x = new ChildOne();
        Parent y = new ChildTwo();
        x.startElement = a;
        x.endElement = b;
        y.startElement = a;
        y.endElement = b;
        x.filter();
        y.filter();
    }


}

class ChildTwo extends Parent {
    public void filter() {
        int endElement = super.endElement;
        int startElement = super.startElement;
        List<Integer> result = new ArrayList<>();
        for (int i = startElement; i <= endElement; i++) {
            int num = i, sum = 0, rem;
            while (sum != 1 && sum != 4) {
                sum = 0;
                while (num != 0) {
                    rem = num % 10;
                    sum += (rem * rem);
                    num /= 10;
                }
                num = sum;
            }
            if (sum == 1)
                result.add(i);
        }
        System.out.print(result.stream().map(Object::toString)
                .collect(Collectors.joining(" ")));
    }

}

class ChildOne extends Parent {
    public void filter() {
        int endElement = super.endElement;
        int startElement = super.startElement;
        int flag, j;
        List<Integer> result = new ArrayList<>();
        for (int i = startElement; i <= endElement; i++) {
            if (i == 1 || i == 0)
                continue;

            flag = 1;
            for (j = 2; j <= i / 2; ++j) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                result.add(i);
        }
        System.out.println(result.stream().map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
}

class Parent {
    public int startElement;
    public int endElement;

    public void filter() {
    }
}