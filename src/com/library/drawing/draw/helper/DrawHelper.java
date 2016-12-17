package com.library.drawing.draw.helper;

import java.util.HashMap;
import java.util.Map;

public class DrawHelper {

    public String[] splitWhitespace(String input) {
        input = input.trim().replaceAll(" +", " ");
        return input.split(" ");
    }

    public Map<String, Integer> getMaxMin(int x1, int y1, int x2, int y2) {
        Map<String, Integer> coordinates = new HashMap<>();
        int maxY = y2;
        int minY = y1;
        int maxX = x1;
        int minX = x2;
        if (y1 > y2) {
            maxY = y1;
            minY = y2;
        }
        if (x1 > x2) {
            maxX = x1;
            minX = x2;
        }
        coordinates.put("minX", minX);
        coordinates.put("minY", minY);
        coordinates.put("maxX", maxX);
        coordinates.put("maxY", maxY);
        return coordinates;
    }

}
