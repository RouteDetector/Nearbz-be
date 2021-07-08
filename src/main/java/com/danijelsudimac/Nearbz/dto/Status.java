package com.danijelsudimac.Nearbz.dto;

import lombok.Data;

@Data
public class Status {
    private boolean value;

    public Status(boolean value) {
        this.value = value;
    }
}
