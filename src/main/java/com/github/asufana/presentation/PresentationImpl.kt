package com.github.asufana.presentation

class PresentationImpl {

    companion object {
        @JvmStatic
        fun toHtml(obj: Any): String {
            val fields = obj.javaClass.declaredFields
            val fieldsStr = fields
                    .map { field -> field.name }
                    .joinToString(",")
            return fieldsStr
        }
    }

}


