package com.github.asufana.presentation

import com.github.asufana.presentation.fields.FieldsFactory

class PresentationImpl {

    companion object {

        /** HTML変換（デフォルトレイアウト） */
        @JvmStatic
        fun toHtml(targetInstance: Any): String {

            //フィールド一覧
            val fields = FieldsFactory.create(targetInstance)

            //HTML生成
            return fields.toDescTableHtml()
        }

        /** HTML変換 */
        @JvmStatic
        fun toHtml(targetInstance: Any, layout: String): String {

            //フィールド一覧
            val fields = FieldsFactory.create(targetInstance)

            //HTML生成
            return fields.toDescTableHtml(layout)
        }

    }

}


