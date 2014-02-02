package ohwg.data.server.data.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import ohwg.data.server.data.entity.Member;

@NamedQueries({
		@NamedQuery(name = "Member.findAll", query = "SELET m FROM Member m"),
		@NamedQuery(name = "Member.findByKey", query = "SELECT m from Member m where m.capid = :key") })
public class MemberDAO extends DAO<Member> {

	public Member parse(List<String> headers, String csvLine) {

		Member m = new Member();
		int i = 0;
		for (String col : Util.splitTrim(csvLine)) {
			String d = col.trim().replaceAll("\"", "");
			if (i >= headers.size()) {
				LOG.log(Level.SEVERE, "Unable to get header from index " + i);
				return m;
			}
			String h = headers.get(i++);
			SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
			if ("CAPID".equals(h)) {
				m.setCapid(d);
			} else if ("SSN".equals(h)) {
				m.setSsn(d);
			} else if ("NameLast".equals(h)) {
				m.setNameLast(d);
			} else if ("NameFirst".equals(h)) {
				m.setNameFirst(d);
			} else if ("NameMiddle".equals(h)) {
				m.setNameMiddle(d);
			} else if ("NameSuffix".equals(h)) {
				m.setNameSuffix(d);
			} else if ("Gender".equals(h)) {
				m.setGender(d);
			} else if ("DOB".equals(h)) {
				try {
					m.setDob(sdf.parse(d));
				} catch (ParseException e) {
					LOG.log(Level.WARNING, "Unable to parse Dob", e);
				}
			} else if ("Profession".equals(h)) {
				m.setProfession(d);
			} else if ("EducationLevel".equals(h)) {
				m.setEducationLevel(d);
			} else if ("Citizen".equals(h)) {
				m.setCitizen(d);
			} else if ("ORGID".equals(h)) {
				m.setOrgid(Integer.parseInt(d));
			} else if ("Wing".equals(h)) {
				m.setWing(d);
			} else if ("Unit".equals(h)) {
				m.setUnit(d);
			} else if ("Rank".equals(h)) {
				m.setRank(d);
			} else if ("Joined".equals(h)) {
				m.setJoined(d);
			} else if ("Expiration".equals(h)) {
				m.setExpiration(d);
			} else if ("OrgJoined".equals(h)) {
				m.setOrgJoined(d);
			} else if ("UsrID".equals(h)) {
				m.setUsrID(d);
			} else if ("DateMod".equals(h)) {
				try {
					m.setDateMod(sdf.parse(d));
				} catch (ParseException e) {
					LOG.log(Level.WARNING, "Unable to parse DateMod", e);
				}
				// } else if ("LSCode".equals(h)) {
				// m.setLSCode(d);
			} else if ("Type".equals(h)) {
				m.setType(d);
			} else if ("RankDate".equals(h)) {
				m.setRankDate(d);
			} else if ("Region".equals(h)) {
				m.setRegion(d);
			} else if ("MbrStatus".equals(h)) {
				m.setMbrStatus(d);
			} else if ("PicStatus".equals(h)) {
				m.setPicStatus(d);
			} else if ("PicDate".equals(h)) {
				try {
					m.setPicDate(sdf.parse(d));
				} catch (ParseException e) {
					LOG.log(Level.WARNING, "Unable to parse PicDate", e);
				}
			}
		}
		return m;
	}
}
