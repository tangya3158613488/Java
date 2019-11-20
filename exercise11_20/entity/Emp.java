package entity;

public class Emp {
	private int id;
	private String name;
	private String phone;
	private String gender;
	private String empNo;
	private int deptNo;
	private int age;
	
	public Emp(){
		
	}
	
	public Emp(int id, String name, String phone, String empNo, int age) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.empNo = empNo;
		this.age = age;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
