package Entity;

import java.util.List;

public class Role {
	private long idRole; 
	private String roleName;
	private List<User> users;
	public Role(long idRole, String roleName, List<User> users) {
		super();
		this.idRole = idRole;
		this.roleName = roleName;
		this.users = users;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public long getIdRole() {
		return idRole;
	}

}
