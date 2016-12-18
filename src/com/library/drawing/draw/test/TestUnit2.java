package com.library.drawing.draw.test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import com.library.drawing.draw.helper.DrawHelper;
import com.library.drawing.draw.service.impl.DrawServiceImpl;

public class TestUnit2 {

    DrawHelper drawHelper = new DrawHelper();

    DrawServiceImpl drawServiceImpl = new DrawServiceImpl();

    @Test
    public void convertToLowerCase() {
        char c = 'Z';
        assertEquals('z', Character.toLowerCase(c));
    }

    @Test
    public void findMaxAndMin() {
        Map<String, Integer> coordinates = drawHelper.getMaxMin(8, 3, 2, 9);
        int minX = coordinates.get("minX");
        int minY = coordinates.get("minY");
        int maxX = coordinates.get("maxX");
        int maxY = coordinates.get("maxY");
        assertEquals(2, minX);
        assertEquals(3, minY);
        assertEquals(8, maxX);
        assertEquals(9, maxY);
    }

    @Test
    public void splitWhiteSpace() {
        String input = "   l     13   34";
        String[] result = drawHelper.splitWhitespace(input);
        assertEquals("l", result[0]);
        assertEquals("13", result[1]);
        assertEquals("34", result[2]);
    }

    @Test
    public void remoteUnwantedWhiteSpace() {
        String input = "   c    14    15";
        input = input.trim().replaceAll(" +", " ");
        assertEquals("c 14 15", input);
    }

    @Test
    public void testDrawRectangle() {
        char[][] canvas = new char[5][5];
        int x1 = 2;
        int y1 = 2;
        int x2 = 4;
        int y2 = 4;
        canvas = drawServiceImpl.drawRectangle(canvas, x1, y1, x2, y2);
        assertEquals('*', canvas[2][2]);
        assertEquals('*', canvas[2][3]);
        assertEquals('*', canvas[2][4]);
        assertEquals('*', canvas[3][2]);
        assertEquals('*', canvas[3][4]);
        assertEquals('*', canvas[4][2]);
        assertEquals('*', canvas[4][3]);
        assertEquals('*', canvas[4][4]);
    }

}
