package ohwg.data.server.data.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member implements Keyed {
	@Id
	private String capid;
	private String ssn;
	private String nameLast;
	private String nameFirst;
	private String nameMiddle;
	private String nameSuffix;
	private String gender;
	private Date dob;
	private String profession;
	private String educationLevel;
	private String citizen;
	private int orgid;
	private String wing;
	private String unit;
	private String rank;
	private String joined;
	private String expiration;
	private String orgJoined;
	private String usrID;
	private Date dateMod;
	private String lsCode;
	private String type;
	private String rankDate;
	private String region;
	private String mbrStatus;
	private String picStatus;
	private Date picDate;

	// @JoinColumn(updatable = false)
	// private Organization org;

	public String getCapid() {
		return capid;
	}

	public void setCapid(String capid) {
		this.capid = capid;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getNameLast() {
		return nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public String getNameFirst() {
		return nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameMiddle() {
		return nameMiddle;
	}

	public void setNameMiddle(String nameMiddle) {
		this.nameMiddle = nameMiddle;
	}

	public String getNameSuffix() {
		return nameSuffix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getCitizen() {
		return citizen;
	}

	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}

	public int getOrgid() {
		return orgid;
	}

	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}

	public String getWing() {
		return wing;
	}

	public void setWing(String wing) {
		this.wing = wing;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getJoined() {
		return joined;
	}

	public void setJoined(String joined) {
		this.joined = joined;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public String getOrgJoined() {
		return orgJoined;
	}

	public void setOrgJoined(String orgJoined) {
		this.orgJoined = orgJoined;
	}

	public String getUsrID() {
		return usrID;
	}

	public void setUsrID(String usrID) {
		this.usrID = usrID;
	}

	public Date getDateMod() {
		return dateMod;
	}

	public void setDateMod(Date dateMod) {
		this.dateMod = dateMod;
	}

	public String getLsCode() {
		return lsCode;
	}

	public void setLsCode(String lsCode) {
		this.lsCode = lsCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRankDate() {
		return rankDate;
	}

	public void setRankDate(String rankDate) {
		this.rankDate = rankDate;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getMbrStatus() {
		return mbrStatus;
	}

	public void setMbrStatus(String mbrStatus) {
		this.mbrStatus = mbrStatus;
	}

	public String getPicStatus() {
		return picStatus;
	}

	public void setPicStatus(String picStatus) {
		this.picStatus = picStatus;
	}

	public Date getPicDate() {
		return picDate;
	}

	public void setPicDate(Date picDate) {
		this.picDate = picDate;
	}

	@Override
	public String getKey() {
		return getCapid();
	}

}
