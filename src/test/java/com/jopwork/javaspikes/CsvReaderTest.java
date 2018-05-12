package com.jopwork.javaspikes;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.out;

public class CsvReaderTest {
    @Test
    public void readFileTest() throws IOException {

        CSVFormat parser = CSVFormat.EXCEL
                .withHeader(
                        "Status",
                        "Tag",
                        "Qualifier",
                        "Generic Field Name",
                        "Detailed Field Name",
                        "Content/Options",
                        "No.");

        Iterable<CSVRecord> records = parser.parse(new FileReader(getClass().getClassLoader().getResource("MTXXX.csv").getFile()));

        for (CSVRecord record : records) {
            out.println("=== NEW RECORD ===");
            out.println("Status              : " + record.get("Status"));
            out.println("Tag                 : " + record.get("Tag"));
            out.println("Qualifier           : " + record.get("Qualifier"));
            out.println("Generic Field Name  : " + record.get("Generic Field Name"));
            out.println("Detailed Field Name : " + record.get("Detailed Field Name"));
            out.println("Content/Options     : " + record.get("Content/Options"));
            out.println("No.                 : " + record.get("No."));
        }
    }
}
