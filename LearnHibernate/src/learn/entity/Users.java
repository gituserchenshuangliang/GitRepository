package learn.entity;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Users implements java.io.Serializable {

	// Fields

	private String uuid;
	private String userName;
	private String userPhone;
	private String userAddress;
	private String sex;
	private Integer age;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String uuid, String userName, String userPhone, String sex) {
		this.uuid = uuid;
		this.userName = userName;
		this.userPhone = userPhone;
		this.sex = sex;
	}

	/** full constructor */
	public Users(String uuid, String userName, String userPhone,
			String userAddress, String sex, Integer age) {
		this.uuid = uuid;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.sex = sex;
		this.age = age;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Users [uuid=" + uuid + ", userName=" + userName
				+ ", userPhone=" + userPhone + ", userAddress=" + userAddress
				+ ", sex=" + sex + ", age=" + age + "]";
	}

}