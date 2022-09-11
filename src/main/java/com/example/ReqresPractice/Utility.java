package com.example.ReqresPractice;

public class Utility {

    public String getMethodName() {
        return new Object() {}
                .getClass()
                .getEnclosingMethod()
                .getName();
    }
}
