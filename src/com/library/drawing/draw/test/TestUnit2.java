package com.library.drawing.draw.test;

import static org.junit.Assert.assertEquals;

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

public class TestUnit2 {

    DrawHelper drawHelper = new DrawHelper();

    DrawService drawServiceImpl = new DrawServiceImpl();

    RectangleService rectangleServiceImpl = new RectangleServiceImpl();
    LineService lineServiceImpl = new LineServiceImpl();
    CanvasService canvasServiceImpl = new CanvasServiceImpl();

    @Test
    public void testConvertToLowerCase() {
        char c = 'Z';
        assertEquals('z', Character.toLowerCase(c));
    }

    @Test
    public void testGetMaxMin() {
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
    public void testSplitWhiteSpace() {
        String input = "   l     13   34";
        String[] result = drawHelper.splitWhitespace(input);
        assertEquals("l", result[0]);
        assertEquals("13", result[1]);
        assertEquals("34", result[2]);
    }

    @Test
    public void testRemoveUnwantedWhiteSpace() {
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
        canvas = rectangleServiceImpl.drawRectangle(canvas, x1, y1, x2, y2);
        assertEquals('*', canvas[2][2]);
        assertEquals('*', canvas[2][3]);
        assertEquals('*', canvas[2][4]);
        assertEquals('*', canvas[3][2]);
        assertEquals('*', canvas[3][4]);
        assertEquals('*', canvas[4][2]);
        assertEquals('*', canvas[4][3]);
        assertEquals('*', canvas[4][4]);
        assertEquals('\0', canvas[1][1]);
    }

    @Test
    public void testIsRectangle() {
        Boolean isRectangle = drawHelper.isRectangle(9, 0, 3, 12);
        assertEquals(Boolean.TRUE, isRectangle);
    }

}
