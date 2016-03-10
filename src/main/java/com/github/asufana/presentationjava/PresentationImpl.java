package com.github.asufana.presentationjava;

import com.github.asufana.presentationjava.fields.Fields;
import com.github.asufana.presentationjava.fields.FieldsFactory;

public class PresentationImpl {

    /** HTML変換（デフォルトレイアウト） */
    public static String toHtml(final Object targetInstance) {

        //フィールド一覧取得
        final Fields fields = FieldsFactory.create(targetInstance);

        //詳細画面向けHTML文字列生成
        final String html = fields.toDescTableHtml();

        return html;
    }

    /** HTML変換 */
    public static String toHtml(final Object targetInstance, String layout) {

        //フィールド一覧取得
        final Fields fields = FieldsFactory.create(targetInstance);

        //詳細画面向けHTML文字列生成
        final String html = fields.toDescTableHtml(layout);

        return html;
    }

}
