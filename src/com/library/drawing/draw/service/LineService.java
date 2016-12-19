package com.library.drawing.draw.service;

import java.util.Map;

public interface LineService {

    char[][] drawLine(char[][] canvas, Map<String, Integer> coordinates);

    char[][] line(char[][] canvas, Map<String, Integer> coordinates);

    char[][] removeLineFill(char[][] canvas, Map<String, Integer> coordinates, int width, int height);
}
