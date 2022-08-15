package structural.adapter;

import lombok.extern.slf4j.Slf4j;
import structural.adapter.class_adapter.CardDesigner;
import structural.adapter.class_adapter.Employee;
import structural.adapter.class_adapter.EmployeeClassAdapter;

/**
 * Created on 15.08.2022
 * Study of structural design pattern Adapter.
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class Main {

    public static void main(String[] args) {

        EmployeeClassAdapter adapter = new EmployeeClassAdapter();
        populateEmployeeData(adapter); // Expects Employee Type (2-way adapter)

        CardDesigner designer = new CardDesigner();
        String card = designer.designCard(adapter); // Expects Customer type. (2-way adapter)

        log.info("Two-way class adapter: {}", card);
    }

    private static void populateEmployeeData(Employee employee){
        employee.setFullName("John Doe ");
        employee.setJobTitle("Spaceman ");
        employee.setOfficeLocation("Moon. Module 1.");
    }
}

