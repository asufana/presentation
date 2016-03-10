package com.github.asufana.presentationjava.fields;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;

public abstract class AbstractCollection<T extends AbstractCollection, S> implements Iterable<S> {
    
    protected final Class<?>[] constructorParams = {List.class};
    protected final List<S> list;
    
    /** コンストラクタ */
    public AbstractCollection(final List<S> list) {
        if (list == null || list.size() == 0) {
            this.list = Collections.emptyList();
        }
        else {
            this.list = Collections.unmodifiableList(list);
        }
    }
    
    //http://d.hatena.ne.jp/Nagise/20131121/1385046248
    protected T toCollection(final List<S> list) {
        try {
            final Class<?> clazz = this.getClass();
            final Type type = clazz.getGenericSuperclass();
            final ParameterizedType pt = (ParameterizedType) type;
            final Type[] actualTypeArguments = pt.getActualTypeArguments();
            final Class<?> entityClass;
            if (actualTypeArguments[0] instanceof ParameterizedType) {
                entityClass = (Class<?>) ((ParameterizedType) actualTypeArguments[0]).getRawType();
            }
            else {
                entityClass = (Class<?>) actualTypeArguments[0];
            }
            final Constructor<?> constructor = entityClass.getConstructor(this.constructorParams);
            return (T) constructor.newInstance(list);
        }
        catch (final ReflectiveOperationException e) {
            throw new RuntimeException("AbstractCollection.toCollectionエラー:" + e.getMessage());
        }
    }
    
    /** リスト返却 */
    public List<S> list() {
        return Collections.unmodifiableList(sort().list);
    }
    
    /** ソート（必要に応じてoverride） */
    public T sort() {
        return toCollection(this.list);
    }
    
    /** ソートを逆順に */
    public T reverse() {
        final List<S> newList = new ArrayList<S>(this.list);
        Collections.reverse(newList);
        return toCollection(newList);
    }
    
    /** 指定インデックスを取得 */
    public Optional<S> get(final Integer index) {
        return list().size() > index
                ? Optional.of(list().get(index))
                : Optional.empty();
    }
    
    /** 空であるか */
    public boolean isEmpty() {
        return this.list == null || this.list.size() == 0;
    }
    
    /** サイズ */
    public Integer size() {
        return this.list.size();
    }
    
    /** 包含有無 */
    public boolean contains(final S obj) {
        return this.list.contains(obj);
    }
    
    /** 重複削除 */
    public T unique() {
        final Set<S> set = new HashSet<S>(this.list);
        return toCollection(new ArrayList<S>(set));
    }
    
    /** コレクションの追加 */
    public T add(final AbstractCollection collection) {
        final List<S> newList = new ArrayList<S>(this.list);
        newList.addAll(collection.list);
        return toCollection(newList);
    }
    
    /** コレクションの削除 */
    public T remove(final AbstractCollection collection) {
        final List<S> newList = new ArrayList<S>(this.list);
        for (final S obj : this.list) {
            if (collection.list.contains(obj)) {
                newList.remove(obj);
            }
        }
        return toCollection(newList);
    }
    
    @Override
    public String toString() {
        return stream().map(obj -> obj.toString()).collect(Collectors.joining(","));
    }
    
    /** Stream */
    protected Stream<S> stream() {
        return list().stream();
    }
    
    /** Iterator */
    @Override
    public Iterator<S> iterator() {
        return list().iterator();
    }
}
