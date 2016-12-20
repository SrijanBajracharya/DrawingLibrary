package com.library.drawing.draw.service;

import java.awt.Canvas;
import java.lang.reflect.Array;
import java.util.Map;

/**
 * 
 * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
 *
 */
public interface DrawService {

    /**
     * removes unwanted fills
     * 
     * @param canvas
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return {@link Canvas}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] removeFill(char[][] canvas, Map<String, Integer> coordinates);

    /**
     * fills all empty character with user input character
     * 
     * @param canvas
     * @param c
     * @return {@link Canvas} {@link Array}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] fillAll(char[][] canvas, char c);

    /**
     * fills canvas with rectangle coordinates
     * 
     * @param canvas
     * @param coordinates
     * @param c
     * @param x
     * @param y
     * @return {@link Canvas} {@link Array}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] fillRectangle(char[][] canvas, Map<String, Integer> coordinates, char c, int x, int y);

}
