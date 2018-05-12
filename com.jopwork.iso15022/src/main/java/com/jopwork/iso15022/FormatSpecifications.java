package com.jopwork.iso15022;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.isNumeric;

public class FormatSpecifications {
    private String status;
    private String tag;
    private String qualifier;
    private String genericFieldName;
    private String detailedFieldName;
    private String contentOptions;
    private String number;

    public FormatSpecifications(String status, String tag, String qualifier, String genericFieldName, String detailedFieldName, String contentOptions, String number) {
        this.status = status;
        this.tag = tag;
        this.qualifier = qualifier;
        this.genericFieldName = genericFieldName;
        this.detailedFieldName = detailedFieldName;
        this.contentOptions = contentOptions;
        this.number = number;
    }

    public static List<FormatSpecifications> readFrom(String filename) throws IOException {
        CSVFormat parser = CSVFormat.EXCEL.withHeader(
                "Status",
                "Tag",
                "Qualifier",
                "Generic Field Name",
                "Detailed Field Name",
                "Content/Options",
                "No.");

        Iterable<CSVRecord> records = parser.parse(new FileReader(filename));

        List<FormatSpecifications> results = new ArrayList<>();
        for (CSVRecord record : records) {
            String number = record.get("No.");
            if (isNotBlank(number) && isNumeric(number)) {
                results.add(new FormatSpecifications(
                        record.get("Status"),
                        record.get("Tag"),
                        record.get("Qualifier"),
                        record.get("Generic Field Name"),
                        record.get("Detailed Field Name"),
                        record.get("Content/Options"),
                        record.get("No.")));
            }
        }

        return unmodifiableList(results);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getGenericFieldName() {
        return genericFieldName;
    }

    public void setGenericFieldName(String genericFieldName) {
        this.genericFieldName = genericFieldName;
    }

    public String getDetailedFieldName() {
        return detailedFieldName;
    }

    public void setDetailedFieldName(String detailedFieldName) {
        this.detailedFieldName = detailedFieldName;
    }

    public String getContentOptions() {
        return contentOptions;
    }

    public void setContentOptions(String contentOptions) {
        this.contentOptions = contentOptions;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
