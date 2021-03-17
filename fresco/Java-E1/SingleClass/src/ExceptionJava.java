import java.util.Scanner;
import java.util.stream.Collectors;

class Validator {
    public static boolean validate(String message) {
        return message.matches("[A-Za-z0-9 ]+");
    }
}

public class ExceptionJava {
    //Kate Winslet - input
    //telsniw etak - output
    private static final Scanner INPUT_READER = new Scanner(System.in);

    public static void main(String[] args) {
        String message = INPUT_READER.nextLine();

        try {
            String encrypted_message = Encrypter.encryptMessage(message);
            if (!encrypted_message.startsWith("InvalidMessageException"))
                System.out.println(encrypted_message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}

class Encrypter {
    public static String encryptMessage(String message) throws InvalidMessageException {
        if (Validator.validate(message)) {
            char[] charArray = message.toCharArray();
            String x = "";
            for(int i=charArray.length;i>0;i--){
                if(Character.isLowerCase(charArray[i-1])){
                    x+=Character.toLowerCase(charArray[i-1]);
                }else{
                    x+=Character.toLowerCase(charArray[i-1]);
                }
            }
            return x;

//            return message.chars().mapToObj(x -> {
//                if (Character.isLowerCase((char) x)) {
//                    return Character.toUpperCase((char) x);
//                } else {
//                    return Character.toLowerCase((char) x);
//                }
//            }).map(String::valueOf).collect(Collectors.joining());
        } else {
            throw new InvalidMessageException("Try again with valid message");
        }
    }
}

class InvalidMessageException extends Exception {
    public InvalidMessageException(String message) {
        super(message);
    }
}