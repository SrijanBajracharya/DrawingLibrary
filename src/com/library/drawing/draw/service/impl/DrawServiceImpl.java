package com.library.drawing.draw.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.library.drawing.draw.service.DrawService;

public class DrawServiceImpl implements DrawService {

    public char[][] createArray(int width, int height) {
        char[][] canvas = new char[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x == 0 || x == width - 1) {
                    canvas[x][y] = '-';
                } else if (y == 0 || y == height - 1) {
                    canvas[x][y] = '|';
                } else {
                    canvas[x][y] = ' ';
                }
            }
        }
        return canvas;
    }

    public void display(char[][] canvas) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }

    public char[][] drawRect(char[][] canvas, int x1, int y1, int x2, int y2) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (j == x1 || j == x2) {
                    if (y1 <= i && y2 >= i) {
                        canvas[i][j] = '*';
                    }

                } else if (i == y1 || i == y2) {
                    if (x1 <= j && x2 >= j) {
                        canvas[i][j] = '*';
                    }
                }
            }

        }
        return canvas;
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

    public char[][] lineOperation(char[][] canvas, int x1, int y1, int x2, int y2) {
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

        return drawLine(canvas, minX, minY, maxX, maxY);
    }

    public char[][] drawRect(char[][] canvas, Map<String, Integer> coordinates) {
        Integer minX = coordinates.get("minX");
        Integer minY = coordinates.get("minY");
        Integer maxX = coordinates.get("maxX");
        Integer maxY = coordinates.get("maxY");
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (j == minX || j == maxX) {
                    if (minY <= i && maxY >= i) {
                        canvas[i][j] = '*';
                    }

                } else if (i == minY || i == maxY) {
                    if (minX <= j && maxX >= j) {
                        canvas[i][j] = '*';
                    }
                }
            }

        }
        return canvas;
    }

    public char[][] drawLine(char[][] canvas, int minX, int minY, int maxX, int maxY) {
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

    public char[][] fill(char[][] canvas, char c, int minX, int minY, int maxX, int maxY) {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (j > minX && j < maxX) {
                    if (minY < i && i < maxY) {
                        canvas[i][j] = 'o';
                    }

                } else if (i > minY && i < maxY) {
                    if (minX < j && maxX > j) {
                        canvas[i][j] = 'o';
                    }
                }
            }
        }
        return canvas;
    }

    public Boolean isInsideRectangle(int x, int y, int x1, int y1, int x2, int y2) {
        if ((x >= x1 && x <= x2) && (y >= y1 && y <= y2)) {
            return true;
        }
        return false;

    }

}
