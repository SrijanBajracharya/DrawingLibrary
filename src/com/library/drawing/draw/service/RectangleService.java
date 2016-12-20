package com.library.drawing.draw.service;

import java.awt.Canvas;
import java.util.Map;

/**
 * 
 * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
 *
 */
public interface RectangleService {

    /**
     * inserts "*" to a multidimensional array to draw rectangle
     * 
     * @param canvas
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return {@link Canvas}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] drawRectangle(char[][] canvas, int x1, int y1, int x2, int y2);

    /**
     * checks if the coordinates x y lies inside the rectangle or not
     * 
     * @param x
     * @param y
     * @param coordinates
     * @return {@link Boolean}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public Boolean isInsideRectangle(int x, int y, Map<String, Integer> coordinates, int height, int width);
}
