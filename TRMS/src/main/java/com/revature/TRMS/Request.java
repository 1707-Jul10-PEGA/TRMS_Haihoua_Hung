package com.revature.TRMS;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Request {
	private int requestId;
	private String firstName;
	private String lastName;
	private double amount;
	private Timestamp eventDate;
	private String location;
	private String description;
	private String gradingFormat;
	private String eventType;
	private String justification;
	private int status;
	private int employeeID;
	private String path;
	private int passing_grade;
	private int grade = -1;
	private int approval1 = -1;
	private int approval2 =-1;
	private int approval3 = -1;
	
	public Request(int requestId, String firstName, String lastName, double amount, Timestamp eventDate,
			String location, String description, String gradingFormat, String eventType, String justification,
			int status, int employeeID, String path, int passing_grade) {
		super();
		this.requestId = requestId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.amount = amount;
		this.eventDate = eventDate;
		this.location = location;
		this.description = description;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.justification = justification;
		this.status = status;
		this.employeeID = employeeID;
		this.path = path;
		this.passing_grade = passing_grade;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getEventDate() {
		return eventDate;
	}

	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGradingFormat() {
		return gradingFormat;
	}

	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getPassing_grade() {
		return passing_grade;
	}

	public void setPassing_grade(int passing_grade) {
		this.passing_grade = passing_grade;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getApproval1() {
		return approval1;
	}

	public void setApproval1(int approval1) {
		this.approval1 = approval1;
	}

	public int getApproval2() {
		return approval2;
	}

	public void setApproval2(int approval2) {
		this.approval2 = approval2;
	}

	public int getApproval3() {
		return approval3;
	}

	public void setApproval3(int approval3) {
		this.approval3 = approval3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + approval1;
		result = prime * result + approval2;
		result = prime * result + approval3;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + employeeID;
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + grade;
		result = prime * result + ((gradingFormat == null) ? 0 : gradingFormat.hashCode());
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + passing_grade;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + requestId;
		result = prime * result + status;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (approval1 != other.approval1)
			return false;
		if (approval2 != other.approval2)
			return false;
		if (approval3 != other.approval3)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeID != other.employeeID)
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (grade != other.grade)
			return false;
		if (gradingFormat == null) {
			if (other.gradingFormat != null)
				return false;
		} else if (!gradingFormat.equals(other.gradingFormat))
			return false;
		if (justification == null) {
			if (other.justification != null)
				return false;
		} else if (!justification.equals(other.justification))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (passing_grade != other.passing_grade)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (requestId != other.requestId)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", firstName=" + firstName + ", lastName=" + lastName + ", amount="
				+ amount + ", eventDate=" + eventDate + ", location=" + location + ", description=" + description
				+ ", gradingFormat=" + gradingFormat + ", eventType=" + eventType + ", justification=" + justification
				+ ", status=" + status + ", employeeID=" + employeeID + ", path=" + path + ", passing_grade="
				+ passing_grade + ", grade=" + grade + ", approval1=" + approval1 + ", approval2=" + approval2
				+ ", approval3=" + approval3 + "]";
	}
	
	

	
}
