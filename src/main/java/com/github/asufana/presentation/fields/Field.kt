package com.github.asufana.presentation.fields

import com.github.asufana.presentation.annotattions.View
import com.github.asufana.presentation.annotattions.ViewAnnotation


/** java.lang.reflect.Field保持クラス */
data class Field(

        /** フィールド階層一覧 */
        //ex) employee.name.value
        val parentFields: List<java.lang.reflect.Field>,

        /** フィールド */
        //ex) value
        val field: java.lang.reflect.Field,

        /** フィールド保持インスタンス */
        //ex) name
        val instance: Any?) {

    /** 自インスタンス名 */
    //ex) value
    val instanceName: String = field.name

    /** フルインスタンス名 */
    //ex) employee.name.value
    val instanceFullName: String = createFullInstanceName(parentFields, instanceName)

    /** フィールド表示名 */
    //ex) employee.name.value もしくは @Value指示名
    val displayName: String = findAnnotation()?.name ?: instanceFullName

    /** フィールド値 */
    //ex) taro
    val value: String? = getValue(field, instance)

    /** フルインスタンス名文字列生成 */
    protected fun createFullInstanceName(parentFields: List<java.lang
    .reflect.Field>, instanceName: String): String {
        if (parentFields.isEmpty()) return instanceName

        //デリミタ
        val DELIMITER = "."
        //親インスタンス名
        val parentInstanceNamesString = parentFields.map { it.name }
                .joinToString { DELIMITER }

        return if (instanceName != null)
            parentInstanceNamesString + DELIMITER + instanceName
        else
            parentInstanceNamesString
    }

    /** アノテーション取得 */
    protected fun findAnnotation(): ViewAnnotation? {
        if (findFieldAnnotation() != null) return findAnnotation()
        if (findInstanceAnnotation() != null) return findInstanceAnnotation()
        return findParentFieldAnnotation()
    }

    /** フィールド・アノテーション取得 */
    protected fun findFieldAnnotation(): ViewAnnotation? {
        return field.getAnnotation(View::class.java)
                ?.let { ViewAnnotation(it) }
    }

    /** フィールド保持インスタンス・アノテーション取得 */
    protected fun findInstanceAnnotation(): ViewAnnotation? {
        return instance?.javaClass
                ?.getDeclaredAnnotation(View::class.java)
                ?.let { ViewAnnotation(it) }
    }

    /** 親フィールド・アノテーション取得 */
    protected fun findParentFieldAnnotation(): ViewAnnotation? {
        if (parentFields.isEmpty()) return null;
        val parentField = parentFields.get(parentFields.size - 1)
        return parentField?.type.getAnnotation(View::class.java)
                ?.let { ViewAnnotation(it) }
    }

    /** インスタンス値の取得 */
    protected fun getValue(field: java.lang.reflect.Field, instance: Any?):
            String? {
        return getValueFromInstance(instance) ?: getValueFromField(field, instance)
    }

    /** インスタンス値をフィールドから取得 */
    protected fun getValueFromField(field: java.lang.reflect.Field, instance:
    Any?): String? {
        if (field == null || instance == null) return null

        try {
            val obj = field.get(instance)
            return obj?.toString()
        } catch(e: Exception) {
            return null
        }
    }

    /** インスタンス値をフィールド保持インスタンスから取得 */
    protected fun getValueFromInstance(instance: Any?): String? {
        if (instance == null) return null

        //取得メソッド
        val methodName = findAnnotation()?.valueMethod ?: "toString"

        try {
            val method = instance.javaClass.getMethod(methodName)
            return method.invoke(instance) as String
        } catch(e: NoSuchMethodException) {
            return "NO SUCH METHOD: $methodName"
        } catch(e: Exception) {
            return instance.toString()
        }
    }

}
