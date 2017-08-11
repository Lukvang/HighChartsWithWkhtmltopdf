package JS;

import java.util.List;

/*
 * LineBasic
 * 
 * This holds the attributes that make up a basic line chart
 * 
 */
public class LineBasic {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

	private String name;
	private List<Integer> data;

}
