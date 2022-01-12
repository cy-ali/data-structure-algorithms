package day3_stack_recursive_queue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HastTableQuestion_1 {
    public static void main(String[] args) {
        String str = "a qgrckeen apple";
        System.out.println(firstNonRepeatedCharacter(str));
    }

    public static void firstUniqueChar(String s) {

        Map<Integer, Integer> asciiMap = new HashMap<>(256); // <firstIndex,frequency> // map index

        for (int i = 0; i < s.length(); i++) {
            int asciiIndex = s.charAt(i);


        }

//        charMap.entrySet().forEach(o1 -> );


    }

    public static Character firstNonRepeatedCharacter(String str) {
        HashMap<Character, Integer> characterhashtable =
                new LinkedHashMap<Character, Integer>();
        int length;
        Character ch;
        length = str.length();  // Scan string and build hash table
        for (int i = 0; i < length; i++) {
            ch = str.charAt(i);
            if (characterhashtable.containsKey(ch)) {
                // increment count corresponding to ch
                characterhashtable.put(ch, characterhashtable.get(ch) + 1);
            } else {
                characterhashtable.put(ch, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : characterhashtable.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return null;
    }
}

