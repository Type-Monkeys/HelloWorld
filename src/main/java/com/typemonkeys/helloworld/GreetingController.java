package com.typemonkeys.helloworld;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class GreetingController {
    public String get() {
        String result = "Hello World";
        return result;
    }

    public String get(String personName) {
        if (personName.isEmpty()) {
            return get();
        } else {
            return "Hello " + personName;
        }
    }

    public String get(int repetition) {
        String result = "";

        for(int i = 0; i < repetition; i++){
            result = result + "Hello,";
        }
        return result.substring(0, result.length() - 1) ;
    }
}
