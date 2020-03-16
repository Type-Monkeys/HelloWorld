package com.typemonkeys.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Greeting {
    private String id; // uniquely identify
    private String message; // what it says

    public String getId(){
        return id;
    }
}
