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

package com.liferay.content.targeting.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.AttachedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the ReportInstance service. Represents a row in the &quot;CT_ReportInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.content.targeting.model.impl.ReportInstanceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.content.targeting.model.impl.ReportInstanceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReportInstance
 * @see com.liferay.content.targeting.model.impl.ReportInstanceImpl
 * @see com.liferay.content.targeting.model.impl.ReportInstanceModelImpl
 * @generated
 */
@ProviderType
public interface ReportInstanceModel extends AttachedModel,
	BaseModel<ReportInstance>, GroupedModel, LocalizedModel, ShardedModel,
	StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a report instance model instance should use the {@link ReportInstance} interface instead.
	 */

	/**
	 * Returns the primary key of this report instance.
	 *
	 * @return the primary key of this report instance
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this report instance.
	 *
	 * @param primaryKey the primary key of this report instance
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this report instance.
	 *
	 * @return the uuid of this report instance
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this report instance.
	 *
	 * @param uuid the uuid of this report instance
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the report instance ID of this report instance.
	 *
	 * @return the report instance ID of this report instance
	 */
	public long getReportInstanceId();

	/**
	 * Sets the report instance ID of this report instance.
	 *
	 * @param reportInstanceId the report instance ID of this report instance
	 */
	public void setReportInstanceId(long reportInstanceId);

	/**
	 * Returns the group ID of this report instance.
	 *
	 * @return the group ID of this report instance
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this report instance.
	 *
	 * @param groupId the group ID of this report instance
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this report instance.
	 *
	 * @return the company ID of this report instance
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this report instance.
	 *
	 * @param companyId the company ID of this report instance
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this report instance.
	 *
	 * @return the user ID of this report instance
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this report instance.
	 *
	 * @param userId the user ID of this report instance
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this report instance.
	 *
	 * @return the user uuid of this report instance
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this report instance.
	 *
	 * @param userUuid the user uuid of this report instance
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this report instance.
	 *
	 * @return the user name of this report instance
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this report instance.
	 *
	 * @param userName the user name of this report instance
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this report instance.
	 *
	 * @return the create date of this report instance
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this report instance.
	 *
	 * @param createDate the create date of this report instance
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this report instance.
	 *
	 * @return the modified date of this report instance
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this report instance.
	 *
	 * @param modifiedDate the modified date of this report instance
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the report key of this report instance.
	 *
	 * @return the report key of this report instance
	 */
	@AutoEscape
	public String getReportKey();

	/**
	 * Sets the report key of this report instance.
	 *
	 * @param reportKey the report key of this report instance
	 */
	public void setReportKey(String reportKey);

	/**
	 * Returns the name of this report instance.
	 *
	 * @return the name of this report instance
	 */
	public String getName();

	/**
	 * Returns the localized name of this report instance in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this report instance
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this report instance in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this report instance. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this report instance in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this report instance
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this report instance in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this report instance
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this report instance.
	 *
	 * @return the locales and localized names of this report instance
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this report instance.
	 *
	 * @param name the name of this report instance
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this report instance in the language.
	 *
	 * @param name the localized name of this report instance
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this report instance in the language, and sets the default locale.
	 *
	 * @param name the localized name of this report instance
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this report instance from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this report instance
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this report instance from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this report instance
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the description of this report instance.
	 *
	 * @return the description of this report instance
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this report instance in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this report instance
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this report instance in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this report instance. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this report instance in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this report instance
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this report instance in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this report instance
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this report instance.
	 *
	 * @return the locales and localized descriptions of this report instance
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this report instance.
	 *
	 * @param description the description of this report instance
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this report instance in the language.
	 *
	 * @param description the localized description of this report instance
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this report instance in the language, and sets the default locale.
	 *
	 * @param description the localized description of this report instance
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this report instance from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this report instance
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this report instance from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this report instance
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the fully qualified class name of this report instance.
	 *
	 * @return the fully qualified class name of this report instance
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this report instance.
	 *
	 * @return the class name ID of this report instance
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this report instance.
	 *
	 * @param classNameId the class name ID of this report instance
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class p k of this report instance.
	 *
	 * @return the class p k of this report instance
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class p k of this report instance.
	 *
	 * @param classPK the class p k of this report instance
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the type settings of this report instance.
	 *
	 * @return the type settings of this report instance
	 */
	@AutoEscape
	public String getTypeSettings();

	/**
	 * Sets the type settings of this report instance.
	 *
	 * @param typeSettings the type settings of this report instance
	 */
	public void setTypeSettings(String typeSettings);

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
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.liferay.content.targeting.model.ReportInstance reportInstance);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.content.targeting.model.ReportInstance> toCacheModel();

	@Override
	public com.liferay.content.targeting.model.ReportInstance toEscapedModel();

	@Override
	public com.liferay.content.targeting.model.ReportInstance toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}