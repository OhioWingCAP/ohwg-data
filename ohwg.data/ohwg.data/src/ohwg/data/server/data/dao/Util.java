package ohwg.data.server.data.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Util {
	
	public static List<String> splitTrim(String line) {
		return splitTrim(line, false);
	}
	public static List<String> splitTrim(String line, boolean ignoreBlanks) {
		List<String> retval = new ArrayList<String>();
		String[] split = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
		for(String h : split) {
			if(h == null || "".equals(h.trim())) {
				continue;
			}
			retval.add(h.trim());
		}
		return retval;
	}
	

	public static void closeReaders(Reader... rs) {
		if (rs == null) {
			return;
		}
		for (Reader r : rs) {
			try {
				r.close();
			} catch (Exception e) {
				// Ignore
			}
		}
	}
}
