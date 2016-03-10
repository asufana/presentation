package com.github.asufana.presentationjava.fields;

import java.util.*;

/** フィールド保持クラス（インスタンス名のみ／NullObject的な利用） */
public class LesserField extends Field {
    
    /** フルインスタンス名 */
    protected final String instanceFullName;
    
    public static Field create(final String instanceFullName) {
        return new LesserField(instanceFullName, Collections.emptyList(), null, null);
    }
    
    LesserField(final String instanceFullName,
            final List<java.lang.reflect.Field> parentFields,
            final java.lang.reflect.Field field,
            final Object instance) {
        super(parentFields, field, instance);
        
        this.instanceFullName = instanceFullName.replaceAll("\\s", "");
    }

    public String instanceFullName(){
        return instanceFullName;
    }
    
    /** ヘッダHTML文字列 */
    @Override
    public String toHeaderHtml() {
        return String.format("<th>%s</th>", instanceFullName);
    }
    
    /** ボディHTML文字列 */
    @Override
    public String toBodyHtml() {
        return "<td>UNKNOWN INSTANCE NAME</td>";
    }
}
