package com.library.drawing.draw.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.library.drawing.draw.helper.DrawHelper;
import com.library.drawing.draw.service.impl.DrawServiceImpl;

public class TestUnit1 {

    DrawHelper drawHelper = new DrawHelper();
    DrawServiceImpl drawServiceImpl = new DrawServiceImpl();

    @Test
    public void convertToLowerCase() {
        char c = 'C';
        assertEquals('c', Character.toLowerCase(c));
    }

    @Test
    public void findMaxAndMin() {
        Map<String, Integer> coordinates = drawHelper.getMaxMin(7, 9, 3, 2);
        int minX = coordinates.get("minX");
        int minY = coordinates.get("minY");
        int maxX = coordinates.get("maxX");
        int maxY = coordinates.get("maxY");
        assertEquals(3, minX);
        assertEquals(2, minY);
        assertEquals(7, maxX);
        assertEquals(9, maxY);
    }

    @Test
    public void splitWhitespace() {
        String input = " c  13   34";
        String[] result = drawHelper.splitWhitespace(input);
        assertEquals("c", result[0]);
        assertEquals("13", result[1]);
        assertEquals("34", result[2]);
    }

    @Test
    public void remoteUnwantedWhiteSpace() {
        String input = "l    14          15";
        input = input.trim().replaceAll(" +", " ");
        assertEquals("l 14 15", input);
    }

    @Test
    public void testDrawRectangle() {
        char[][] canvas = new char[5][5];
        int x1 = 2;
        int y1 = 2;
        int x2 = 3;
        int y2 = 3;
        canvas = drawServiceImpl.drawRectangle(canvas, x1, y1, x2, y2);
        assertEquals('*', canvas[2][2]);
        assertEquals('*', canvas[2][3]);
        assertEquals('*', canvas[3][2]);
        assertEquals('*', canvas[3][3]);
        assertEquals('\0', canvas[1][1]);

    }

    @Test
    public void testCanvas() {
        int width = 3;
        int height = 3;
        char[][] canvas = drawServiceImpl.drawCanvas(width, height);
        assertEquals('-', canvas[0][0]);
        assertEquals('-', canvas[0][1]);
        assertEquals('-', canvas[0][2]);
        assertEquals('-', canvas[2][0]);
        assertEquals('-', canvas[2][1]);
        assertEquals('-', canvas[2][2]);
        assertEquals('|', canvas[1][0]);
        assertEquals('|', canvas[1][2]);
        assertEquals(' ', canvas[1][1]);
    }

    @Test
    public void testLine() {
        char[][] canvas = new char[5][5];
        Map<String, Integer> coordinates = new HashMap<>();
        coordinates.put("minX", 2);
        coordinates.put("maxY", 4);
        coordinates.put("maxX", 4);
        coordinates.put("minY", 2);
        canvas = drawServiceImpl.drawLine(canvas, coordinates);
        assertEquals('+', canvas[2][2]);
        assertEquals('+', canvas[3][2]);
        assertEquals('+', canvas[4][2]);
        assertEquals('+', canvas[4][3]);
        assertEquals('+', canvas[4][4]);
        assertEquals('\0', canvas[1][1]);
    }

}
