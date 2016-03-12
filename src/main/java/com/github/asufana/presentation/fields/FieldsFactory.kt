package com.github.asufana.presentation.fields

import java.lang.reflect.Modifier

class FieldsFactory {

    companion object {

        fun create(targetInstance: Any): Fields {
            val discoveredFields = mutableListOf<Field>()
            discovery(listOf(), targetInstance.javaClass, targetInstance, discoveredFields)
            return Fields(discoveredFields)
        }

        fun discovery(parentFields: List<java.lang.reflect.Field>,
                      targetInstanceClass: Class<*>,
                      targetInstance: Any?,
                      discoveredFields: MutableList<Field>): Unit {
            val fields = targetInstanceClass.declaredFields

            fields
                    .filter {
                        //スタティックフィールド除外
                        Modifier.isStatic(it.modifiers) == false
                    }
                    .forEach { field ->
                        field.isAccessible = true

                        //子要素があれば再帰
                        if (hasChild(field)) {
                            val nextParentFields = parentFields.plus(field)
                            val nextClass = field.type
                            val nextInstance = getValue(targetInstance, field)

                            //println("++. $field.")
                            discovery(nextParentFields, nextClass, nextInstance, discoveredFields)
                        }
                        //子要素がなければ
                        else {
                            //println("--. $field.")
                            val f = Field(parentFields, field, targetInstance)
                            discoveredFields.add(f)
                        }
                    }
        }

        /** インスタンス値の取得 */
        protected fun getValue(instance: Any?, field: java.lang.reflect.Field):
                Any? {
            if (instance == null) {
                return null
            }
            try {
                return field.get(instance)
            } catch(e: Exception) {
                return null
            }
        }

        /** 子要素を持つかどうか */
        protected fun hasChild(field: java.lang.reflect.Field): Boolean {
            //@Embeddableが付加されていれば子要素ありと見なす
            val annotation = field.type.getDeclaredAnnotation(javax
            .persistence.Embeddable::class.java)
            return annotation != null
        }

    }

}
