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

package com.liferay.content.targeting.report.campaign.tracking.action.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotalModel;
import com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotalSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CTActionTotal service. Represents a row in the &quot;CT_CTA_CTActionTotal&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CTActionTotalModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CTActionTotalImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTActionTotalImpl
 * @see CTActionTotal
 * @see CTActionTotalModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CTActionTotalModelImpl extends BaseModelImpl<CTActionTotal>
	implements CTActionTotalModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a c t action total model instance should use the {@link CTActionTotal} interface instead.
	 */
	public static final String TABLE_NAME = "CT_CTA_CTActionTotal";
	public static final Object[][] TABLE_COLUMNS = {
			{ "CTActionTotalId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "campaignId", Types.BIGINT },
			{ "reportInstanceId", Types.BIGINT },
			{ "alias_", Types.VARCHAR },
			{ "referrerClassNameId", Types.BIGINT },
			{ "referrerClassPK", Types.BIGINT },
			{ "elementId", Types.VARCHAR },
			{ "eventType", Types.VARCHAR },
			{ "count", Types.INTEGER },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("CTActionTotalId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("campaignId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("reportInstanceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("alias_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("referrerClassNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("referrerClassPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("elementId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("eventType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("count", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table CT_CTA_CTActionTotal (CTActionTotalId LONG not null primary key,companyId LONG,campaignId LONG,reportInstanceId LONG,alias_ VARCHAR(75) null,referrerClassNameId LONG,referrerClassPK LONG,elementId VARCHAR(75) null,eventType VARCHAR(75) null,count INTEGER,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table CT_CTA_CTActionTotal";
	public static final String ORDER_BY_JPQL = " ORDER BY ctActionTotal.modifiedDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY CT_CTA_CTActionTotal.modifiedDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.content.targeting.report.campaign.tracking.action.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.content.targeting.report.campaign.tracking.action.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.content.targeting.report.campaign.tracking.action.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal"),
			true);
	public static final long CAMPAIGNID_COLUMN_BITMASK = 1L;
	public static final long ELEMENTID_COLUMN_BITMASK = 2L;
	public static final long EVENTTYPE_COLUMN_BITMASK = 4L;
	public static final long MODIFIEDDATE_COLUMN_BITMASK = 8L;
	public static final long REFERRERCLASSNAMEID_COLUMN_BITMASK = 16L;
	public static final long REFERRERCLASSPK_COLUMN_BITMASK = 32L;
	public static final long REPORTINSTANCEID_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CTActionTotal toModel(CTActionTotalSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CTActionTotal model = new CTActionTotalImpl();

		model.setCTActionTotalId(soapModel.getCTActionTotalId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setCampaignId(soapModel.getCampaignId());
		model.setReportInstanceId(soapModel.getReportInstanceId());
		model.setAlias(soapModel.getAlias());
		model.setReferrerClassNameId(soapModel.getReferrerClassNameId());
		model.setReferrerClassPK(soapModel.getReferrerClassPK());
		model.setElementId(soapModel.getElementId());
		model.setEventType(soapModel.getEventType());
		model.setCount(soapModel.getCount());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CTActionTotal> toModels(CTActionTotalSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CTActionTotal> models = new ArrayList<CTActionTotal>(soapModels.length);

		for (CTActionTotalSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.content.targeting.report.campaign.tracking.action.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal"));

	public CTActionTotalModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _CTActionTotalId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCTActionTotalId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CTActionTotalId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CTActionTotal.class;
	}

	@Override
	public String getModelClassName() {
		return CTActionTotal.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("CTActionTotalId", getCTActionTotalId());
		attributes.put("companyId", getCompanyId());
		attributes.put("campaignId", getCampaignId());
		attributes.put("reportInstanceId", getReportInstanceId());
		attributes.put("alias", getAlias());
		attributes.put("referrerClassNameId", getReferrerClassNameId());
		attributes.put("referrerClassPK", getReferrerClassPK());
		attributes.put("elementId", getElementId());
		attributes.put("eventType", getEventType());
		attributes.put("count", getCount());
		attributes.put("modifiedDate", getModifiedDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long CTActionTotalId = (Long)attributes.get("CTActionTotalId");

		if (CTActionTotalId != null) {
			setCTActionTotalId(CTActionTotalId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		Long reportInstanceId = (Long)attributes.get("reportInstanceId");

		if (reportInstanceId != null) {
			setReportInstanceId(reportInstanceId);
		}

		String alias = (String)attributes.get("alias");

		if (alias != null) {
			setAlias(alias);
		}

		Long referrerClassNameId = (Long)attributes.get("referrerClassNameId");

		if (referrerClassNameId != null) {
			setReferrerClassNameId(referrerClassNameId);
		}

		Long referrerClassPK = (Long)attributes.get("referrerClassPK");

		if (referrerClassPK != null) {
			setReferrerClassPK(referrerClassPK);
		}

		String elementId = (String)attributes.get("elementId");

		if (elementId != null) {
			setElementId(elementId);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		Integer count = (Integer)attributes.get("count");

		if (count != null) {
			setCount(count);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@JSON
	@Override
	public long getCTActionTotalId() {
		return _CTActionTotalId;
	}

	@Override
	public void setCTActionTotalId(long CTActionTotalId) {
		_CTActionTotalId = CTActionTotalId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getCampaignId() {
		return _campaignId;
	}

	@Override
	public void setCampaignId(long campaignId) {
		_columnBitmask |= CAMPAIGNID_COLUMN_BITMASK;

		if (!_setOriginalCampaignId) {
			_setOriginalCampaignId = true;

			_originalCampaignId = _campaignId;
		}

		_campaignId = campaignId;
	}

	public long getOriginalCampaignId() {
		return _originalCampaignId;
	}

	@JSON
	@Override
	public long getReportInstanceId() {
		return _reportInstanceId;
	}

	@Override
	public void setReportInstanceId(long reportInstanceId) {
		_columnBitmask |= REPORTINSTANCEID_COLUMN_BITMASK;

		if (!_setOriginalReportInstanceId) {
			_setOriginalReportInstanceId = true;

			_originalReportInstanceId = _reportInstanceId;
		}

		_reportInstanceId = reportInstanceId;
	}

	public long getOriginalReportInstanceId() {
		return _originalReportInstanceId;
	}

	@JSON
	@Override
	public String getAlias() {
		if (_alias == null) {
			return StringPool.BLANK;
		}
		else {
			return _alias;
		}
	}

	@Override
	public void setAlias(String alias) {
		_alias = alias;
	}

	@JSON
	@Override
	public long getReferrerClassNameId() {
		return _referrerClassNameId;
	}

	@Override
	public void setReferrerClassNameId(long referrerClassNameId) {
		_columnBitmask |= REFERRERCLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalReferrerClassNameId) {
			_setOriginalReferrerClassNameId = true;

			_originalReferrerClassNameId = _referrerClassNameId;
		}

		_referrerClassNameId = referrerClassNameId;
	}

	public long getOriginalReferrerClassNameId() {
		return _originalReferrerClassNameId;
	}

	@JSON
	@Override
	public long getReferrerClassPK() {
		return _referrerClassPK;
	}

	@Override
	public void setReferrerClassPK(long referrerClassPK) {
		_columnBitmask |= REFERRERCLASSPK_COLUMN_BITMASK;

		if (!_setOriginalReferrerClassPK) {
			_setOriginalReferrerClassPK = true;

			_originalReferrerClassPK = _referrerClassPK;
		}

		_referrerClassPK = referrerClassPK;
	}

	public long getOriginalReferrerClassPK() {
		return _originalReferrerClassPK;
	}

	@JSON
	@Override
	public String getElementId() {
		if (_elementId == null) {
			return StringPool.BLANK;
		}
		else {
			return _elementId;
		}
	}

	@Override
	public void setElementId(String elementId) {
		_columnBitmask |= ELEMENTID_COLUMN_BITMASK;

		if (_originalElementId == null) {
			_originalElementId = _elementId;
		}

		_elementId = elementId;
	}

	public String getOriginalElementId() {
		return GetterUtil.getString(_originalElementId);
	}

	@JSON
	@Override
	public String getEventType() {
		if (_eventType == null) {
			return StringPool.BLANK;
		}
		else {
			return _eventType;
		}
	}

	@Override
	public void setEventType(String eventType) {
		_columnBitmask |= EVENTTYPE_COLUMN_BITMASK;

		if (_originalEventType == null) {
			_originalEventType = _eventType;
		}

		_eventType = eventType;
	}

	public String getOriginalEventType() {
		return GetterUtil.getString(_originalEventType);
	}

	@JSON
	@Override
	public int getCount() {
		return _count;
	}

	@Override
	public void setCount(int count) {
		_count = count;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_columnBitmask = -1L;

		if (_originalModifiedDate == null) {
			_originalModifiedDate = _modifiedDate;
		}

		_modifiedDate = modifiedDate;
	}

	public Date getOriginalModifiedDate() {
		return _originalModifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CTActionTotal.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CTActionTotal toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CTActionTotal)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CTActionTotalImpl ctActionTotalImpl = new CTActionTotalImpl();

		ctActionTotalImpl.setCTActionTotalId(getCTActionTotalId());
		ctActionTotalImpl.setCompanyId(getCompanyId());
		ctActionTotalImpl.setCampaignId(getCampaignId());
		ctActionTotalImpl.setReportInstanceId(getReportInstanceId());
		ctActionTotalImpl.setAlias(getAlias());
		ctActionTotalImpl.setReferrerClassNameId(getReferrerClassNameId());
		ctActionTotalImpl.setReferrerClassPK(getReferrerClassPK());
		ctActionTotalImpl.setElementId(getElementId());
		ctActionTotalImpl.setEventType(getEventType());
		ctActionTotalImpl.setCount(getCount());
		ctActionTotalImpl.setModifiedDate(getModifiedDate());

		ctActionTotalImpl.resetOriginalValues();

		return ctActionTotalImpl;
	}

	@Override
	public int compareTo(CTActionTotal ctActionTotal) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				ctActionTotal.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CTActionTotal)) {
			return false;
		}

		CTActionTotal ctActionTotal = (CTActionTotal)obj;

		long primaryKey = ctActionTotal.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CTActionTotalModelImpl ctActionTotalModelImpl = this;

		ctActionTotalModelImpl._originalCampaignId = ctActionTotalModelImpl._campaignId;

		ctActionTotalModelImpl._setOriginalCampaignId = false;

		ctActionTotalModelImpl._originalReportInstanceId = ctActionTotalModelImpl._reportInstanceId;

		ctActionTotalModelImpl._setOriginalReportInstanceId = false;

		ctActionTotalModelImpl._originalReferrerClassNameId = ctActionTotalModelImpl._referrerClassNameId;

		ctActionTotalModelImpl._setOriginalReferrerClassNameId = false;

		ctActionTotalModelImpl._originalReferrerClassPK = ctActionTotalModelImpl._referrerClassPK;

		ctActionTotalModelImpl._setOriginalReferrerClassPK = false;

		ctActionTotalModelImpl._originalElementId = ctActionTotalModelImpl._elementId;

		ctActionTotalModelImpl._originalEventType = ctActionTotalModelImpl._eventType;

		ctActionTotalModelImpl._originalModifiedDate = ctActionTotalModelImpl._modifiedDate;

		ctActionTotalModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CTActionTotal> toCacheModel() {
		CTActionTotalCacheModel ctActionTotalCacheModel = new CTActionTotalCacheModel();

		ctActionTotalCacheModel.CTActionTotalId = getCTActionTotalId();

		ctActionTotalCacheModel.companyId = getCompanyId();

		ctActionTotalCacheModel.campaignId = getCampaignId();

		ctActionTotalCacheModel.reportInstanceId = getReportInstanceId();

		ctActionTotalCacheModel.alias = getAlias();

		String alias = ctActionTotalCacheModel.alias;

		if ((alias != null) && (alias.length() == 0)) {
			ctActionTotalCacheModel.alias = null;
		}

		ctActionTotalCacheModel.referrerClassNameId = getReferrerClassNameId();

		ctActionTotalCacheModel.referrerClassPK = getReferrerClassPK();

		ctActionTotalCacheModel.elementId = getElementId();

		String elementId = ctActionTotalCacheModel.elementId;

		if ((elementId != null) && (elementId.length() == 0)) {
			ctActionTotalCacheModel.elementId = null;
		}

		ctActionTotalCacheModel.eventType = getEventType();

		String eventType = ctActionTotalCacheModel.eventType;

		if ((eventType != null) && (eventType.length() == 0)) {
			ctActionTotalCacheModel.eventType = null;
		}

		ctActionTotalCacheModel.count = getCount();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ctActionTotalCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ctActionTotalCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return ctActionTotalCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{CTActionTotalId=");
		sb.append(getCTActionTotalId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append(", reportInstanceId=");
		sb.append(getReportInstanceId());
		sb.append(", alias=");
		sb.append(getAlias());
		sb.append(", referrerClassNameId=");
		sb.append(getReferrerClassNameId());
		sb.append(", referrerClassPK=");
		sb.append(getReferrerClassPK());
		sb.append(", elementId=");
		sb.append(getElementId());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append(", count=");
		sb.append(getCount());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.content.targeting.report.campaign.tracking.action.model.CTActionTotal");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CTActionTotalId</column-name><column-value><![CDATA[");
		sb.append(getCTActionTotalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportInstanceId</column-name><column-value><![CDATA[");
		sb.append(getReportInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>alias</column-name><column-value><![CDATA[");
		sb.append(getAlias());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referrerClassNameId</column-name><column-value><![CDATA[");
		sb.append(getReferrerClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referrerClassPK</column-name><column-value><![CDATA[");
		sb.append(getReferrerClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>elementId</column-name><column-value><![CDATA[");
		sb.append(getElementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventType</column-name><column-value><![CDATA[");
		sb.append(getEventType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>count</column-name><column-value><![CDATA[");
		sb.append(getCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CTActionTotal.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CTActionTotal.class
		};
	private long _CTActionTotalId;
	private long _companyId;
	private long _campaignId;
	private long _originalCampaignId;
	private boolean _setOriginalCampaignId;
	private long _reportInstanceId;
	private long _originalReportInstanceId;
	private boolean _setOriginalReportInstanceId;
	private String _alias;
	private long _referrerClassNameId;
	private long _originalReferrerClassNameId;
	private boolean _setOriginalReferrerClassNameId;
	private long _referrerClassPK;
	private long _originalReferrerClassPK;
	private boolean _setOriginalReferrerClassPK;
	private String _elementId;
	private String _originalElementId;
	private String _eventType;
	private String _originalEventType;
	private int _count;
	private Date _modifiedDate;
	private Date _originalModifiedDate;
	private long _columnBitmask;
	private CTActionTotal _escapedModel;
}