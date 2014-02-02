package ohwg.data.server.data.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ohwg.data.server.data.EMF;
import ohwg.data.server.data.entity.Keyed;

public abstract class DAO<T extends Keyed> {

	// private EntityManager em = null;//
	protected static Logger LOG = Logger.getLogger(DAO.class.getName());

	public void addOrReplace(T m) {
		EntityManager em = EMF.get().createEntityManager();
		@SuppressWarnings("unchecked")
		TypedQuery<T> q = (TypedQuery<T>) em.createNamedQuery(m.getClass()
				.getSimpleName() + ".findByKey", m.getClass());
		q.setParameter("key", m.getKey());
		List<T> results = q.getResultList();

		if (results != null && results.size() > 0) {
			for (T found : results) {
				em.remove(found);
			}
		}
		em.persist(m);
		em.close();
	}

	public void addOrReplace(List<String> headers, String csvLine) {
		addOrReplace(parse(headers, csvLine));
	}

	public abstract T parse(List<String> headers, String csvLine);

}
