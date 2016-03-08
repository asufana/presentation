package com.github.asufana.presentation.fields

import java.lang.reflect.Modifier


class FieldsFactory {

    companion object {

        fun create(targetInstance: Any): String {
            return dicoverty(targetInstance.javaClass, targetInstance)
        }

        fun dicoverty(targetInstanceClass: Class<*>,
                      targetInstance: Any?): String {
            val fields = targetInstanceClass.declaredFields
            fields
                    .filter {
                        //スタティックフィールド除外
                        Modifier.isStatic(it.modifiers) == false
                    }
                    .forEach { field ->
                        field.isAccessible = true

                        //子要素があれば
                        if (hasChild(field)) {
                            val nextKlass = field.type
                            val nextInstance = value(targetInstance, field)

                            println("++. $field.")
                            dicoverty(nextKlass, nextInstance)
                        }
                        //子要素がなければ
                        else {
                            println("--. $field.")
                        }
                    }
            return "hoge"
        }

        /** インスタンス値の取得 */
        protected fun value(instance: Any?, field: java.lang.reflect.Field): Any? {
            if(instance == null){
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
            field.isAccessible
            //@Embeddableが付加されていれば子要素ありと見なす
            val annotation = field.type.getDeclaredAnnotation(javax
            .persistence.Embeddable::class.java)
            return annotation != null
        }

    }

}
