package com.github.asufana.presentation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface View {
    
    //カラム表示名
    String name();
    
    //THタグClassアトリビュート値
    String thClass() default "";
    
    //THタグ幅割合(%)
    int thWidth() default 0;
    
    //THタグ右寄せ
    boolean thRight() default true;
    
    //TDタグClassアトリビュート値
    String tdClass() default "";
    
    //TDタグ幅割合(%)
    int tdWidth() default 0;
    
    //TDタグ右寄せ
    boolean tdRight() default false;
    
    //TD値取得メソッド
    String valueMethod() default "";
}
