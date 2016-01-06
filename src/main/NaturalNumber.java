package main;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class A { }
interface M1 { }
interface M2 { }
interface M3 { }

class AM1 extends A implements M1 { }
class AM2 extends A implements M2 { }
class B extends A implements M1, M2 { }
class C extends A implements M1, M2, M3 { }

public class NaturalNumber<T extends A & M1 & M2> {
    private T n;

    public NaturalNumber(T n) {
        this.n = n;
    }
}

class SomeNumber<T extends A, B> {
    private A n;
    private B b;
}

interface PayloadList<E,P> extends List<E> {
    void setPayload(int index, P val);
}

class NewList implements PayloadList<Integer, String> {

    @Override
    public void setPayload(int index, String val) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public @NotNull Iterator<Integer> iterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NotNull
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Integer get(int index) {
        return null;
    }

    @Override
    public Integer set(int index, Integer element) {
        return null;
    }

    @Override
    public void add(int index, Integer element) {

    }

    @Override
    public Integer remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public @NotNull ListIterator<Integer> listIterator() {
        return null;
    }

    @NotNull
    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    @NotNull
    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        return null;
    }
}