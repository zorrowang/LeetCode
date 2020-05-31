package src.java.medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<>();
        Set<String> set = new HashSet<>();
        LinkedList<Character> list = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
            list.offer(s.charAt(i));
            if (i>= 9) {
                Character[] arr = new Character[10];
                arr = list.toArray(arr); 
                Stream<Character> charStream = Arrays.stream(arr);
                String str = charStream.map(String::valueOf).collect(Collectors.joining());
                if (set.contains(str) && !ret.contains(str))
                    ret.add(str);
                else
                    set.add(str);
                list.poll();
            }
        }
        return ret;
    }
}