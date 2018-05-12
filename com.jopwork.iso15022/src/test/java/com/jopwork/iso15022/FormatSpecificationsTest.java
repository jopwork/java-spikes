package com.jopwork.iso15022;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FormatSpecificationsTest {
    @Test
    public void readFromCsvFile() throws IOException {
        String csvFilename = getClass().getClassLoader().getResource("MTXXX.csv").getFile();
        List<FormatSpecifications> results = FormatSpecifications.readFrom(csvFilename);
        assertThat(results.size(), is(103));
    }
}
