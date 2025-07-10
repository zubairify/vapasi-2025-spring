package com.tw.dto;

import lombok.Data;

@Data
public class OrderDto {
    private int custId;
    private int code;
    private String payMode;
}
