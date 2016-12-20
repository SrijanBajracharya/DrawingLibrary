package com.library.drawing.draw.service.impl;

import java.util.Map;

import com.library.drawing.draw.service.RectangleService;

public class RectangleServiceImpl implements RectangleService {

    /**
     * {@inheritDoc}
     */
    @Override
    public char[][] drawRectangle(char[][] canvas, int x1, int y1, int x2, int y2) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (j == x1 || j == x2) {
                    if (y1 <= i && y2 >= i) {
                        canvas[i][j] = '*';
                    } else if (y1 >= i && y2 <= i) {
                        canvas[i][j] = '*';
                    }

                } else if (i == y1 || i == y2) {
                    if (x1 <= j && x2 >= j) {
                        canvas[i][j] = '*';
                    } else if (x1 >= j && x2 <= j) {
                        canvas[i][j] = '*';
                    }
                }
            }

        }
        return canvas;
    }

    @Override
    public Boolean isInsideRectangle(int x, int y, Map<String, Integer> coordinates, int height, int width) {
        Integer minX = coordinates.get("minX");
        Integer minY = coordinates.get("minY");
        Integer maxX = coordinates.get("maxX");
        Integer maxY = coordinates.get("maxY");
        if ((x >= minX && x <= maxX) && (y >= minY && y <= maxY)) {
            return true;
        } else if ((minX == maxX && (maxY == height - 1 && minY == 0)) || (minY == maxY && (maxX == width - 1 && minX == 0))) {
            return true;
        }
        return false;
    }
}
