package com.github.asufana.presentation;

public interface Presentation {
    
    default String toHtml() {
        return PresentationImpl.toHtml(this);
    }
    
}
