package lmsMap;

public class Subject {
	
	private int code;
	private String title;
	
	public Subject(String title) {
		this.title = title;
	}
	
	public Subject(int code, String title) {
		this.code = code;
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

}
