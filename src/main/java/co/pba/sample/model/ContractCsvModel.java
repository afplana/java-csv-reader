package co.pba.sample.model;


public class ContractCsvModel {
    private long contractId;
    private long organisationId;
    private String customerRef;

    private ContractCsvModel() {
    }

    public ContractCsvModel(long contractId, long organisationId, String customerRef) {
        this.contractId = contractId;
        this.organisationId = organisationId;
        this.customerRef = customerRef;
    }

    public long getContractId() {
        return this.contractId;
    }

    public long getOrganisationId() {
        return this.organisationId;
    }

    public String getCustomerRef() {
        return this.customerRef;
    }
}
