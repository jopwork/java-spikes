package com.jopwork.javaspikes;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PermutationTests {
    private Set<String> results;

    @Test
    public void nullHandling() {
        results = permute(null);
        assertTrue(results.contains(null));
    }

    @Test
    public void emptyString() {
        results = permute("");
        assertTrue(results.contains(""));
    }

    @Test
    public void singleChar() {
        results = permute("A");
        assertTrue(results.contains("A"));
    }

    @Test
    public void twoChars() {
        results = permute("AB");
        assertTrue(results.contains("AB"));
        assertTrue(results.contains("BA"));
    }

    @Test
    public void threeChars() {
        results = permute("XYZ");
        assertEquals(6, results.size());
        assertTrue(results.contains("XYZ"));
        assertTrue(results.contains("XZY"));
        assertTrue(results.contains("YXZ"));
        assertTrue(results.contains("YZX"));
        assertTrue(results.contains("ZXY"));
        assertTrue(results.contains("ZYX"));

    }

    private Set<String> permute(String str) {
        Set<String> result = new HashSet<>();
        if (str == null || str.length() <= 1) {
            result.add(str);
        } else {
            char head = str.charAt(0);
            String tail = str.substring(1);
            Set<String> tailPermutations = permute(tail);
            for (String each : tailPermutations) {
                for (int i = 0; i <= each.length(); i++) {
                    String begin = each.substring(0, i);
                    String end = each.substring(i);
                    result.add(begin + head + end);
                }
            }
        }

        return result;
    }
}
