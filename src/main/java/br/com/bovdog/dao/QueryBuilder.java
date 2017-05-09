package br.com.bovdog.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.MultivaluedMap;

public class QueryBuilder {

	public static <T> TypedQuery<T> buildQuery(
			MultivaluedMap<String, String> queryParameters,
			EntityManager entityManager, Class<T> genericClass) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = criteriaBuilder.createQuery(genericClass);
		Root<T> root = query.from(genericClass);
		TypedQuery<T> typedQuery = null;
		
		if (queryParameters != null) {

			List<Predicate> criteria = new ArrayList<Predicate>();

			String sort = null;
			String order = null;

			if (queryParameters.containsKey("_sort")) {
				sort = queryParameters.getFirst("_sort");
			} else {
				sort = "id";
			}
			if (queryParameters.containsKey("_order")) {
				order = queryParameters.getFirst("_order");
			} else {
				order = "asc";
			}

			for (Map.Entry<String, List<String>> entry : queryParameters
					.entrySet()) {
				if (entry.getKey().charAt(0) != '_') {
					ParameterExpression<String> parameter = criteriaBuilder
							.parameter(String.class, entry.getKey());
					criteria.add(criteriaBuilder.like(
							root.get(parameter.getName()), parameter));
				}
			}
			query.select(root);
			if (criteria.size() > 0) {
				query.where(criteria.toArray(new Predicate[0]));
			}
			if (order.equalsIgnoreCase("desc")) {
				query.orderBy(criteriaBuilder.desc(root.get(sort)));
			} else {
				query.orderBy(criteriaBuilder.asc(root.get(sort)));
			}
			typedQuery = entityManager.createQuery(query);
			for (Map.Entry<String, List<String>> entry : queryParameters
					.entrySet()) {
				if (entry.getKey().charAt(0) != '_') {
					typedQuery.setParameter(entry.getKey(), "%"
							+ entry.getValue().get(0) + "%");
				}

			}
		} else {
			typedQuery = entityManager.createQuery(query);

		}

		return typedQuery;
	}

}
