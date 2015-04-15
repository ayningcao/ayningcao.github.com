package com.sejian.pojo;

import java.util.Date;

/**
 * Application user
 * 
 * @author Alex
 * 
 */
public class User {

	/**
	 * shoule be one of the fllowings:IMEI(Android), UDID(iOS), username(used
	 * defined);
	 * 
	 * Must be unique.
	 */
	private String id;

	private String password;

	private String userName;

	/**
	 * full path(URL) of user's avatar
	 */
	private String avatar;

	private int sex;

	private String birthDate;

	private String description;

	private String location;

	/**
	 * iOS/Android...
	 */
	private String platform;

	private String ip;

	private Date firstUseDate;

	private Date lastestUserDate;

	private Date firstUseGeo;

	/**
	 * Indicating whether this is a registered user
	 */
	private boolean isRegistered;

	/**
	 * Indicating whether this use has been freezed
	 */
	private boolean isFreezed;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getFirstUseDate() {
		return firstUseDate;
	}

	public void setFirstUseDate(Date firstUseDate) {
		this.firstUseDate = firstUseDate;
	}

	public Date getLastestUserDate() {
		return lastestUserDate;
	}

	public void setLastestUserDate(Date lastestUserDate) {
		this.lastestUserDate = lastestUserDate;
	}

	public Date getFirstUseGeo() {
		return firstUseGeo;
	}

	public void setFirstUseGeo(Date firstUseGeo) {
		this.firstUseGeo = firstUseGeo;
	}

	public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public boolean isFreezed() {
		return isFreezed;
	}

	public void setFreezed(boolean isFreezed) {
		this.isFreezed = isFreezed;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", avatar="
				+ avatar + ", sex=" + sex + ", birthDate=" + birthDate
				+ ", description=" + description + ", location=" + location
				+ ", platform=" + platform + ", ip=" + ip + ", firstUseDate="
				+ firstUseDate + ", lastestUserDate=" + lastestUserDate
				+ ", firstUseGeo=" + firstUseGeo + ", isRegistered="
				+ isRegistered + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
