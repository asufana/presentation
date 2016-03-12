package com.github.asufana.presentationjava.fields;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;

import javax.persistence.*;

/**
 * フィールド一覧作成ファクトリ
 */
public class FieldsFactory {
    
    public static Fields create(final Object targetInstance) {
        final List<Field> discoveredFields = new LinkedList<>();
        discovery(Collections.emptyList(),
                  targetInstance.getClass(),
                  targetInstance,
                  discoveredFields);
        return new Fields(discoveredFields);
    }
    
    /**
     * フィールド取得
     */
    protected static void discovery(final List<java.lang.reflect.Field> parentFields,
                                    final Class targetInstanceClass,
                                    final Object targetInstance,
                                    final List<Field> discoveredFields) {
        final java.lang.reflect.Field[] fields = targetInstanceClass.getDeclaredFields();
        Stream.of(fields)
              .filter(field -> !Modifier.isStatic(field.getModifiers()))
              //staticフィールド除外
              .forEach(field -> {
                  field.setAccessible(true);
                  
                  //子要素あれば再帰
                  if (hasChild(field)) {
                      final Class<?> nextClass = field.getType();
                      final Object nextInstance = value(targetInstance, field);
                      final List<java.lang.reflect.Field> nextParentFields = createParentFields(parentFields,
                                                                                                field);
                      discovery(nextParentFields,
                                nextClass,
                                nextInstance,
                                discoveredFields);
                  }
                  //子要素なければクラス保持
                  else {
                      final Field f = new Field(parentFields,
                                                field,
                                                targetInstance);
                      discoveredFields.add(f);
                  }
              });
    }
    
    /**
     * 親フィールド履歴の生成
     */
    protected static List<java.lang.reflect.Field> createParentFields(final List<java.lang.reflect.Field> currentParentFields,
                                                                      final java.lang.reflect.Field parentField) {
        final LinkedList<java.lang.reflect.Field> nextParentFields = new LinkedList<>(currentParentFields);
        
        nextParentFields.add(parentField);
        return nextParentFields;
    }
    
    /**
     * インスタンス値の取得
     */
    protected static Object value(final Object instance,
                                  final java.lang.reflect.Field field) {
        try {
            return field.get(instance);
        }
        catch (final Exception e) {
            return null;
        }
    }
    
    /**
     * 子要素を持つかどうか
     */
    protected static boolean hasChild(final java.lang.reflect.Field field) {
        field.setAccessible(true);
        //@Embedded付加されていれば子要素あり
        final Embeddable annotation = field.getType()
                                           .getDeclaredAnnotation(javax.persistence.Embeddable.class);
        return annotation != null;
    }
    
}
