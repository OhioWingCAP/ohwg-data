package ohwg.data.server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ohwg.data.server.data.dao.CapwatchFileProcessor;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreInputStream;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class Upload extends HttpServlet {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(HttpServlet.class
			.getName());

	private CapwatchFileProcessor proc = CapwatchFileProcessor.getInstance();

	/**
	 * 
	 */
	private static final long serialVersionUID = 2253418916282068103L;

	private BlobstoreService blobstoreService = BlobstoreServiceFactory
			.getBlobstoreService();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
		List<BlobKey> blobList = blobs.get("myFile");
		PrintWriter out = res.getWriter();
		if (blobList == null) {
			res.sendRedirect("/");
		} else {
			BlobKey blobKey = blobList.get(0);
			if (blobKey == null) {
				res.sendRedirect("/");
			} else {
				ZipInputStream zis = null;
				try {
					BlobstoreInputStream bis = new BlobstoreInputStream(blobKey);
					zis = new ZipInputStream(new BufferedInputStream(bis));
					ZipEntry entry = null;
					while ((entry = zis.getNextEntry()) != null) {
						String fileName = entry.getName();
						if (fileName == null || "".equals(fileName.trim())) {
							continue;
						}
						if ("Member.txt".equals(fileName)) {
							// Process member
							out.write("Processing members\n");
							proc.processMembers(zis);
						} else if ("OrgAddresses.txt".equals(fileName)) {
							// Process OrgAddress
							out.write("Processing orgAddresses\n");
							proc.processOrgAddresses(zis);
						} else if ("Organization.txt".equals(fileName)) {
							// Process Organization
							out.write("Processing organizations\n");
							proc.processOrgs(zis);
						} else {
							// Log unhandled file name
							out.write("Skipping unknown zip file entry "
									+ fileName + "\n");
						}
						zis.closeEntry();
					}
				} finally {
					if (zis != null) {
						try {
							zis.close();
						} catch (Exception e) {
							// Do nothing
						}
						try {
							if (blobKey != null) {
								blobstoreService.delete(blobKey);
							}
						} catch (Exception e) {
							// Do nothing
						}
					}
				}
				// res.sendRedirect("/upload?blob-key=" +
				// blobKey.getKeyString());
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().write(
				"Uploaded response with blobkey "
						+ req.getParameter("blob-key"));
	}
}