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

package com.liferay.content.targeting.report.campaign.tracking.action.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CTAction service. Represents a row in the &quot;CT_CTA_CTAction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTAction
 * @see com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionImpl
 * @see com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl
 * @generated
 */
@ProviderType
public interface CTActionModel extends BaseModel<CTAction>, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a c t action model instance should use the {@link CTAction} interface instead.
	 */

	/**
	 * Returns the primary key of this c t action.
	 *
	 * @return the primary key of this c t action
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this c t action.
	 *
	 * @param primaryKey the primary key of this c t action
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the c t action ID of this c t action.
	 *
	 * @return the c t action ID of this c t action
	 */
	public long getCTActionId();

	/**
	 * Sets the c t action ID of this c t action.
	 *
	 * @param CTActionId the c t action ID of this c t action
	 */
	public void setCTActionId(long CTActionId);

	/**
	 * Returns the company ID of this c t action.
	 *
	 * @return the company ID of this c t action
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this c t action.
	 *
	 * @param companyId the company ID of this c t action
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the campaign ID of this c t action.
	 *
	 * @return the campaign ID of this c t action
	 */
	public long getCampaignId();

	/**
	 * Sets the campaign ID of this c t action.
	 *
	 * @param campaignId the campaign ID of this c t action
	 */
	public void setCampaignId(long campaignId);

	/**
	 * Returns the report instance ID of this c t action.
	 *
	 * @return the report instance ID of this c t action
	 */
	public long getReportInstanceId();

	/**
	 * Sets the report instance ID of this c t action.
	 *
	 * @param reportInstanceId the report instance ID of this c t action
	 */
	public void setReportInstanceId(long reportInstanceId);

	/**
	 * Returns the user segment ID of this c t action.
	 *
	 * @return the user segment ID of this c t action
	 */
	public long getUserSegmentId();

	/**
	 * Sets the user segment ID of this c t action.
	 *
	 * @param userSegmentId the user segment ID of this c t action
	 */
	public void setUserSegmentId(long userSegmentId);

	/**
	 * Returns the alias of this c t action.
	 *
	 * @return the alias of this c t action
	 */
	@AutoEscape
	public String getAlias();

	/**
	 * Sets the alias of this c t action.
	 *
	 * @param alias the alias of this c t action
	 */
	public void setAlias(String alias);

	/**
	 * Returns the referrer class name of this c t action.
	 *
	 * @return the referrer class name of this c t action
	 */
	@AutoEscape
	public String getReferrerClassName();

	/**
	 * Sets the referrer class name of this c t action.
	 *
	 * @param referrerClassName the referrer class name of this c t action
	 */
	public void setReferrerClassName(String referrerClassName);

	/**
	 * Returns the referrer class p k of this c t action.
	 *
	 * @return the referrer class p k of this c t action
	 */
	public long getReferrerClassPK();

	/**
	 * Sets the referrer class p k of this c t action.
	 *
	 * @param referrerClassPK the referrer class p k of this c t action
	 */
	public void setReferrerClassPK(long referrerClassPK);

	/**
	 * Returns the element ID of this c t action.
	 *
	 * @return the element ID of this c t action
	 */
	@AutoEscape
	public String getElementId();

	/**
	 * Sets the element ID of this c t action.
	 *
	 * @param elementId the element ID of this c t action
	 */
	public void setElementId(String elementId);

	/**
	 * Returns the event type of this c t action.
	 *
	 * @return the event type of this c t action
	 */
	@AutoEscape
	public String getEventType();

	/**
	 * Sets the event type of this c t action.
	 *
	 * @param eventType the event type of this c t action
	 */
	public void setEventType(String eventType);

	/**
	 * Returns the count of this c t action.
	 *
	 * @return the count of this c t action
	 */
	public int getCount();

	/**
	 * Sets the count of this c t action.
	 *
	 * @param count the count of this c t action
	 */
	public void setCount(int count);

	/**
	 * Returns the modified date of this c t action.
	 *
	 * @return the modified date of this c t action
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this c t action.
	 *
	 * @param modifiedDate the modified date of this c t action
	 */
	public void setModifiedDate(Date modifiedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction ctAction);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction> toCacheModel();

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction toEscapedModel();

	@Override
	public com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}