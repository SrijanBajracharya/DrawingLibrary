package com.library.drawing.draw.service.impl;

import java.util.Map;

import com.library.drawing.draw.service.LineService;

public class LineServiceImpl implements LineService {

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

    @Override
    public char[][] line(char[][] canvas, Map<String, Integer> coordinates) {
        Integer minX = coordinates.get("minX");
        Integer minY = coordinates.get("minY");
        Integer maxX = coordinates.get("maxX");
        Integer maxY = coordinates.get("maxY");
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (j == minX) {
                    if (minY <= i && i <= maxY) {
                        canvas[i][j] = '+';
                    }

                } else if (i == maxY) {
                    if (minX <= j && j <= maxX) {
                        canvas[i][j] = '+';
                    }
                }

            }
        }
        return canvas;
    }

    @Override
    public char[][] removeLineFill(char[][] canvas, int x1, int y1, int x2, int y2, int width, int height) {
        int minX = x1;
        int minY = y1;
        int maxX = x2;
        int maxY = y2;
        if (y1 > y2) {
            maxY = y1;
            minY = y2;
        }
        if (x1 > x2) {
            maxX = x1;
            minX = x2;
        }

        if (minY == 0 && (minX == 0 || maxX >= width - 1 || maxY >= height - 1)) {
            for (int i = minY + 1; i < maxY; i++) {
                for (int j = minX + 1; j < maxX; j++) {
                    canvas[i][j] = ' ';
                }
            }
        } else if (maxY >= height - 1 && (minX == 0 || maxX >= width - 1 || minY == 0)) {
            for (int i = minY + 1; i < maxY; i++) {
                for (int j = minX + 1; j < maxX; j++) {
                    canvas[i][j] = ' ';
                }
            }
        } else if (minX == 0 && (minY == 0 || maxX >= width - 1 || maxY >= height - 1)) {
            for (int i = minY + 1; i < maxY; i++) {
                for (int j = minX + 1; j < maxX; j++) {
                    canvas[i][j] = ' ';
                }
            }
        } else if (maxX >= width - 1 && (minY == 0 || maxY >= height - 1 || minX == 0)) {
            for (int i = minY + 1; i < maxY; i++) {
                for (int j = minX + 1; j < maxX; j++) {
                    canvas[i][j] = ' ';
                }
            }
        }
        return canvas;
    }
}
