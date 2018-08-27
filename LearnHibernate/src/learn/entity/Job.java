package learn.entity;

/**
 * Job entity. @author MyEclipse Persistence Tools
 */

public class Job implements java.io.Serializable {

	// Fields

	private String uuid;
	private String jobName;
	private Integer jobType;
	private Integer code;

	// Constructors

	/** default constructor */
	public Job() {
	}

	/** full constructor */
	public Job(String uuid, String jobName, Integer jobType, Integer code) {
		this.uuid = uuid;
		this.jobName = jobName;
		this.jobType = jobType;
		this.code = code;
	}

	// Property accessors

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Integer getJobType() {
		return this.jobType;
	}

	public void setJobType(Integer jobType) {
		this.jobType = jobType;
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}