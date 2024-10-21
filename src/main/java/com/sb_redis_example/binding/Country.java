package com.sb_redis_example.binding;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Data
public class Country implements Serializable {

    private Integer sno;
    private String  name;
    private String countryCode;
}
