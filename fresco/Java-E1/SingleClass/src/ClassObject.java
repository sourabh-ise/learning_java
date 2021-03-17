import java.io.*;
import java.util.*;

class Register {

    static Map<String,Double> reg;

    private static Register register = null;

    public static Register getInstance() {
        if (register == null){
            reg = new HashMap<>();
            reg.put("apple",2.0);
            reg.put("orange",1.5);
            reg.put("mango",1.2);
            reg.put("grape",1.0);
            register = new Register();
        }
        return register;
    }

    public String getTotalBill(Map<String, Integer> itemDetails) {
        double totalPrice=0;
        for (Map.Entry<String, Integer> x : itemDetails.entrySet()) {
            Double unitPrice = reg.get(x.getKey());
            totalPrice += x.getValue() * unitPrice;
        }
        return String.valueOf(totalPrice);
    }
}

public class ClassObject {
    public static void main(String[] args) throws IOException {

        Scanner readInput = new Scanner(System.in);
        String[] input = readInput.nextLine().split(" ");
        Map<String, Integer> myItems = new HashMap<String, Integer>();
        for (int i = 0; i < input.length; i += 2) {
            myItems.put(input[i], Integer.parseInt(input[i + 1]));
        }
        Register regObj = Register.getInstance();
        System.out.println(regObj.getTotalBill(myItems));
        readInput.close();
    }
}
