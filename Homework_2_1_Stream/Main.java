import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> result = new ArrayList<>();
        for (int s : intList) {
            if ((s > 0) && (s % 2 == 0)) {
                result.add(s);
            }

        }
        Collections.sort(result);
        System.out.println(result.toString());
    }
}