package user.example.test.model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -4092763571639416422L;
	private String userId;
    private String name;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
