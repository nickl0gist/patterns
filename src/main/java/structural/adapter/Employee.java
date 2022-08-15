package structural.adapter;

import lombok.Getter;
import lombok.Setter;

/**
 * Created on 15.08.2022
 * An existing class used in the system
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
@Setter
@Getter
public class Employee {
    private String fullName;

    private String jobTitle;

    private String officeLocation;
}
