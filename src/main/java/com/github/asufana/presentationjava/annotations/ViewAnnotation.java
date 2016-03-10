package com.github.asufana.presentationjava.annotations;

import static java.util.Optional.*;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.*;

public class ViewAnnotation {
    
    private final String name;
    private final String thClass;
    private final Integer thWidth;
    private final boolean thRight;
    private final String tdClass;
    private final Integer tdWidth;
    private final boolean tdRight;
    private final String valueMethod;
    
    public ViewAnnotation(final View annotation) {
        name = annotation.name();
        thClass = annotation.thClass();
        thWidth = annotation.thWidth();
        thRight = annotation.thRight();
        tdClass = annotation.tdClass();
        tdWidth = annotation.tdWidth();
        tdRight = annotation.tdRight();
        valueMethod = annotation.valueMethod();
    }
    
    public String name() {
        return name;
    }
    
    public Optional<String> valueMethod() {
        return isNotEmpty(valueMethod)
                ? of(valueMethod)
                : Optional.empty();
    }
    
    public String thTagString() {
        return String.format("<th%s%s%s>", thClassAttr(), thWidthAttr(), thStyleAttr());
    }
    
    protected String thClassAttr() {
        return isNotEmpty(thClass)
                ? String.format(" class=\"%s\"", thClass)
                : "";
    }
    
    protected String thWidthAttr() {
        return thWidth != 0
                ? String.format(" width=\"%s%s\"", thWidth, "%")
                : "";
    }
    
    protected String thStyleAttr() {
        return thRight
                ? " style=\"text-align:right\""
                : "";
    }
    
    public String tdTagString() {
        return String.format("<td%s%s%s>", tdClassAttr(), tdWidthAttr(), tdStyleAttr());
    }
    
    protected String tdClassAttr() {
        return isNotEmpty(tdClass)
                ? String.format(" class=\"%s\"", tdClass)
                : "";
    }
    
    protected String tdWidthAttr() {
        return tdWidth != 0
                ? String.format(" width=\"%s%s\"", tdWidth, "%")
                : "";
    }
    
    protected String tdStyleAttr() {
        return tdRight
                ? " style=\"text-align:right\""
                : "";
    }
    
}
