package com.library.drawing.draw.service.impl;

import java.util.Map;

import com.library.drawing.draw.helper.DrawHelper;
import com.library.drawing.draw.service.LineService;

/**
 * 
 * @author Srijan Bajracharya<srijan.bajracharya@gmail.com>
 *
 */
public class LineServiceImpl implements LineService {

    DrawHelper drawHelper = new DrawHelper();

    /**
     * {@inheritDoc}
     */
    @Override
    public char[][] drawLine(char[][] canvas, Map<String, Integer> coordinates) {
        Integer minX = coordinates.get("minX");
        Integer minY = coordinates.get("minY");
        Integer maxX = coordinates.get("maxX");
        Integer maxY = coordinates.get("maxY");
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (j == maxX && j != canvas.length - 1) {
                    if (minY <= i && i <= maxY) {
                        canvas[i][j] = '+';
                    }

                } else if (i == maxY && i != canvas[i].length - 1) {
                    if (minX <= j && j <= maxX) {
                        canvas[i][j] = '+';
                    }
                } else if (j == minX && j != 0) {
                    if (minY <= i && i <= maxY) {
                        canvas[i][j] = '+';
                    }
                } else if (i == minY && i != 0) {
                    if (minX <= j && j <= maxX) {
                        canvas[i][j] = '+';
                    }
                }
            }
        }
        return canvas;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char[][] line(char[][] canvas, Map<String, Integer> coordinates) {
        Integer minX = coordinates.get("minX");
        Integer minY = coordinates.get("minY");
        Integer maxX = coordinates.get("maxX");
        Integer maxY = coordinates.get("maxY");
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (j == maxX) {
                    if (minY <= i && i <= maxY) {
                        canvas[i][j] = '+';
                    }

                } else if (i == minY) {
                    if (minX <= j && j <= maxX) {
                        canvas[i][j] = '+';
                    }
                }

            }
        }
        return canvas;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char[][] removeLineFill(char[][] canvas, Map<String, Integer> coordinates, int width, int height) {
        Integer minX = coordinates.get("minX");
        Integer minY = coordinates.get("minY");
        Integer maxX = coordinates.get("maxX");
        Integer maxY = coordinates.get("maxY");
        if (minY == 0 && (minX == 0 || maxX >= width - 1 || maxY >= height - 1)) {
            canvas = lineFillremove(canvas, minY + 1, maxY, minX + 1, maxX);
        } else if (maxY >= height - 1 && (minX == 0 || maxX >= width - 1 || minY == 0)) {
            canvas = lineFillremove(canvas, minY + 1, maxY, minX + 1, maxX);
        } else if (minX == 0 && (minY == 0 || maxX >= width - 1 || maxY >= height - 1)) {
            canvas = lineFillremove(canvas, minY + 1, maxY, minX + 1, maxX);
        } else if (maxX >= width - 1 && (minY == 0 || maxY >= height - 1 || minX == 0)) {
            canvas = lineFillremove(canvas, minY + 1, maxY, minX + 1, maxX);
        }
        return canvas;
    }

    private char[][] lineFillremove(char[][] canvas, int minX, int maxX, int minY, int maxY) {
        for (int i = minX; i < maxX; i++) {
            for (int j = minY; j < maxY; j++) {
                canvas[i][j] = ' ';
            }
        }
        return canvas;
    }
}
