package entity;

public class Stu {

	private int id;
	private String name;
	private String gender;
	private String birth;
	private String classes;
	private String phone;
	private String qq;
	private String address;
	private String message;

	public Stu() {
		
	}
	
	public Stu(int id,String name,String gender,String birth,String classes,String phone,String
			qq,String address,String message){
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.classes = classes;
		this.phone = phone;
		this.qq = qq;
		this.address = address;
		this.message = message;
		
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", gender=" + gender + ", birth=" + birth + ", "
				+ "classes=" + classes + ",phone=" + phone + ", qq=" + qq
				+ ", address=" + address + ", message=" + message + "]";
	}

}
