package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EOFInput {
    public static void main(String[] args) {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> lines =  buf.lines();
        List<String> strs = new ArrayList<>();
        lines.forEach(strs::add);
        for(int i = 1; i<= strs.size(); i++) {
            System.out.println(i + strs.get(i-1));
        }
    }
}
