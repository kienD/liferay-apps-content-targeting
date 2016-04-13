<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Campaign campaign = (Campaign)row.getObject();

int channelsCount = GetterUtil.getInteger(request.getAttribute("channelsCount"));

int reportsCount = GetterUtil.getInteger(request.getAttribute("reportsCount"));
%>

<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">
	<portlet:renderURL var="campaignSummaryURL">
		<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.VIEW_CAMPAIGN %>" />
		<portlet:param name="tabs1" value="summary" />
		<portlet:param name="campaignId" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
	</portlet:renderURL>

	<liferay-ui:icon
		message="summary"
		url="<%= campaignSummaryURL %>"
	/>

	<c:if test="<%= CampaignPermission.contains(permissionChecker, campaign, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editCampaignURL">
			<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_CAMPAIGN %>" />
			<portlet:param name="campaignId" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
		</portlet:renderURL>

		<liferay-ui:icon
			message="edit"
			url="<%= editCampaignURL %>"
		/>

		<c:if test="<%= channelsCount > 0 %>">
			<portlet:renderURL var="viewCampaignTacticsURL">
				<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.VIEW_TACTICS %>" />
				<portlet:param name="campaignId" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
			</portlet:renderURL>

			<liferay-ui:icon
				message="promotions"
				url="<%= viewCampaignTacticsURL %>"
			/>
		</c:if>
	</c:if>

	<c:if test="<%= CampaignPermission.contains(permissionChecker, campaign, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= Campaign.class.getName() %>"
			modelResourceDescription="<%= campaign.getName(locale) %>"
			resourcePrimKey="<%= String.valueOf(campaign.getCampaignId()) %>"
			var="permissionsEntryURL"
			windowState="<%= LiferayWindowState.POP_UP.toString() %>"
		/>

		<liferay-ui:icon
			message="permissions"
			url="<%= permissionsEntryURL %>"
			useDialog="<%= true %>"
		/>
	</c:if>

	<c:if test="<%= CampaignPermission.contains(permissionChecker, campaign, ActionKeys.DELETE) %>">
		<portlet:actionURL name="deleteCampaign" var="deleteCampaignURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="campaignId" value="<%= String.valueOf(campaign.getCampaignId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete
			url="<%= deleteCampaignURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>