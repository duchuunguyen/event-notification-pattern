package com.kms.sadp.eda.common.event;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Event implements Serializable {
    private String eventType;
}
