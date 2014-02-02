package ohwg.data.server.data.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import ohwg.data.server.data.entity.OrgAddress;
import ohwg.data.server.data.entity.OrgAddressType;
import ohwg.data.server.data.entity.Priority;

@NamedQueries({
	@NamedQuery(name = "OrgAddresses.findAll", query = "SELET o FROM OrgAddresses o"),
	@NamedQuery(name = "OrgAddresses.findByKey", query = "SELECT o from OrgAddresses o where o.orgid = :key") })
public class OrgAddressDAO extends DAO<OrgAddress> {

	@Override
	public OrgAddress parse(List<String> headers, String csvLine) {

		OrgAddress m = new OrgAddress();
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
			} else if ("Wing".equals(h)) {
				m.setWing(d);
			} else if ("Unit".equals(h)) {
				m.setUnit(d);
			} else if ("Type".equals(h)) {
				m.setType(OrgAddressType.valueOf(d));
			} else if ("Priority".equals(h)) {
				m.setPriority(Priority.valueOf(d));
			} else if ("Addr1".equals(h)) {
				m.setAddr1(d);
			} else if ("Addr2".equals(h)) {
				m.setAddr2(d);
			} else if ("City".equals(h)) {
				m.setCity(d);
			} else if ("State".equals(h)) {
				m.setState(d);
			} else if ("Zip".equals(h)) {
				m.setZip(d);
			} else if ("Latitude".equals(h)) {
				m.setLatitude(d);
			} else if ("Longitude".equals(h)) {
				m.setLongitude(d);
			} else if ("UsrID".equals(h)) {
				m.setUsrID(d);
			} else if ("DateMod".equals(h)) {
				try {
					m.setDateMod(sdf.parse(d));
				} catch (ParseException e) {
					LOG.log(Level.WARNING, "Unable to parse DateMod", e);
				}
			}
		}
		return m;

	}

}
