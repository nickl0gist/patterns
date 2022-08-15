package structural.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 15.08.2022
 * Study of structural design pattern Adapter.
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Slf4j
public class Main {

    public static void main(String[] args) {

        /** Using Class/Two-way adapter **/
        EmployeeClassAdapter adapter = new EmployeeClassAdapter();
        populateEmployeeData(adapter); // Expects Employee Type (2-way adapter)

        CardDesigner designer = new CardDesigner();
        String card1 = designer.designCard(adapter); // Expects Customer type. (2-way adapter)

        log.info("Two-way class adapter: {}", card1);
        log.info("________________________________________________________");

        /** Using Object Adapter **/

        Employee employee = new Employee();
        populateEmployeeData(employee);

        EmployeeObjectAdapter objectAdapter = new EmployeeObjectAdapter(employee);
        String card2 = designer.designCard(objectAdapter);
        log.info("Object adapter: {}", card2);
    }

    private static void populateEmployeeData(Employee employee){
        employee.setFullName("John Doe ");
        employee.setJobTitle("Spaceman ");
        employee.setOfficeLocation("Moon. Module 1.");
    }
}

