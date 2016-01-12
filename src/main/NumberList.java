package main;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.stream.Stream;

public class NumberList<E extends Number> extends ArrayList<E> {
    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }
}

// how to write this
// class UntilNumberList<? extends Number> extends ArrayList<?>