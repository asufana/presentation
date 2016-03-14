package com.github.asufana.presentation.fields

/** フィールド保持クラス（インスタンス名のみ／NullObject的な利用） */
class NullField(

        /** フルインスタンス名 */
        instanceFullName: String) : Field(listOf(), null, null) {

    init {
        instanceFullName.toLowerCase()
    }

    /** ヘッダHTML文字列 */
    override fun toHeaderHtml(): String {
        return "<th>$instanceFullName</th>"
    }

    /** ボディHTML文字列 */
    override fun toBodyHtml(): String {
        return "<td>UNKNOWN INSTANCE NAME</td>"
    }

}
