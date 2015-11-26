package me.jacquelineabreu.algorithms;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GraphTest {
    @Test
    public void testSourceNearTarget() throws Exception {
        Graph path = new Graph();
        path.addNode(1, Arrays.asList(2, 5));
        path.addNode(2, Arrays.asList(3, 4));
        assertEquals(Arrays.asList(1,2,4), path.findPath(1, 4));
    }

    @Test
    public void testSourceBesideTarget() throws Exception {
        Graph path = new Graph();
        path.addNode(1, Arrays.asList(2, 5));
        path.addNode(2, Arrays.asList(3, 4));
        assertEquals(Arrays.asList(1,2), path.findPath(1, 2));
    }

    @Test
    public void testPathSourceToTargetDontExist() throws Exception {
        Graph path = new Graph();
        path.addNode(1, Arrays.asList(2, 5));
        path.addNode(2, Arrays.asList(3, 4));
        path.addNode(3, Arrays.asList(6, 7));
        assertEquals(Arrays.asList(), path.findPath(5, 7));
    }
}