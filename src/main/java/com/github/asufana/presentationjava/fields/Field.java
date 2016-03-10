package com.github.asufana.presentationjava.fields;

import com.github.asufana.presentationjava.annotations.View;
import com.github.asufana.presentationjava.annotations.ViewAnnotation;

import static java.util.Optional.*;
import static java.util.stream.Collectors.*;

import java.lang.reflect.*;
import java.util.*;

/**
 * フィールド保持クラス
 */
public class Field {

    /**
     * フィールド階層一覧
     */
    //ex.employee.name.value
    protected final List<java.lang.reflect.Field> parentFields;

    /**
     * フィールド
     */
    //ex.value
    protected final java.lang.reflect.Field field; /* nullable */

    /**
     * フィールド保持インスタンス
     */
    //ex.name
    protected final Object instance; /* nullable */

    /**
     * 自インスタンス名
     */
    //ex. value
    protected final String instanceName;

    /**
     * フルインスタンス名
     */
    //ex.employee.name.value
    protected final String instanceFullName;

    /**
     * フィールド表示名
     */
    //ex.employee.name.value もしくは @Value指示名
    protected final String displayName;

    /**
     * フィールド値
     */
    //ex. taro
    protected final Object value;

    //コンストラクタ
    public Field(final List<java.lang.reflect.Field> parentFields,
                 final java.lang.reflect.Field field,
                 final Object instance) {
        this.parentFields = parentFields;
        this.field = field;
        this.instance = instance;

        instanceName = ofNullable(field).map(f -> f.getName()).orElse(null);
        instanceFullName = createFullInstanceNames(parentFields, instanceName);
        displayName = findAnnotation().map(ViewAnnotation::name).orElse(instanceFullName);
        value = getValue(field, instance);
    }

    protected List<java.lang.reflect.Field> parentFields(){
        return parentFields;
    }

    protected Optional<java.lang.reflect.Field> field(){
        return ofNullable(field);
    }

    protected Optional<Object> instance(){
        return ofNullable(instance);
    }

    public String instanceName() {
        return instanceName;
    }

    public String instanceFullName() {
        return instanceFullName;
    }

    public String displayName() {
        return displayName;
    }

    public Object value() {
        return value;
    }

    protected String valueString() {
        return ofNullable(value).map(Object::toString).orElse("");
    }

    /**
     * アノテーション取得
     */
    protected Optional<ViewAnnotation> findAnnotation() {
        if (findFieldAnnotation().isPresent()) {
            return findFieldAnnotation();
        }
        return findInstanceAnnotation();
    }

    /**
     * フィールド・アノテーション取得
     */
    protected Optional<ViewAnnotation> findFieldAnnotation() {
        return field().map(field -> field.getAnnotation(View.class))
                .map(annotation -> new ViewAnnotation(annotation));
    }

    /**
     * フィールド保持インスタンス・アノテーション取得
     */
    protected Optional<ViewAnnotation> findInstanceAnnotation() {
        return instance().map(instance -> instance.getClass()
                .getDeclaredAnnotation(View.class))
                .map(annotation -> new ViewAnnotation(annotation));
    }

    /**
     * インスタンス値の取得
     */
    protected String getValue(final java.lang.reflect.Field field, final Object instance) {
        return ofNullable(getValueFromInstance(instance)).orElse(getValueFromField(field, instance));
    }

    /**
     * インスタンス値をフィールドから取得する
     */
    protected String getValueFromField(final java.lang.reflect.Field field, final Object instance) {
        if (field == null || instance == null) {
            return null;
        }
        try {
            final Object object = field.get(instance);
            return object != null
                    ? object.toString()
                    : null;
        } catch (final Exception e) {
            return null;
        }
    }

    /**
     * インスタンス値をフィールド保持インスタンスから取得する
     */
    protected String getValueFromInstance(final Object instance) {
        if (instance == null) {
            return null;
        }

        //取得メソッド
        final String methodName = findAnnotation().flatMap(a -> a.valueMethod()).orElse("toString");

        try {
            final Method method = instance.getClass().getMethod(methodName);
            final String value = (String) method.invoke(instance);
            return value;
        } catch (final NoSuchMethodException e) {
            return "NO SUCH METHOD:" + methodName;
        } catch (final Exception e) {
            return instance.toString();
        }
    }

    /**
     * フルインスタンス名文字列生成
     */
    protected String createFullInstanceNames(final List<java.lang.reflect.Field> parentFields,
                                             final String instanceName) {
        if (parentFields == null || parentFields.isEmpty()) {
            return instanceName;
        }

        //デリミタ
        final String DELIMITER = ".";
        //親インスタンス名
        final String stringParentInstanceNames = parentFields.stream()
                .map(f -> f.getName())
                .collect(joining(DELIMITER));
        return stringParentInstanceNames + DELIMITER + instanceName;
    }

    /**
     * ヘッダHTML文字列
     */
    public String toHeaderHtml() {
        return String.format("%s%s</th>", toThTagHtml(), displayName());
    }

    /**
     * THタグ文字列
     */
    protected String toThTagHtml() {
        return findAnnotation().map(a -> a.thTagString()).orElse("<th>");
    }

    /**
     * ボディHTML文字列
     */
    public String toBodyHtml() {
        return String.format("%s%s</td>", toTdTagHtml(), valueString());
    }

    /**
     * TDタグ文字列
     */
    protected String toTdTagHtml() {
        return findAnnotation().map(a -> a.tdTagString()).orElse("<td>");
    }

    @Override
    public String toString() {
        return String.format("%s=%s", instanceFullName(), value());
    }

//    /** 元インスタンスから、自身フィールドのインスタンス値を取得 */
//    public Object getValue(final Object parentInstance) {
//        //自身を含めたすべてのフィールド階層
//        final List<java.lang.reflect.Field> wholeFields = wholeFields();
//        final Object[] instance = {parentInstance};
//
//        //フィールド階層を下りながらインスタンス値を取得していく
//        wholeFields.forEach(field -> {
//            final Object innerInstance = getValue(field, instance[0]);
//            if (innerInstance != null) {
//                instance[0] = innerInstance;
//            }
//            return;
//        });
//        return instance[0];
//    }
//
//    /** 自身も含めたフィールド階層一覧 */
//    protected List<java.lang.reflect.Field> wholeFields() {
//        final List<java.lang.reflect.Field> fields = new LinkedList<>(parentFields());
//        fields.add(field);
//        return fields;
//    }

}
