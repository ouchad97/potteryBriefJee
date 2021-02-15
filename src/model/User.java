package model;

public class User {
	private int idUser;
	private String nameUser;
	private String lastnameUser;
	private String emailUser;
	private String passwordUser;
	private String roleUser;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int idUser, String nameUser, String lastnameUser, String emailUser, String passwordUser,
			String roleUser) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.lastnameUser = lastnameUser;
		this.emailUser = emailUser;
		this.passwordUser = passwordUser;
		this.roleUser = roleUser;
	}
	public User(String nameUser, String lastnameUser, String emailUser, String passwordUser) {
		this.nameUser = nameUser;
		this.lastnameUser = lastnameUser;
		this.emailUser = emailUser;
		this.passwordUser = passwordUser;
	}
	public User(String nameUser, String lastnameUser, String emailUser, String passwordUser, String roleUser) {
		this.nameUser = nameUser;
		this.lastnameUser = lastnameUser;
		this.emailUser = emailUser;
		this.passwordUser = passwordUser;
		this.roleUser = roleUser;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getLastnameUser() {
		return lastnameUser;
	}
	public void setLastnameUser(String lastnameUser) {
		this.lastnameUser = lastnameUser;
	}
	public String getEmailUser() {
		return emailUser;
	}
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	public String getPasswordUser() {
		return passwordUser;
	}
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	public String getRoleUser() {
		return roleUser;
	}
	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
	}
	
	

}
