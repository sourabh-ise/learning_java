import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgramming {
    public List<Long> functionalProgtamming(List<String> listOfIntegers) {
        List<Long> outputList = listOfIntegers
                .stream()
                .map(x -> String.valueOf((long) Math.pow(Long.parseLong(x), 2)))
                .filter(x ->
                        {
                            int sqrt = (int) Math.sqrt(Long.parseLong(x));
                            return x.length() != 1
                                    ? Integer.parseInt(x.substring(0, (x.length() / 2))) +
                                    Integer.parseInt(x.substring(x.length() / 2)) == sqrt
                                    : Integer.parseInt(x) == sqrt;
                        }
                )
                .map(x -> (long) Math.sqrt(Long.parseLong(x)))
                .collect(Collectors.toList());
        return outputList;
    }
}
