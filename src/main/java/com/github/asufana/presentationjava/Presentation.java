package com.github.asufana.presentationjava;

public interface Presentation {

    default String toHtml() {
        return PresentationImpl.toHtml(this);
    }

    default String toHtml(String layout) {
        return PresentationImpl.toHtml(this, layout);
    }

}
