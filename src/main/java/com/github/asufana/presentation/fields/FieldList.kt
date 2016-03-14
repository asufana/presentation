package com.github.asufana.presentation.fields


data class Fields(val fields: List<Field>) {

    /** 詳細画面向けHTML文字列生成 */
    fun toDescTableHtml(): String {
        val layout = descTableDefaultColumnLayout()
        if (layout.isEmpty()) throw RuntimeException()

        val tableHtml = toDescTableHtml(layout)
        val html = """
<!-- columnsLayout -->
<!--
$layout
-->
$tableHtml
"""
        return html
    }

    /** 詳細画面向けHTML文字列生成 */
    fun toDescTableHtml(columnsLayout: String): String {
        //ボディ部
        val body = toDescBodyString(columnsLayout)
        //テーブルHTML
        val html = """
<table class="table table-bordered table-condensed">
$body
</table>
"""
        return html
    }

    /** 詳細画面ボディ */
    protected fun toDescBodyString(columnsLayout: String): String {
        //インデント空白
        val indent = "  "

        //インスタンス名からHTMLに変換するファンクション
        //@params instanceNames: ex) field1,field2,field3
        val instanceNameToHtmlFunction: (String) -> String = {
            instanceNames ->
            instanceNames.split(",")
                    .map { it.trim() }
                    //フィールドが見つからない場合にはNullオブジェクトを渡す
                    .map { instanceName -> findField(instanceName) ?: NullField(instanceName) }
                    .map { field -> field.toHeaderHtml() + field.toBodyHtml() }
                    .joinToString("\n$indent$indent")
        }

        //レイアウト文字列からHTMLに変換する
        //@params columnsLayout: ex) field1,field2\n field3,field4,field5
        val html = columnsLayout.split("\n")
                .map { it.trim() }
                .map { instanceNameToHtmlFunction(it) }
                .map { "$indent$indent$it" }
                .joinToString("\n$indent</tr>\n$indent<tr>\n")

        return "$indent<tr>\n$html\n$indent</tr>"
    }

    /** 詳細画面向けデフォルトレイアウト */
    fun descTableDefaultColumnLayout(): String {
        val layout = fields.map { it.instanceFullName }.joinToString("\n")
        return layout
    }

    /** インスタンス名からフィールドの取得 */
    protected fun findField(instanceName: String): Field? {
        val s1 = toClean(instanceName)
        val matchedFields = fields
                .filter {
                    //完全一致ではなく前方一致で判定する
                    //employee.name.value に対して、
                    //employee.name.value でも employee.name でもOKとする
                    it.instanceFullName != null &&
                            toClean(it.instanceFullName).startsWith(s1)
                }

        //前方一致で抽出した結果、フィールドが一意に特定されればそれを返却する
        return if (matchedFields.size == 1) matchedFields[0] else null
    }

    /** ユーザ入力インスタンス名の正規化 */
    protected fun toClean(instanceName: String): String {
        return instanceName.replace("\\s", "").toLowerCase();
    }

    fun size(): Int {
        return fields.size
    }

    override fun toString(): String {
        return fields.map { it.toString() }.joinToString("\n")
    }
}



