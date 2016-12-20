package com.library.drawing.draw.service.impl;

import java.util.Map;

import com.library.drawing.draw.service.DrawService;

/**
 * 
 * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
 *
 */
public class DrawServiceImpl implements DrawService {

    /**
     * {@inheritDoc}
     */
    @Override
    public char[][] fillRectangle(char[][] canvas, Map<String, Integer> coordinates, char c, int x, int y) {
        Integer minX = coordinates.get("minX");
        Integer minY = coordinates.get("minY");
        Integer maxX = coordinates.get("maxX");
        Integer maxY = coordinates.get("maxY");
        int width = canvas.length;
        int height = canvas[0].length;
        if (minX == maxX && x > 0 && x < maxX) {
            canvas = insertIntoRectangle(canvas, c, minY + 1, maxY, 1, maxX);
        } else if (minX == maxX && x > maxX && x < width) {
            canvas = insertIntoRectangle(canvas, c, minY + 1, maxY, maxX + 1, width - 1);

        } else if (minY == maxY && y > 0 && y < maxY) {
            canvas = insertIntoRectangle(canvas, c, 1, maxY, minX + 1, maxX);

        } else if (minY == maxY && y > maxY && y < height) {
            canvas = insertIntoRectangle(canvas, c, maxY + 1, height - 1, minX + 1, maxX);

        } else {
            canvas = insertIntoRectangle(canvas, c, minY + 1, maxY, minX + 1, maxX);
        }
        return canvas;
    }

    private char[][] insertIntoRectangle(char[][] canvas, char c, int minX, int maxX, int minY, int maxY) {
        for (int i = minX; i < maxX; i++) {
            for (int j = minY; j < maxY; j++) {
                if (canvas[i][j] == ' ') {
                    canvas[i][j] = c;
                }
            }

        }
        return canvas;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char[][] removeFill(char[][] canvas, Map<String, Integer> coordinates) {
        Integer minX = coordinates.get("minX");
        Integer minY = coordinates.get("minY");
        Integer maxX = coordinates.get("maxX");
        Integer maxY = coordinates.get("maxY");
        for (int i = minY + 1; i < maxY; i++) {
            for (int j = minX + 1; j < maxX; j++) {
                canvas[i][j] = ' ';
            }
        }

        return canvas;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char[][] fillAll(char[][] canvas, char c) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j] == ' ') {
                    canvas[i][j] = c;
                }
            }
        }
        return canvas;
    }

}
