package com.library.drawing.draw.service;

import java.awt.Canvas;
import java.util.Map;

public interface DrawService {

    /**
     * detects collision and fills
     * 
     * @param canvas
     * @param x
     * @param y
     * @param c
     * @return {@link Canvas}
     * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
     */
    public char[][] collision(char[][] canvas, int x, int y, char c);

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

    char[][] fillAll(char[][] canvas, char c);

}
