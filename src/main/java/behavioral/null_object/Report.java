package behavioral.null_object;

import lombok.Getter;

/**
 * Created on 12.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public class Report {

	@Getter
	private final String name;
	
	public Report(String name) {
		this.name = name;
	}
}
