package co.pba.sample.factory.concrete;

import co.pba.sample.model.ContractCsvModel;
import co.pba.sample.factory.Factory;

public class ContractFactory implements Factory<ContractCsvModel> {

    private static final short CONTRACT_ID_IDX = 0;
    private static final short ORGANISATION_ID_IDX = 1;
    private static final short CUSTOMER_REF_IDX = 2;

    @Override
    public ContractCsvModel create(String[] data) {
        if (data.length > 3)
            throw new IllegalArgumentException("Not correct type of object");

        long contractId = Long.parseLong(data[CONTRACT_ID_IDX]);
        long organisationId = Long.parseLong(data[ORGANISATION_ID_IDX]);
        String customerRef = data[CUSTOMER_REF_IDX];
        return new ContractCsvModel(contractId, organisationId, customerRef);
    }
}
