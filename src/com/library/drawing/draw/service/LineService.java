package com.library.drawing.draw.service;

import java.util.Map;

public interface LineService {

    char[][] drawLine(char[][] canvas, Map<String, Integer> coordinates);

    char[][] line(char[][] canvas, Map<String, Integer> coordinates);

    char[][] removeLineFill(char[][] canvas, int x1, int y1, int x2, int y2, int width, int height);
}
