package structural.adapter.class_adapter;

/**
 * Created on 15.08.2022
 * Two-way adapter.
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class EmployeeClassAdapter extends Employee implements Customer {
    @Override
    public String getName() {
        return getFullName();
    }

    @Override
    public String getDesignation() {
        return getJobTitle();
    }

    @Override
    public String getAddress() {
        return getOfficeLocation();
    }
}
