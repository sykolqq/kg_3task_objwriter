package com.cgvsu.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2fTest {
    @Test
    public void toStringVector2fTest(){
        Vector2f v2 = new Vector2f(-1, 7);
        Assertions.assertEquals("-1.0 7.0", v2.toString());
    }
}
