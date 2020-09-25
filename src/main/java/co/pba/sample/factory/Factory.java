package co.pba.sample.factory;

public interface Factory<T> {
    T create(String[] data);
}
