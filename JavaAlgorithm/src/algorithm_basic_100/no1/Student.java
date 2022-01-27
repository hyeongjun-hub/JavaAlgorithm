package algorithm_basic_100.no1;

public class Student {
	private String name;
	private String no;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Student(String name, String no) {
		super();
		this.name = name;
		this.no = no;
	}
}
