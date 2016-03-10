package com.github.asufana.presentationjava.fields;

import static java.util.Optional.*;
import static java.util.stream.Collectors.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import com.github.asufana.presentationjava.utils.StringBuilder;
import org.apache.commons.lang3.StringUtils;

/** フィールドリスト */
public class Fields extends AbstractCollection<Fields, Field> {
    
    public Fields(final List<Field> list) {
        super(list);
    }
    
    /** 詳細画面向けHTML文字列生成 */
    public String toDescTableHtml() {
        final String layout = descTableDefaultColumnsLayout();
        if (StringUtils.isEmpty(layout)) {
            throw new RuntimeException();
        }
        final String html = String.format("<!-- columnsLayout:\n%s\n-->\n%s\n",
                                          layout,
                                          toDescTableHtml(layout));
        return html;
    }
    
    /** 詳細画面向けデフォルトカラムレイアウト */
    public String descTableDefaultColumnsLayout() {
        final String layout = list.stream()
                                  .map(field -> field.instanceFullName())
                                  .collect(joining("\n"));
        return layout;
    }
    
    /** 詳細画面向けHTML文字列生成 */
    public String toDescTableHtml(final String columnsLayout) {
        //ボディ部
        final String body = toDescBodyString(columnsLayout);
        //テーブルHTML
        final StringBuilder sb = new StringBuilder();
        sb.addLine("<table class=\"table table-bordered table-condensed\">")
          .addLine("<tbody>")
          .add(body)
          .addLine("</tbody>")
          .addLine("</table>");
        return sb.toString();
    }
    
    /** 詳細画面ボディ */
    protected String toDescBodyString(final String columnsLayout) {
        
        //インスタンス名からHTMLに変換する
        //@param instanceNames: ex. field1,field2,field3
        final Function<String, String> instanceNameToHtmlFunction = instanceNames -> {
            final String innerHtml = Stream.of(instanceNames.split(","))
                                           .map(instanceName -> findField(instanceName).orElse(LesserField.create(instanceName)))
                                           .map(field -> field.toHeaderHtml() + field.toBodyHtml())
                                           .collect(joining("\n"));
            return innerHtml;
        };
        
        //レイアウト文字列からHTMLに変換する
        //@param columnsLayout: ex. field1,field2\n field3,field4,field5
        final String html = Stream.of(columnsLayout.split("\n"))
                                  .map(instanceNameToHtmlFunction)
                                  .collect(joining("\n</tr>\n<tr>\n"));
        return String.format("<tr>\n%s\n</tr>\n", html);
    }
    
    /** 一覧画面向けHTML文字列生成 */
    public String toListTableHtml() {
        //ヘッダ部
        final String header = toListHeaderString();
        //ボディ部
        final String body = toListBodyString();
        
        final StringBuilder sb = new StringBuilder();
        sb.addLine("<table class=\"table table-striped table-bordered table-condensed\">")
          .addLine("<thead>")
          .add(header)
          .addLine("</thead>")
          .addLine("<tbody>")
          .add(body)
          .addLine("</thead>")
          .addLine("</tbody>")
          .addLine("</table>");
        return sb.toString();
    }
    
    /** 一覧表示ヘッダ */
    protected String toListHeaderString() {
        final String str = list.stream().map(Field::toHeaderHtml).collect(joining());
        return str;
    }
    
    /** 一覧表示ボディ */
    protected String toListBodyString() {
        final String str = list.stream().map(Field::toBodyHtml).collect(joining());
        return str;
    }
    
    /** インスタンス名からフィールドの取得 */
    public Optional<Field> findField(final String instanceNames) {
        final String s1 = toClean(instanceNames);
        final List<Field> matchedFields = list.stream().filter(field -> {
            final String s2 = toClean(field.instanceFullName());
            //前方一致で抽出
            return s2.startsWith(s1);
        }).collect(toList());
        
        //前方一致で抽出した結果、フィールドが一意に特定されればそれを返却する
        //employee.name.value に対して、
        //employee.name.value でも employee.name でもOKとする
        return matchedFields.size() == 1
                ? of(matchedFields.get(0))
                : Optional.empty();
    }
    
    /** ユーザ入力インスタンス名の正規化 */
    protected String toClean(final String instanceNames) {
        return instanceNames.replaceAll("\\s", "").toLowerCase();
    }
    
    @Override
    public String toString() {
        return list.stream().map(Field::toString).collect(joining("\n"));
    }
}
