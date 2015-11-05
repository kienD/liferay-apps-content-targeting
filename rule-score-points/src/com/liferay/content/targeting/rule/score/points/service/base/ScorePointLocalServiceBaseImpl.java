/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.content.targeting.rule.score.points.service.base;

import com.liferay.content.targeting.rule.score.points.model.ScorePoint;
import com.liferay.content.targeting.rule.score.points.service.ScorePointLocalService;
import com.liferay.content.targeting.rule.score.points.service.persistence.ScorePointPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the score point local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.content.targeting.rule.score.points.service.impl.ScorePointLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.rule.score.points.service.impl.ScorePointLocalServiceImpl
 * @see com.liferay.content.targeting.rule.score.points.service.ScorePointLocalServiceUtil
 * @generated
 */
public abstract class ScorePointLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ScorePointLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.content.targeting.rule.score.points.service.ScorePointLocalServiceUtil} to access the score point local service.
	 */

	/**
	 * Adds the score point to the database. Also notifies the appropriate model listeners.
	 *
	 * @param scorePoint the score point
	 * @return the score point that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ScorePoint addScorePoint(ScorePoint scorePoint)
		throws SystemException {
		scorePoint.setNew(true);

		return scorePointPersistence.update(scorePoint);
	}

	/**
	 * Creates a new score point with the primary key. Does not add the score point to the database.
	 *
	 * @param scorePointId the primary key for the new score point
	 * @return the new score point
	 */
	@Override
	public ScorePoint createScorePoint(long scorePointId) {
		return scorePointPersistence.create(scorePointId);
	}

	/**
	 * Deletes the score point with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scorePointId the primary key of the score point
	 * @return the score point that was removed
	 * @throws PortalException if a score point with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ScorePoint deleteScorePoint(long scorePointId)
		throws PortalException, SystemException {
		return scorePointPersistence.remove(scorePointId);
	}

	/**
	 * Deletes the score point from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scorePoint the score point
	 * @return the score point that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ScorePoint deleteScorePoint(ScorePoint scorePoint)
		throws SystemException {
		return scorePointPersistence.remove(scorePoint);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ScorePoint.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return scorePointPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.score.points.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return scorePointPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.score.points.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return scorePointPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return scorePointPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return scorePointPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ScorePoint fetchScorePoint(long scorePointId)
		throws SystemException {
		return scorePointPersistence.fetchByPrimaryKey(scorePointId);
	}

	/**
	 * Returns the score point with the matching UUID and company.
	 *
	 * @param uuid the score point's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching score point, or <code>null</code> if a matching score point could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScorePoint fetchScorePointByUuidAndCompanyId(String uuid,
		long companyId) throws SystemException {
		return scorePointPersistence.fetchByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the score point with the primary key.
	 *
	 * @param scorePointId the primary key of the score point
	 * @return the score point
	 * @throws PortalException if a score point with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScorePoint getScorePoint(long scorePointId)
		throws PortalException, SystemException {
		return scorePointPersistence.findByPrimaryKey(scorePointId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return scorePointPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the score point with the matching UUID and company.
	 *
	 * @param uuid the score point's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching score point
	 * @throws PortalException if a matching score point could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScorePoint getScorePointByUuidAndCompanyId(String uuid,
		long companyId) throws PortalException, SystemException {
		return scorePointPersistence.findByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns a range of all the score points.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.score.points.model.impl.ScorePointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of score points
	 * @param end the upper bound of the range of score points (not inclusive)
	 * @return the range of score points
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScorePoint> getScorePoints(int start, int end)
		throws SystemException {
		return scorePointPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of score points.
	 *
	 * @return the number of score points
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getScorePointsCount() throws SystemException {
		return scorePointPersistence.countAll();
	}

	/**
	 * Updates the score point in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param scorePoint the score point
	 * @return the score point that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ScorePoint updateScorePoint(ScorePoint scorePoint)
		throws SystemException {
		return scorePointPersistence.update(scorePoint);
	}

	/**
	 * Returns the score point local service.
	 *
	 * @return the score point local service
	 */
	public com.liferay.content.targeting.rule.score.points.service.ScorePointLocalService getScorePointLocalService() {
		return scorePointLocalService;
	}

	/**
	 * Sets the score point local service.
	 *
	 * @param scorePointLocalService the score point local service
	 */
	public void setScorePointLocalService(
		com.liferay.content.targeting.rule.score.points.service.ScorePointLocalService scorePointLocalService) {
		this.scorePointLocalService = scorePointLocalService;
	}

	/**
	 * Returns the score point remote service.
	 *
	 * @return the score point remote service
	 */
	public com.liferay.content.targeting.rule.score.points.service.ScorePointService getScorePointService() {
		return scorePointService;
	}

	/**
	 * Sets the score point remote service.
	 *
	 * @param scorePointService the score point remote service
	 */
	public void setScorePointService(
		com.liferay.content.targeting.rule.score.points.service.ScorePointService scorePointService) {
		this.scorePointService = scorePointService;
	}

	/**
	 * Returns the score point persistence.
	 *
	 * @return the score point persistence
	 */
	public ScorePointPersistence getScorePointPersistence() {
		return scorePointPersistence;
	}

	/**
	 * Sets the score point persistence.
	 *
	 * @param scorePointPersistence the score point persistence
	 */
	public void setScorePointPersistence(
		ScorePointPersistence scorePointPersistence) {
		this.scorePointPersistence = scorePointPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.liferay.content.targeting.rule.score.points.model.ScorePoint",
			scorePointLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.content.targeting.rule.score.points.model.ScorePoint");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return ScorePoint.class;
	}

	protected String getModelClassName() {
		return ScorePoint.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = scorePointPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.content.targeting.rule.score.points.service.ScorePointLocalService.class)
	protected com.liferay.content.targeting.rule.score.points.service.ScorePointLocalService scorePointLocalService;
	@BeanReference(type = com.liferay.content.targeting.rule.score.points.service.ScorePointService.class)
	protected com.liferay.content.targeting.rule.score.points.service.ScorePointService scorePointService;
	@BeanReference(type = ScorePointPersistence.class)
	protected ScorePointPersistence scorePointPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ScorePointLocalServiceClpInvoker _clpInvoker = new ScorePointLocalServiceClpInvoker();
}