package co.pba.sample.factory;

import co.pba.sample.factory.concrete.ContractFactory;

public class FactorySupplier {

    public Factory<?> ofType(FactoryTypes types) {
        switch (types) {
            case Contract:
                return new ContractFactory();
            case Customer:
                throw new IllegalStateException("Not implemented yet!");
            case Organisation:
                throw new IllegalStateException("Not implemented yet");
            default:
                throw new IllegalArgumentException("Not valid object type");
        }
    }
}
