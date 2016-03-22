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

package com.liferay.content.targeting.analytics.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.analytics.model.AnalyticsReferrer;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for AnalyticsReferrer. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsReferrerLocalServiceUtil
 * @see com.liferay.content.targeting.analytics.service.base.AnalyticsReferrerLocalServiceBaseImpl
 * @see com.liferay.content.targeting.analytics.service.impl.AnalyticsReferrerLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AnalyticsReferrerLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnalyticsReferrerLocalServiceUtil} to access the analytics referrer local service. Add custom service methods to {@link com.liferay.content.targeting.analytics.service.impl.AnalyticsReferrerLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public AnalyticsReferrer addAnalyticsReferrer(long analyticsEventId,
		java.lang.String referrerClassName, long referrerClassPK)
		throws PortalException;

	/**
	* Adds the analytics referrer to the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsReferrer the analytics referrer
	* @return the analytics referrer that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public AnalyticsReferrer addAnalyticsReferrer(
		AnalyticsReferrer analyticsReferrer);

	/**
	* Creates a new analytics referrer with the primary key. Does not add the analytics referrer to the database.
	*
	* @param analyticsReferrerId the primary key for the new analytics referrer
	* @return the new analytics referrer
	*/
	public AnalyticsReferrer createAnalyticsReferrer(long analyticsReferrerId);

	/**
	* Deletes the analytics referrer from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsReferrer the analytics referrer
	* @return the analytics referrer that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public AnalyticsReferrer deleteAnalyticsReferrer(
		AnalyticsReferrer analyticsReferrer);

	/**
	* Deletes the analytics referrer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param analyticsReferrerId the primary key of the analytics referrer
	* @return the analytics referrer that was removed
	* @throws PortalException if a analytics referrer with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public AnalyticsReferrer deleteAnalyticsReferrer(long analyticsReferrerId)
		throws PortalException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnalyticsReferrer fetchAnalyticsReferrer(long analyticsReferrerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	* Returns the analytics referrer with the primary key.
	*
	* @param analyticsReferrerId the primary key of the analytics referrer
	* @return the analytics referrer
	* @throws PortalException if a analytics referrer with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AnalyticsReferrer getAnalyticsReferrer(long analyticsReferrerId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnalyticsReferrerCount(long analyticsEventId,
		java.lang.String referrerClassName, long referrerClassPK);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnalyticsReferrerCount(long[] analyticsEventIds,
		java.lang.String referrerClassName, long classPK);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnalyticsReferrerCount(java.lang.String referrerClassName,
		long classPK);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnalyticsReferrer> getAnalyticsReferrers(long analyticsEventId);

	/**
	* Returns a range of all the analytics referrers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.analytics.model.impl.AnalyticsReferrerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of analytics referrers
	* @param end the upper bound of the range of analytics referrers (not inclusive)
	* @return the range of analytics referrers
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AnalyticsReferrer> getAnalyticsReferrers(int start, int end);

	/**
	* Returns the number of analytics referrers.
	*
	* @return the number of analytics referrers
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnalyticsReferrersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Updates the analytics referrer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param analyticsReferrer the analytics referrer
	* @return the analytics referrer that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public AnalyticsReferrer updateAnalyticsReferrer(
		AnalyticsReferrer analyticsReferrer);
}