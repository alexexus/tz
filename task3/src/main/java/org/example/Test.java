package org.example;

import lombok.Data;

import java.util.List;

@Data
public class Test {
    private long id;
    private String title;
    private String value;
    private List<Test> values;
}
