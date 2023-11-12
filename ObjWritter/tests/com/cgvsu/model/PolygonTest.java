package com.cgvsu.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PolygonTest {
    @Test
    public void toStringPolygonTest01(){
        Polygon p = new Polygon();

        p.setVertexIndices(
                new ArrayList<>(Arrays.asList(5, 1, 13))
        );
        p.setTextureVertexIndices(
                new ArrayList<>(Arrays.asList(7, 1, 130))
        );

        p.setNormalIndices(
                new ArrayList<>(Arrays.asList(10, 3, 13))
        );

        Assertions.assertEquals("6/8/11 2/2/4 14/131/14", p.toString());
    }
    @Test
    public void toStringPolygonTest02(){
        Polygon p = new Polygon();

        p.setVertexIndices(
                new ArrayList<>(Arrays.asList(5, 1, 13))
        );
        p.setTextureVertexIndices(
                new ArrayList<>(Arrays.asList(7, -1, 130))
        );

        p.setNormalIndices(
                new ArrayList<>(Arrays.asList(10, 3, -1))
        );

        Assertions.assertEquals("6/8/11 2//4 14/131", p.toString());
    }
    @Test
    public void toStringPolygonTest03(){
        Polygon p = new Polygon();

        p.setVertexIndices(
                new ArrayList<>(Arrays.asList(5, 1, 13, 0))
        );
        p.setTextureVertexIndices(
                new ArrayList<>(Arrays.asList(7, -1, 130, 0))
        );

        p.setNormalIndices(
                new ArrayList<>(Arrays.asList(10, -1, -1, 0))
        );

        Assertions.assertEquals("6/8/11 2 14/131 1/1/1", p.toString());
    }
}
