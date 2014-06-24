/*package main.java.dao;

import java.io.Serializable;
import java.util.List;

import org.joda.time.DateTime;

import com.capgemini.m6.diapason.persistence.bean.FilterCriteria;
import com.capgemini.m6.diapason.persistence.bean.SelectRangeSortFilterCriteria;


public abstract class EntityDAO<I extends Serializable, T>
    extends CommonDAO
{
    protected boolean queryCachable = true;

    public T findById(I id)
    {
        return findById(getEntityClass(), id);
    }

    // @Transactional(readOnly=true)
    public T findById(I id, List<String> joinFetchPaths)
    {
        return findById(getEntityClass(), id, joinFetchPaths);
    }

    public List<T> findAll()
    {
        return findAll(getEntityClass());
    }

    public List<T> findAll(int start, int maxResults)
    {
        return findAll(getEntityClass(), start, maxResults);
    }

    public List<T> findAll(final String orderBy, final boolean ascending)
    {
        return findAll(getEntityClass(), orderBy, ascending);
    }

    public List<T> findAll(final int start, final int maxResults, final String orderBy, final boolean ascending)
    {
        return findAll(getEntityClass(), start, maxResults, orderBy, ascending);
    }

    public List<T> findAll(SelectRangeSortFilterCriteria criteria)
    {
        return findAll(getEntityClass(), criteria);
    }

    public int deleteById(I id)
    {
        return deleteById(getEntityClass(), id);
    }

    public Long countAll()
    {
        return countAll(getEntityClass());
    }

    public Long countAll(final List<FilterCriteria> filters)
    {
        return countAll(getEntityClass(), filters);
    }

    public boolean isPropertyExists(final String propertyName, final Object property, final Integer id)
    {
        return isPropertyExists(getEntityClass(), propertyName, property, id);
    }

    // DEBUT HHS QC 1078
    public boolean isPropertyExist(final String propertyName1, final Object property1, final String propertyName2,
                                   final Object property2, final Integer id)
    {
        return isPropertyExist(getEntityClass(), propertyName1, property1, propertyName2, property2, id);
    }

    // FIN HHS QC 1078
    public DateTime getDateOldDebutRequest(final Integer id)
    {
        return getDateOldDebutRequest(getEntityClass(), id);
    }

    public DateTime getDateOldFinRequest(final Integer id)
    {
        return getDateOldFinRequest(getEntityClass(), id);
    }

    public boolean isTripletExists(final String propertyName1, final String propertyName2, final String propertyName3,
                                   final Object property1, final Object property2, final Object property3,
                                   final Integer id)
    {
        return isTripletExists(getEntityClass(), propertyName1, propertyName2, propertyName3, property1, property2,
            property3, id);
    }

    public boolean isDoubletExists(final String propertyName1, final String propertyName2, final Object property1,
                                   final Object property2, final Integer id)
    {
        return isDoubletExists(getEntityClass(), propertyName1, propertyName2, property1, property2, id);
    }

    public boolean isSocieteAlreadyParametre(final String propertyName1, final Object property1, final Integer id)
    {

        return isSocieteAlreadyParametre(getEntityClass(), propertyName1, property1, id);
    }

    protected abstract Class<T> getEntityClass();
}
*/