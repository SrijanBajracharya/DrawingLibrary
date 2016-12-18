package com.library.drawing.draw.helper;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
 *
 */
public class DrawHelper {

    /**
     * removes all unnecessary white spaces
     * 
     * @param input
     * @return {@link String} {@link Array}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public String[] splitWhitespace(String input) {
        input = input.trim().replaceAll(" +", " ");
        return input.split(" ");
    }

    /**
     * calculates max and min x and y coordinates
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return {@link Map}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public Map<String, Integer> getMaxMin(int x1, int y1, int x2, int y2) {
        Map<String, Integer> coordinates = new HashMap<>();
        int maxY = y2;
        int minY = y1;
        int minX = x1;
        int maxX = x2;
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

    /**
     * checks if the coordinates represent verticles of a rectangle or draws a straight line
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return {@link Boolean}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public Boolean isRectangle(int x1, int y1, int x2, int y2) {
        Boolean isRectangle = true;
        if (x1 == x2 || y1 == y2) {
            isRectangle = false;
        }
        return isRectangle;
    }

}
