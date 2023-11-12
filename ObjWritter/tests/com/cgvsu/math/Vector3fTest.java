package com.cgvsu.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector3fTest {
    @Test
    public void toStringVector3fTest(){
        Vector3f v3 = new Vector3f(10, 0, -1222);
        Assertions.assertEquals("10.0 0.0 -1222.0", v3.toString());
    }
}
