package structural.adapter;

/**
 * Created on 15.08.2022
 * An object adapter using composition to translate interface.
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class EmployeeObjectAdapter implements Customer{

    private Employee employee;

    //Composition. Most appropriate way to inject Employee (adaptee) object.
    public EmployeeObjectAdapter(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getName() {
        return employee.getFullName();
    }

    @Override
    public String getDesignation() {
        return employee.getJobTitle();
    }

    @Override
    public String getAddress() {
        return employee.getOfficeLocation();
    }
}
