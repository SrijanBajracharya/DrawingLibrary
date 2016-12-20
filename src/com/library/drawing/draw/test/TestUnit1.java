package com.library.drawing.draw.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.library.drawing.draw.helper.DrawHelper;
import com.library.drawing.draw.service.CanvasService;
import com.library.drawing.draw.service.DrawService;
import com.library.drawing.draw.service.LineService;
import com.library.drawing.draw.service.RectangleService;
import com.library.drawing.draw.service.impl.CanvasServiceImpl;
import com.library.drawing.draw.service.impl.DrawServiceImpl;
import com.library.drawing.draw.service.impl.LineServiceImpl;
import com.library.drawing.draw.service.impl.RectangleServiceImpl;

public class TestUnit1 {

    DrawService drawServiceImpl = new DrawServiceImpl();
    RectangleService rectangleServiceImpl = new RectangleServiceImpl();
    LineService lineServiceImpl = new LineServiceImpl();
    CanvasService canvasServiceImpl = new CanvasServiceImpl();

    @Test
    public void testConvertToLowerCase() {
        char c = 'C';
        assertEquals('c', Character.toLowerCase(c));
    }

    @Test
    public void testGetMaxMin() {
        Map<String, Integer> coordinates = DrawHelper.getMaxMin(7, 9, 3, 2);
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
    public void testSplitWhitespace() {
        String input = " c  13   34";
        String[] result = DrawHelper.splitWhitespace(input);
        assertEquals("c", result[0]);
        assertEquals("13", result[1]);
        assertEquals("34", result[2]);
    }

    @Test
    public void testDrawRectangle() {
        char[][] canvas = new char[5][5];
        int x1 = 2;
        int y1 = 2;
        int x2 = 3;
        int y2 = 3;
        canvas = rectangleServiceImpl.drawRectangle(canvas, x1, y1, x2, y2);
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
        char[][] canvas = canvasServiceImpl.drawCanvas(width, height);
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
        canvas = lineServiceImpl.lineDraw(canvas, coordinates);
        assertEquals('+', canvas[2][2]);
        assertEquals('+', canvas[2][3]);
        assertEquals('+', canvas[2][4]);
        assertEquals('+', canvas[3][4]);
        assertEquals('+', canvas[4][4]);
        assertEquals('\0', canvas[1][1]);
    }

    @Test
    public void testDrawLine() {
        char[][] canvas = new char[5][5];
        Map<String, Integer> coordinates = new HashMap<>();
        coordinates.put("minX", 2);
        coordinates.put("minY", 0);
        coordinates.put("maxY", 2);
        coordinates.put("maxX", 0);
        canvas = lineServiceImpl.drawLine(canvas, coordinates);
        assertEquals('+', canvas[2][0]);
        assertEquals('+', canvas[1][2]);
        assertEquals('+', canvas[0][2]);
        assertEquals('\0', canvas[1][1]);
    }

    @Test
    public void testIsRectangle() {
        Boolean isRectangle = DrawHelper.isRectangle(9, 0, 9, 12);
        assertEquals(Boolean.FALSE, isRectangle);
    }

    @Test
    public void testRemoveFill() {
        char[][] canvas = new char[5][5];
        canvas[3][3] = '*';
        canvas[2][2] = '*';
        Map<String, Integer> coordinates = new HashMap<>();
        coordinates.put("minX", 1);
        coordinates.put("minY", 1);
        coordinates.put("maxX", 4);
        coordinates.put("maxY", 4);
        canvas = drawServiceImpl.removeFill(canvas, coordinates);
        assertEquals(' ', canvas[3][3]);
        assertEquals(' ', canvas[2][2]);
    }

    @Test
    public void testFillAll() {
        char[][] canvas = new char[2][2];
        canvas[0][1] = ' ';
        canvas[1][0] = ' ';
        char c = '%';
        canvas = drawServiceImpl.fillAll(canvas, c);
        assertEquals('%', canvas[0][1]);
        assertEquals('%', canvas[1][0]);
    }

    @Test
    public void testRemoveLineFill() {
        char[][] canvas = new char[5][5];
        int width = 4;
        int height = 4;
        Map<String, Integer> coordinates = new HashMap<>();
        coordinates.put("minX", 0);
        coordinates.put("maxX", 2);
        coordinates.put("minY", 1);
        coordinates.put("maxY", 4);
        canvas = lineServiceImpl.removeLineFill(canvas, coordinates, width, height);
        assertEquals(' ', canvas[2][1]);
    }

}
