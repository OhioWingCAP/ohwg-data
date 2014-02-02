package ohwg.data.server.data.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Organization implements Keyed {
	@Id
	private String orgid;
	private String region;
	private String wing;
	private String unit;
	private String nextLevel;
	private String name;
	private OrgType type;
	private Date dateChartered;
	private String status;
	private OrgScope scope;
	private String usrID;
	private Date dateMod;
	private String firstUsr;
	private Date dateCreated;
	private Date dateReceived;
	private String orgNotes;

	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgid")
	// private List<Member> members = new ArrayList<Member>();

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public String getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(String nextLevel) {
		this.nextLevel = nextLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OrgType getType() {
		return type;
	}

	public void setType(OrgType type) {
		this.type = type;
	}

	public Date getDateChartered() {
		return dateChartered;
	}

	public void setDateChartered(Date dateChartered) {
		this.dateChartered = dateChartered;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrgScope getScope() {
		return scope;
	}

	public void setScope(OrgScope scope) {
		this.scope = scope;
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

	public String getFirstUsr() {
		return firstUsr;
	}

	public void setFirstUsr(String firstUsr) {
		this.firstUsr = firstUsr;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getOrgNotes() {
		return orgNotes;
	}

	public void setOrgNotes(String orgNotes) {
		this.orgNotes = orgNotes;
	}

	@Override
	public String getKey() {
		return getOrgid();
	}
}
