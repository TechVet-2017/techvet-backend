/*
 * File: QueryBuilder.java
 * Description: Defines the search filter treatments.
 */
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

/**
 * Class that define the search with filter in the system. 
 * 
 * @author lucas, joão, flavio
 * @version 1.0
 *
 */
public class QueryBuilder {

	/**
	 * This method describes the search filter construction 
	 * 
	 * @param queryParameters List of query 
	 * @param entityManager Center service of persistence
	 * @param genericClass Generalization of classes
	 * @return typedQuery
	 */
	public static <T> TypedQuery<T> buildQuery(
			MultivaluedMap<String, String> queryParameters,
			EntityManager entityManager, Class<T> genericClass) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = criteriaBuilder.createQuery(genericClass);
		Root<T> root = query.from(genericClass);
		TypedQuery<T> typedQuery = null;

		// treat the search with filters if it is not null, else maintain the neutral state of search
		if (queryParameters != null) {

			List<Predicate> criteria = new ArrayList<>();

			String sort = null;
			String order = null;

			// call methods of search order and sort
			sort = typeSortQuery(queryParameters);
			order = typeOrderQuery(queryParameters);
			
			// Collection search parameters to criteria
			criteria = collectCriteriaParameters(queryParameters,
					criteriaBuilder, criteria, root);

			query.select(root);
			typedQuery = queryFilters(criteria, order, query, criteriaBuilder,
					root, sort, queryParameters, entityManager);
		} else {
			typedQuery = entityManager.createQuery(query);

		}

		return typedQuery;

	}

	/**
	 * This method describes the collection of search filters
	 * 
	 * @param criteria 
	 * @param order Order string 
	 * @param query List of searchs
	 * @param criteriaBuilder 
	 * @param root Generic list
	 * @param sort Sort string
	 * @param queryParameters List of query
	 * @param entityManager Center service of persistence
	 * @return typedQuery
	 */
	private static <T> TypedQuery<T> queryFilters(List<Predicate> criteria,
			String order, CriteriaQuery<T> query,
			CriteriaBuilder criteriaBuilder, Root<T> root, String sort,
			MultivaluedMap<String, String> queryParameters,
			EntityManager entityManager) {

		if (criteria.size() > 0) {
			query.where(criteria.toArray(new Predicate[0]));
		} else {
			// do nothing.
		}

		if (order.equalsIgnoreCase("desc")) { //$NON-NLS-1$
			query.orderBy(criteriaBuilder.desc(root.get(sort)));
		} else {
			query.orderBy(criteriaBuilder.asc(root.get(sort)));
		}

		TypedQuery<T> typedQuery = null;
		typedQuery = entityManager.createQuery(query);

		typedQuery = collectQueryValues(queryParameters, typedQuery);

		return typedQuery;
	}

	/**
	 * This method select the type of sort to search
	 * 
	 * @param queryParameters List of query
	 * @return sort
	 */
	private static String typeSortQuery(
			MultivaluedMap<String, String> queryParameters) {
		String sort = null;

		if (queryParameters.containsKey("_sort")) { //$NON-NLS-1$
			sort = queryParameters.getFirst("_sort"); //$NON-NLS-1$
		} else {
			sort = "id"; //$NON-NLS-1$
		}

		return sort;
	}

	/**
	 * This method select the type of sort to search.
	 * 
	 * @param queryParameters List of query.
	 * @return order
	 */
	private static String typeOrderQuery(
			MultivaluedMap<String, String> queryParameters) {
		String order = null;

		if (queryParameters.containsKey("_order")) { //$NON-NLS-1$
			order = queryParameters.getFirst("_order"); //$NON-NLS-1$
		} else {
			order = "asc"; //$NON-NLS-1$
		}

		return order;
	}

	/**
	 * This method defines the treatment to collect search parameters
	 * 
	 * @param queryParameters List of query.
	 * @param criteriaBuilder
	 * @param criteria
	 * @param root
	 * @return criteria
	 */
	private static <T> List<Predicate> collectCriteriaParameters(
			MultivaluedMap<String, String> queryParameters,
			CriteriaBuilder criteriaBuilder, List<Predicate> criteria,
			Root<T> root) {

		for (Map.Entry<String, List<String>> entry : queryParameters.entrySet()) {
			
			if (entry.getKey().charAt(0) != '_') {

				ParameterExpression<String> parameter;

				if (entry.getKey().equalsIgnoreCase("q")) {
					parameter = criteriaBuilder.parameter(String.class,
							"patientName");
				} else {
					parameter = criteriaBuilder.parameter(String.class,
							entry.getKey());
				}
				
				criteria.add(criteriaBuilder.like(root.get(parameter.getName()), parameter));
			
			} else {
				// do nothing.
			}
		}

		return criteria;
	}

	/**
	 * This method defines the treatment to collect search parameters
	 * 
	 * @param queryParameters
	 * @param typedQuery 
	 * @return typedQuery
	 */
	private static <T> TypedQuery<T> collectQueryValues(
			MultivaluedMap<String, String> queryParameters,
			TypedQuery<T> typedQuery) {
		
		for (Map.Entry<String, List<String>> entry : queryParameters.entrySet()) {
			
			if (entry.getKey().charAt(0) != '_') {
				
				if (entry.getKey().equalsIgnoreCase("q")) {
					typedQuery.setParameter("patientName", "%"
							+ entry.getValue().get(0) + "%");
				} else {
					typedQuery.setParameter(entry.getKey(), "%"
							+ entry.getValue().get(0) + "%");
				}
				
			}

		}

		return typedQuery;
	}

}
