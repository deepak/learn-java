package main;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class RandomList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable, Comparable<E>, CharSequence {
    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int compareTo(E o) {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
