package com.test.task.bussystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusDirection {
    private String from;
    private String to;
    private Boolean direct;
}
