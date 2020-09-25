package co.pba.sample;

import co.pba.sample.factory.FactoryTypes;
import co.pba.sample.model.ContractCsvModel;
import co.pba.sample.utils.CsvObjectsMapper;
import co.pba.sample.utils.FileLoader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileViewer {

    public static void main(String[] args) {
        CsvObjectsMapper<ContractCsvModel> mapper = new CsvObjectsMapper<>();

        // file location: src/main/resources/contracts.csv
        displayText();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String location = scanner.nextLine();
            if (location.equals("exit")) System.exit(0);

            BufferedReader reader;
            try {
                reader = FileLoader.load(location);
            } catch (FileNotFoundException e) {
                System.out.println("File not found please try another location!");
                displayText();
                continue;
            }

            mapper.mapToSet(FactoryTypes.Contract, reader)
                    .forEach(contractCsvModel -> System.out.println(
                            contractCsvModel.getContractId() + " "
                                    + contractCsvModel.getOrganisationId() + " "
                                    + contractCsvModel.getCustomerRef()));

            System.out.println();
            displayText();
        }
    }

    private static void displayText() {
        System.out.println("Type exit to finish");
        System.out.print("File location: ");
    }
}
