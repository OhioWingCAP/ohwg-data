package ohwg.data.server.data.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import ohwg.data.server.data.entity.OrgScope;
import ohwg.data.server.data.entity.OrgType;
import ohwg.data.server.data.entity.Organization;

@NamedQueries({
		@NamedQuery(name = "Organization.findAll", query = "SELET o FROM Organization o"),
		@NamedQuery(name = "Organization.findByKey", query = "SELECT o from Organization o where o.orgid = :key") })
public class OrganizationDAO extends DAO<Organization> {
	
	public Organization parse(List<String> headers, String csvLine) {
		Organization m = new Organization();
		int i = 0;
		for (String col : Util.splitTrim(csvLine)) {
			String d = col.trim().replaceAll("\"", "");
			if (i >= headers.size()) {
				LOG.log(Level.SEVERE, "Unable to get header from index " + i);
				return m;
			}
			String h = headers.get(i++);
			SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
			if ("ORGID".equals(h)) {
				m.setOrgid(d);
			} else if ("Region".equals(h)) {
				m.setRegion(d);
			} else if ("Wing".equals(h)) {
				m.setWing(d);
			} else if ("Unit".equals(h)) {
				m.setUnit(d);
			} else if ("NextLevel".equals(h)) {
				m.setNextLevel(d);
			} else if ("Name".equals(h)) {
				m.setName(d);
			} else if ("Type".equals(h)) {
				m.setType(OrgType.valueOf(d));
			} else if ("DateChartered".equals(h)) {
				try {
					m.setDateChartered(sdf.parse(d));
				} catch (ParseException e) {
					LOG.log(Level.WARNING, "Unable to parse Date Chartered", e);
				}
			} else if ("Status".equals(h)) {
				m.setStatus(d);
			} else if ("Scope".equals(h)) {
				m.setScope(OrgScope.valueOf(d));
			} else if ("UsrID".equals(h)) {
				m.setUsrID(d);
			} else if ("DateMod".equals(h)) {
				try {
					m.setDateMod(sdf.parse(d));
				} catch (ParseException e) {
					LOG.log(Level.WARNING, "Unable to parse Date Mod", e);

				}
			} else if ("FirstUsr".equals(h)) {
				m.setFirstUsr(d);
			} else if ("DateCreated".equals(h)) {
				try {
					m.setDateCreated(sdf.parse(d));
				} catch (ParseException e) {
					LOG.log(Level.WARNING, "Unable to parse Date Created", e);

				}
			} else if ("DateReceived".equals(h)) {
				try {
					m.setDateReceived(sdf.parse(d));
				} catch (ParseException e) {
					LOG.log(Level.WARNING, "Unable to parse Date Received", e);

				}
			} else if ("OrgNotes".equals(h)) {
				m.setOrgNotes(d);
			}
		}
		return m;
	}
}
