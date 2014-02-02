package ohwg.data.server.data.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;
import java.util.zip.ZipInputStream;

import ohwg.data.server.data.entity.Keyed;

public class CapwatchFileProcessor {
	private static CapwatchFileProcessor instance;

	@SuppressWarnings("unused")
	private static Logger LOG = Logger.getLogger(CapwatchFileProcessor.class
			.getName());

	private MemberDAO memberDao = new MemberDAO();
	private OrganizationDAO orgDao = new OrganizationDAO();
	private OrgAddressDAO orgAddDao = new OrgAddressDAO();

	public static synchronized CapwatchFileProcessor getInstance() {
		if (instance == null) {
			instance = new CapwatchFileProcessor();
		}
		return instance;
	}

	public void processMembers(ZipInputStream zis) {
		process(memberDao, zis);
	}

	public void processOrgAddresses(ZipInputStream zis) {
		process(orgAddDao, zis);

	}

	public void processOrgs(ZipInputStream zis) {
		process(orgDao, zis);
	}

	private <T extends Keyed> void process(DAO<T> dao, ZipInputStream zis) {
		BufferedReader reader = null;
		InputStreamReader is = null;

		try {
			is = new InputStreamReader(zis);
			reader = new BufferedReader(is);
			String line = null;
			try {
				List<String> headers = Util.splitTrim(reader.readLine());
				while ((line = reader.readLine()) != null) {
					dao.addOrReplace(headers, line);
				}
			} catch (IOException e) {
				// Skip remainder of file
			}
		} finally {
			// closeReaders(reader, is);
		}
	}
}
