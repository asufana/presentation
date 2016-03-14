package com.github.asufana.presentation.annotations

data class ViewAnnotation(private val annotation: View) {

    val name = annotation.name
    val valueMethod: String?
            = if (annotation.valueMethod.isNotEmpty()) annotation.valueMethod else null
    protected val thClass: String?
            = if (annotation.thClass.isNotEmpty()) annotation.thClass else null
    protected val thWidth = annotation.thWidth
    protected val thRight = annotation.thRight
    protected val tdClass: String?
            = if (annotation.tdClass.isNotEmpty()) annotation.tdClass else null
    protected val tdWidth = annotation.tdWidth
    protected val tdRight = annotation.tdRight


    fun thTagString(): String {
        return "<th${thClassAttr()}${thWidthAttr()}${thStyleAttr()}>"
    }

    protected fun thClassAttr(): String {
        return thClass?.let { " class=\"$thClass\"" } ?: ""
    }

    protected fun thWidthAttr(): String {
        return if (thWidth != 0) " width=\"$thWidth%\"" else ""
    }

    protected fun thStyleAttr(): String {
        return if (thRight) " style=\"text-align:right\"" else ""
    }

    fun tdTagString(): String {
        return "<td${tdClassAttr()}${tdWidthAttr()}${tdStyleAttr()}>"
    }

    protected fun tdClassAttr(): String {
        return tdClass?.let { " class=\"$tdClass\"" } ?: ""
    }

    protected fun tdWidthAttr(): String {
        return if (tdWidth != 0) " width=\"$tdWidth%\"" else ""
    }

    protected fun tdStyleAttr(): String {
        return if (tdRight) " style=\"text-align:right\"" else ""
    }

}

