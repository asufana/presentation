package com.github.asufana.presentation.annotattions

data class ViewAnnotation(private val annotation: View) {

    val name = annotation.name
    val thClass: String?
            = if (annotation.thClass.isNotEmpty()) annotation.thClass else null
    val thWidth = annotation.thWidth
    val thRight = annotation.thRight
    val tdClass: String?
            = if (annotation.tdClass.isNotEmpty()) annotation.tdClass else null
    val tdWidth = annotation.tdWidth
    val tdRight = annotation.tdRight
    val valueMethod: String?
            = if (annotation.valueMethod.isNotEmpty()) annotation.valueMethod else null

}

