package com.github.asufana.presentationjava.utils;

public class StringBuilder {
    
    public static final String CRLF = System.getProperty("line.separator");
    
    protected String value = "";
    
    public StringBuilder() {}
    
    public StringBuilder add(final String value) {
        this.value += value;
        return this;
    }
    
    public StringBuilder addLine(final String value) {
        this.value += value + CRLF;
        return this;
    }
    
    public StringBuilder crlf() {
        value += CRLF;
        return this;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
}
