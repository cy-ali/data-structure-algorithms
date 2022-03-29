package jd2;

import java.util.ArrayList;
import java.util.List;

public class assignment_5_SunsetViews {
    public static void main(String[] args) {
        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};

        System.out.println(sunsetViews(buildings, "EAST"));
    }

    public static List<Integer> sunsetViews(int[] buildings, String direction) {
        List<Integer> result = new ArrayList<>();
        int max = 0;

        if (direction.equals("WEST")) {
            for (int i = 0; i < buildings.length; i++) {
                if (buildings[i] > max) {
                    result.add(i);
                    max = buildings[i];
                }
            }
        } else if (direction.equals("EAST")) {
            for (int i = buildings.length - 1; i >= 0; i--) {
                if (buildings[i] > max) {
                    result.add(0, i);
                    max = buildings[i];
                }
            }
        } else {
            System.out.println("!!!illegal argument as direction!!!");
        }
        return result;
    }

}
