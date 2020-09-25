package co.pba.sample.utils;

import co.pba.sample.factory.FactorySupplier;
import co.pba.sample.factory.FactoryTypes;

import java.io.BufferedReader;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvObjectsMapper<T> {

    private final Supplier<FactorySupplier> supplier = FactorySupplier::new;
    private static final int HEADER_LINE = 1;

    @SuppressWarnings("unchecked")
    private Supplier<Stream<T>> map(FactoryTypes types, BufferedReader reader) {
        return () -> reader.lines().skip(HEADER_LINE).map(line -> (T) supplier
                .get().ofType(types).create(line.split(",")))
                .filter(Objects::nonNull);
    }

    public List<T> mapToList(FactoryTypes types, BufferedReader reader) {
        return map(types, reader).get().collect(Collectors.toUnmodifiableList());
    }

    public Set<T> mapToSet(FactoryTypes types, BufferedReader reader) {
        return map(types, reader).get().collect(Collectors.toUnmodifiableSet());
    }
}
