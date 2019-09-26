package com.quake.logReader.service;

import junit.framework.TestCase;
import sun.java2d.pipe.SpanClipRenderer;

import java.util.StringTokenizer;

public class LogReaderServiceTest extends TestCase {

    private static final String SPACE = " ";

    public void testExecutarLeituraDeLinha() {
        String msg = "1 2 3 4";
        StringTokenizer st = new StringTokenizer(msg, SPACE);

        assertEquals(st.nextToken(), "1");
        assertEquals(st.nextToken(), "2");
    }
}
