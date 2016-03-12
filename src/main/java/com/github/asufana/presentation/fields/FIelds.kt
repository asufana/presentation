package com.github.asufana.presentation.fields

data class Fields(val fields: List<Field>) {

    fun size(): Int {
        return fields.size
    }
}


