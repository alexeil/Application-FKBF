/*
package main.java.dao;


import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class CommonDAO2 {

}
public static final int SQL_SERVER_IN_MAX = 1000;

@Resource(name = "sessionFactoryD2")
public void init(SessionFactory sessionFactory)
{
   setSessionFactory(sessionFactory);
}

**
* Persist the given transient instance.
* 
* @param entity the transient instance to persist
* @return the generated identifier
* @throws org.springframework.dao.DataAccessException in case of Hibernate errors
* @see org.hibernate.Session#save(Object)
* 
public Serializable save(Object object)
{
   return getHibernateTemplate().save(object);
}

**
* Update the given persistent instance, associating it with the current Hibernate {@link org.hibernate.Session}.
* 
* @param entity the persistent instance to update
* @throws org.springframework.dao.DataAccessException in case of Hibernate errors
* @see org.hibernate.Session#update(Object)
* 
public void update(Object object)
{
   getHibernateTemplate().update(object);
}

**
* Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
* <tt>Session< tt> or a transient instance with an identifier associated with existing persistent state. This
* operation cascades to associated instances if the association is mapped with <tt>cascade="delete"< tt>.
* 
* @param object the instance to be removed
* @throws org.hibernate.HibernateException
* 
public void delete(Object object)
{
   getHibernateTemplate().delete(object);
}

**
* Save or update the given persistent instance, according to its id (matching the configured "unsaved-value"?).
* Associates the instance with the current Hibernate {@link org.hibernate.Session}.
* 
* @param entity the persistent instance to save or update (to be associated with the Hibernate <code>Session< code>
* )
* @throws DataAccessException in case of Hibernate errors
* @see org.hibernate.Session#saveOrUpdate(Object)
* 
public void saveOrUpdate(Object object)
{
   getHibernateTemplate().saveOrUpdate(object);
}

  DEBUT QC2010 SRS 20140310
**
* Re-read the state of the given persistent instance.
* 
* @param entity the persistent instance to re-read
* @throws DataAccessException in case of Hibernate errors
* @see org.hibernate.Session#refresh(Object)
* 
public void refresh(Object object)
{
   getHibernateTemplate().refresh(object);
}

  FIN QC2010 SRS 20140310



public <I extends Serializable, T> T findById(Class<T> clazz, I id) {
   return getHibernateTemplate().get(clazz, id);
}
}

**
* @param <T>
* @param id
* @param joinFetchPaths
* @return
* 
public <I extends Serializable, T> T findById(final Class<T> clazz, final I id, final List<String> joinFetchPaths)
{
   return getHibernateTemplate().execute(new HibernateCallback<T>()
   {
       @SuppressWarnings("unchecked")
       @Override
       public T doInHibernate(Session session)
           throws HibernateException, SQLException
       {
           Criteria query = session.createCriteria(clazz);
           for(String joinFetchPath : joinFetchPaths)
           {
               query.setFetchMode(joinFetchPath, FetchMode.JOIN);
           }
           query.add(Restrictions.idEq(id));
           return (T) query.uniqueResult();
       }
   });
}

@SuppressWarnings("unchecked")
public <T> List<T> findAll(Class<T> clazz)
{
   return getHibernateTemplate().find("from " + clazz.getName());
}

@SuppressWarnings("unchecked")
public <T> List<T> findAll(final Class<T> clazz, final List<String> joinFetchPaths)
{
   return getHibernateTemplate().execute(new HibernateCallback<List<T>>()
   {
       @Override
       public List<T> doInHibernate(Session session)
           throws HibernateException, SQLException
       {
           Criteria query = session.createCriteria(clazz);
           for(String joinFetchPath : joinFetchPaths)
           {
               query.setFetchMode(joinFetchPath, FetchMode.JOIN);
           }
           return (List<T>) query.list();
       }
   });
}

@SuppressWarnings("unchecked")
public <T> List<T> findAll(Class<T> clazz, int start, int maxResults)
{
   return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(clazz), start, maxResults);
}

@SuppressWarnings("unchecked")
public <T> List<T> findByCriteria(DetachedCriteria criteria)
{
   return getHibernateTemplate().findByCriteria(criteria);
}

@SuppressWarnings("unchecked")
public <T> List<T> findAll(final Class<T> clazz, final String orderBy, final boolean ascending)
{
   if(null == orderBy)
   {
       return findAll(clazz);
   }

   return getHibernateTemplate().execute(new HibernateCallback<List<T>>()
   {
       @Override
       public List<T> doInHibernate(Session session)
           throws HibernateException, SQLException
       {
              orderBy with criteria doesn't work when there is an association like c.address.street where address
              is an entity
           StringBuilder queryBuilder = new StringBuilder("SELECT c FROM ");
           queryBuilder.append(clazz.getName());
           queryBuilder.append(" c ORDER BY c.");
           queryBuilder.append(orderBy);
           if(ascending)
           {
               queryBuilder.append(" ASC");
           }
           else
           {
               queryBuilder.append(" DESC");
           }

           Query query = session.createQuery(queryBuilder.toString());
           return query.list();
       }
   });
}

@SuppressWarnings("unchecked")
public <T> List<T> findAll(final Class<T> clazz, final int start, final int maxResults, final String orderBy,
                          final boolean ascending)
{
   if(null == orderBy)
   {
       return findAll(clazz, start, maxResults);
   }

   return getHibernateTemplate().execute(new HibernateCallback<List<T>>()
   {
       @Override
       public List<T> doInHibernate(Session session)
           throws HibernateException, SQLException
       {
              orderBy with criteria doesn't work when there is an association like c.address.street where address
              is an entity
           StringBuilder queryBuilder = new StringBuilder("SELECT c FROM ");
           queryBuilder.append(clazz.getName());
           queryBuilder.append(" c ORDER BY c.");
           queryBuilder.append(orderBy);
           if(ascending)
           {
               queryBuilder.append(" ASC");
           }
           else
           {
               queryBuilder.append(" DESC");
           }

           Query query = session.createQuery(queryBuilder.toString());
           query.setFirstResult(start);
           query.setMaxResults(maxResults);
           return query.list();
       }
   });
}

public <I extends Serializable, T> int deleteById(final Class<T> clazz, final I id)
{
      id semble fonctionnait dans tous les cas meme si l'id s'appelle idSte par exemple
   return deleteById(clazz, id, "id");
}

public <I extends Serializable, T> int deleteById(final Class<T> clazz, final I id, String idPropertyName)
{
   StringBuilder queryBuilder = new StringBuilder("DELETE FROM ");
   queryBuilder.append(clazz.getName()).append(" c WHERE c.").append(idPropertyName).append("=?");
   return getHibernateTemplate().bulkUpdate(queryBuilder.toString(), id);
}

public <T> int deleteAll(Class<T> clazz)
{
   return getHibernateTemplate().bulkUpdate("DELETE FROM " + clazz.getName() + " c");
}

public <T> Long countAll(final Class<T> clazz)
{
   return getHibernateTemplate().execute(new HibernateCallback<Long>()
   {
       @Override
       public Long doInHibernate(Session session)
           throws HibernateException, SQLException
       {
           Query query = session.createQuery("SELECT count(c) FROM " + clazz.getName() + " c");
           return (Long) query.uniqueResult();
       }
   });
}

public <T> Long countAll(final Class<T> clazz, final List<FilterCriteria> filters)
{
   StringBuilder builder = new StringBuilder("SELECT count(c) FROM ");
   builder.append(clazz.getName()).append(" c");
   return countAll(builder, false, "c", filters);
}

protected Long countAll(final StringBuilder queryBuilder, final boolean clauseWhere, final String idProperty,
                       final List<FilterCriteria> filters)
{
   return getHibernateTemplate().execute(new HibernateCallback<Long>()
   {
       @Override
       public Long doInHibernate(Session session)
           throws HibernateException, SQLException
       {
           String prefixParamFilter = "filter";
           if(null != filters && !filters.isEmpty())
           {
               boolean appendWhere = !clauseWhere;
               int i = 0;
               for(FilterCriteria filter : filters)
               {
                   if(appendWhere)
                   {
                       queryBuilder.append(" WHERE ");
                       appendWhere = false;
                   }
                   else
                   {
                       queryBuilder.append(" AND ");
                   }

                   filter.appendQueryProperty(queryBuilder, idProperty, prefixParamFilter + i);
                   i++;
               }
           }

           Query query = session.createQuery(queryBuilder.toString());
           if(null != filters && !filters.isEmpty())
           {
               int i = 0;
               for(FilterCriteria filter : filters)
               {
                   filter.addQueryParams(query, prefixParamFilter + i);
                   i++;
               }
           }

           return (Long) query.uniqueResult();
       }
   });
}

public <T> List<T> findAll(final Class<T> clazz, final SelectRangeSortFilterCriteria criteria)
{
   return getHibernateTemplate().execute(new HibernateCallback<List<T>>()
   {
       @SuppressWarnings("unchecked")
       @Override
       public List<T> doInHibernate(Session session)
           throws HibernateException, SQLException
       {
           StringBuilder queryBuilder = new StringBuilder("SELECT c FROM ");
           queryBuilder.append(clazz.getName());
           queryBuilder.append(" c");
           Query query = createFindAllQuery(session, queryBuilder, false, "c", criteria);
           return query.list();
       }
   });
}

  DEBUT HHS QC 1124
  protected Query createFindAllUserQuery(final Session session, final StringBuilder queryBuilder,
  final boolean clauseWhere, final String idProperty,
  final SelectRangeSortFilterCriteria criteria)
  {
  String prefixParamFilter = "filter";
  if(null != criteria.getFilters() && !criteria.getFilters().isEmpty())
  {
  boolean appendWhere = !clauseWhere;
  int i = 0;
  for(FilterCriteria filter : criteria.getFilters())
  {
  if(appendWhere)
  {
  queryBuilder.append(" WHERE ");
  appendWhere = false;
  }
  else
  {
  queryBuilder.append(" AND ");
  }
 
  filter.appendQueryProperty(queryBuilder, idProperty, prefixParamFilter + i);
 
  i++;
  }
  }
 
     if(null != criteria.getOrderBy() && null != criteria.getAscending())
     {
     queryBuilder.append(" ORDER BY ").append(idProperty).append(".");
     queryBuilder.append(criteria.getOrderBy());
     if(criteria.getAscending())
     {
     queryBuilder.append(" ASC");
     }
     else
     {
     queryBuilder.append(" DESC");
     }
     }
 
  Query query = session.createQuery(queryBuilder.toString());
  if(null != criteria.getFilters() && !criteria.getFilters().isEmpty())
  {
  int i = 0;
  for(FilterCriteria filter : criteria.getFilters())
  {
  filter.addQueryParams(query, prefixParamFilter + i);
  i++;
  }
  }
  if(null != criteria.getStart())
  {
  query.setFirstResult(criteria.getStart());
  }
  if(null != criteria.getLength())
  {
  query.setMaxResults(criteria.getLength());
  }
  return query;
  }

  FIN HHS QC 1124
protected Query createFindAllQuery(final Session session, final StringBuilder queryBuilder,
                                  final boolean clauseWhere, final String idProperty,
                                  final SelectRangeSortFilterCriteria criteria)
{
   String prefixParamFilter = "filter";
   if(null != criteria.getFilters() && !criteria.getFilters().isEmpty())
   {
       boolean appendWhere = !clauseWhere;
       int i = 0;
       for(FilterCriteria filter : criteria.getFilters())
       {
           if(appendWhere)
           {
               queryBuilder.append(" WHERE ");
               appendWhere = false;
           }
           else
           {
               queryBuilder.append(" AND ");
           }

           filter.appendQueryProperty(queryBuilder, idProperty, prefixParamFilter + i);

           i++;
       }
   }

      DEBUT LYA QC 1183 - 20130507
      if(null != criteria.getOrderBy() && null != criteria.getAscending())
      {
      queryBuilder.append(" ORDER BY ").append(idProperty).append(".");
      queryBuilder.append(criteria.getOrderBy());
      if(criteria.getAscending())
      {
      queryBuilder.append(" ASC");
      }
      else
      {
      queryBuilder.append(" DESC");
      }
      }

   customOrderBy(idProperty, queryBuilder, criteria);
      FIN LYA QC 1183 - 20130507

   Query query = session.createQuery(queryBuilder.toString());
   if(null != criteria.getFilters() && !criteria.getFilters().isEmpty())
   {
       int i = 0;
       for(FilterCriteria filter : criteria.getFilters())
       {
           filter.addQueryParams(query, prefixParamFilter + i);
           i++;
       }
   }
   if(null != criteria.getStart())
   {
       query.setFirstResult(criteria.getStart());
   }
   if(null != criteria.getLength())
   {
       query.setMaxResults(criteria.getLength());
   }
   return query;
}

  DEBUT LYA QC 1183 - 20130507
protected void customOrderBy(String idProperty, StringBuilder queryBuilder, SelectRangeSortFilterCriteria criteria)
{
   if(null != criteria.getOrderBy() && null != criteria.getAscending())
   {
       queryBuilder.append(" ORDER BY ").append(idProperty).append(".");
       queryBuilder.append(criteria.getOrderBy());
       if(criteria.getAscending())
       {
           queryBuilder.append(" ASC");
       }
       else
       {
           queryBuilder.append(" DESC");
       }
   }
}

  FIN LYA QC 1183 - 20130507

**
* Indique si une propri&eacute;t&eacute; est d&eacute;j&agrave; pr&eacute;sente en base pour une table
* donn&eacute;e. Il est possible d'indiquer l'id d'un &eacute;l&eacute;ment &agrave; filtrer si l'on sait qu'il
* contient la propri&eacute;t&eacute;
* 
* @param clazz
* @param propertyName Nom de la propri&eacute;t&eacute;
* @param property Valeur &agrave; tester
* @param id Id de l'&eacute;l&eacute;ment &agrave; filtrer, peut &ecirc;tre null
* @return true si la propri&eacute;t&eacute; existe d&eacute;j&agrave; pour un &eacute;l&eacute;ment autre que
* celui fourni en param&egrave;tre
* 
public <T> boolean isPropertyExists(final Class<T> clazz, final String propertyName, final Object property,
                                   final Integer id)
{
   return getHibernateTemplate().execute(new HibernateCallback<Boolean>()
   {
       @Override
       public Boolean doInHibernate(Session session)
           throws HibernateException, SQLException
       {
           StringBuilder queryBuilder = new StringBuilder("SELECT count(c) FROM ");
           queryBuilder.append(clazz.getName()).append(" c WHERE c.");
           queryBuilder.append(propertyName).append("=:property");
           if(null != id)
           {
               queryBuilder.append(" AND c.id!=").append(id);
           }
           Query query = session.createQuery(queryBuilder.toString());
           query.setParameter("property", property);
           return (Long) query.uniqueResult() > 0;
       }
   });
}

  DEBUT HHS QC 1078

**
* Indique si une propri&eacute;t&eacute; est d&eacute;j&agrave; pr&eacute;sente en base pour une table
* donn&eacute;e. Il est possible d'indiquer l'id d'un &eacute;l&eacute;ment &agrave; filtrer si l'on sait qu'il
* contient la propri&eacute;t&eacute;
* 
* @param clazz
* @param propertyName Nom de la propri&eacute;t&eacute;
* @param property Valeur &agrave; tester
* @param id Id de l'&eacute;l&eacute;ment &agrave; filtrer, peut &ecirc;tre null
* @return true si la propri&eacute;t&eacute; existe d&eacute;j&agrave; pour un &eacute;l&eacute;ment autre que
* celui fourni en param&egrave;tre
* 
public <T> boolean isPropertyExist(final Class<T> clazz, final String propertyName1, final Object property1,
                                  final String propertyName2, final Object property2, final Integer id)
{
   return getHibernateTemplate().execute(new HibernateCallback<Boolean>()
   {
       @Override
       public Boolean doInHibernate(Session session)
           throws HibernateException, SQLException
       {
           StringBuilder queryBuilder = new StringBuilder("SELECT count(c) FROM ");
           queryBuilder.append(clazz.getName()).append(" c WHERE c.");
           queryBuilder.append(propertyName1).append("=:property1");
           queryBuilder.append(" AND ");
           queryBuilder.append(propertyName2).append("=:property2");
           if(null != id)
           {
               queryBuilder.append(" AND c.id!=").append(id);
           }
           Query query = session.createQuery(queryBuilder.toString());
           query.setParameter("property1", property1);
           query.setParameter("property2", property2);
           return (Long) query.uniqueResult() > 0;
       }
   });
}

  FIN HHS QC 1078
  Recuperation de la date de debut en base
public <T> DateTime getDateOldDebutRequest(final Class<T> clazz, final Integer id)
{
   return getHibernateTemplate().execute(new HibernateCallback<DateTime>()
   {
       @Override
       public DateTime doInHibernate(Session session)
           throws HibernateException, SQLException
       {
           StringBuilder queryBuilder = new StringBuilder("SELECT debut FROM ");
           queryBuilder.append(clazz.getName()).append(" c WHERE c.");
           queryBuilder.append("id=").append(id);

           Query query = session.createQuery(queryBuilder.toString());
           return (DateTime) query.uniqueResult();
       }
   });
}

  Recuperation de la date de fin en base
public <T> DateTime getDateOldFinRequest(final Class<T> clazz, final Integer id)
{
   return getHibernateTemplate().execute(new HibernateCallback<DateTime>()
   {
       @Override
       public DateTime doInHibernate(Session session)
           throws HibernateException, SQLException
       {
           StringBuilder queryBuilder = new StringBuilder("SELECT fin FROM ");
           queryBuilder.append(clazz.getName()).append(" c WHERE c.");
           queryBuilder.append("id=").append(id);

           Query query = session.createQuery(queryBuilder.toString());
           return (DateTime) query.uniqueResult();
       }
   });
}

  V&eacute;rification si le triplet existe
public <T> boolean isTripletExists(final Class<T> clazz, final String propertyName1, final String propertyName2,
                                  final String propertyName3, final Object property1, final Object property2,
                                  final Object property3, final Integer id)
{
   return getHibernateTemplate().execute(new HibernateCallback<Boolean>()
   {
       @Override
       public Boolean doInHibernate(Session session)
           throws HibernateException, SQLException
       {
           StringBuilder queryBuilder = new StringBuilder("SELECT count(c) FROM ");
           queryBuilder.append(clazz.getName()).append(" c WHERE c.");
           queryBuilder.append(propertyName1).append("=:property1");
           queryBuilder.append(" AND c.");
           queryBuilder.append(propertyName2).append("=:property2");
           queryBuilder.append(" AND c.");
           queryBuilder.append(propertyName3).append("=:property3");
           if(null != id)
           {
               queryBuilder.append(" AND c.id!=").append(id);
           }
           Query query = session.createQuery(queryBuilder.toString());
           query.setParameter("property1", property1);
           query.setParameter("property2", property2);
           query.setParameter("property3", property3);
           return (Long) query.uniqueResult() > 0;
       }
   });
}

  V&eacute;rification si le doublet existe
public <T> boolean isDoubletExists(final Class<T> clazz, final String propertyName1, final String propertyName2,
                                  final Object property1, final Object property2, final Integer id)
{
   return getHibernateTemplate().execute(new HibernateCallback<Boolean>()
   {
       @Override
       public Boolean doInHibernate(Session session)
           throws HibernateException, SQLException
       {
           StringBuilder queryBuilder = new StringBuilder("SELECT count(c) FROM ");
           queryBuilder.append(clazz.getName()).append(" c WHERE c.");
           queryBuilder.append(propertyName1).append("=:property1");
           queryBuilder.append(" AND c.");
           queryBuilder.append(propertyName2).append("=:property2");
           if(null != id)
           {
               queryBuilder.append(" AND c.id!=").append(id);
           }
           Query query = session.createQuery(queryBuilder.toString());
           query.setParameter("property1", property1);
           query.setParameter("property2", property2);
           return (Long) query.uniqueResult() > 0;
       }
   });
}

  V&eacute;rification si la societe est deja paramétrée
public <T> boolean isSocieteAlreadyParametre(final Class<T> clazz, final String propertyName1,
                                            final Object property1, final Integer id)
{
   return getHibernateTemplate().execute(new HibernateCallback<Boolean>()
   {
       @Override
       public Boolean doInHibernate(Session session)
           throws HibernateException, SQLException
       {
           StringBuilder queryBuilder = new StringBuilder("SELECT count(c) FROM ");
           queryBuilder.append(clazz.getName()).append(" c WHERE c.");
           queryBuilder.append(propertyName1).append("=:property1");
           if(null != id)
           {
               queryBuilder.append(" AND c.id!=").append(id);
           }
           Query query = session.createQuery(queryBuilder.toString());
           query.setParameter("property1", property1);
           return (Long) query.uniqueResult() > 0;
       }
   });
}

  DEBUT LYA QC 1316 - 20130702
**
* Méthode permettant d'effectuer la recherche d'élément d'un type T (une entité). Utilisée notamment pour les
* suggestions.
* 
* @param clazz
* @param criteria
* @return
* 
public <T> List<T> findEntitySimpleSuggest(final Class<T> clazz, final SelectRangeSortFilterCriteria criteria,
                                          final List<String> joinFetchPaths)
{
   return getHibernateTemplate().execute(new HibernateCallback<List<T>>()
   {
       @SuppressWarnings("unchecked")
       @Override
       public List<T> doInHibernate(Session session)
           throws HibernateException, SQLException
       {
           StringBuilder queryBuilder = new StringBuilder("SELECT distinct e FROM ");
           queryBuilder.append(clazz.getName());
           queryBuilder.append(" e");

           for(String fetch : joinFetchPaths)
           {
               queryBuilder.append(" left join fetch e." + fetch);
           }
           Query query = createFindAllQuery(session, queryBuilder, false, "e", criteria);
           return query.list();
       }
   });
}
  FIN LYA QC 1316 - 20130702

}
*/