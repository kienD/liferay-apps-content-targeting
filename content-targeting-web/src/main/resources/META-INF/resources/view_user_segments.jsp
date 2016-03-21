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
ContentTargetingViewUserSegmentDisplayContext contentTargetingViewUserSegmentDisplayContext = new ContentTargetingViewUserSegmentDisplayContext(liferayPortletRequest, liferayPortletResponse);
%>

<liferay-ui:error key="com.liferay.content.targeting.exception.UsedUserSegmentException">
	<liferay-ui:message key="the-following-user-segments" />

	<ul>

		<%
		List<UserSegment> usedUserSegments = (List<UserSegment>)SessionMessages.get(request, "usedUserSegments");

		for (UserSegment userSegment : usedUserSegments) {
		%>

			<li><%= userSegment.getName(locale) %></li>

		<%
		}
		%>

	</ul>

	<liferay-ui:message key="cannot-be-deleted-because-they-are-used-in-the-following-campaigns" />

	<ul>

		<%
		for (Campaign campaign : ((UsedUserSegmentException)errorException).getCampaigns()) {
		%>

			<li><%= campaign.getName(locale) %></li>

		<%
		}
		%>

	</ul>
</liferay-ui:error>

<liferay-util:include page="/navigation_bar.jsp" servletContext="<%= application %>">
	<liferay-util:param name="searchEnabled" value="<%= String.valueOf(contentTargetingViewUserSegmentDisplayContext.isSearchEnabled()) %>" />
</liferay-util:include>

<liferay-frontend:management-bar
	disabled="<%= contentTargetingViewUserSegmentDisplayContext.isDisabledManagementBar() %>"
	includeCheckBox="<%= contentTargetingViewUserSegmentDisplayContext.isIncludeCheckBox() %>"
	searchContainerId="userSegments"
>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"list"} %>'
			portletURL="<%= contentTargetingViewUserSegmentDisplayContext.getPortletURL() %>"
			selectedDisplayStyle="<%= contentTargetingViewUserSegmentDisplayContext.getDisplayStyle() %>"
		/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%= new String[] {"all"} %>'
			portletURL="<%= contentTargetingViewUserSegmentDisplayContext.getPortletURL() %>"
		/>

		<liferay-frontend:management-bar-sort
			orderByCol="<%= contentTargetingViewUserSegmentDisplayContext.getOrderByCol() %>"
			orderByType="<%= contentTargetingViewUserSegmentDisplayContext.getOrderByType() %>"
			orderColumns='<%= new String[] {"modified-date"} %>'
			portletURL="<%= contentTargetingViewUserSegmentDisplayContext.getPortletURL() %>"
		/>
	</liferay-frontend:management-bar-filters>

	<c:if test="<%= contentTargetingViewUserSegmentDisplayContext.isIncludeCheckBox() %>">
		<liferay-frontend:management-bar-action-buttons>
			<liferay-frontend:management-bar-button href="javascript:;" icon="trash" id="deleteUserSegments" label="delete" />
		</liferay-frontend:management-bar-action-buttons>
	</c:if>
</liferay-frontend:management-bar>

<portlet:actionURL name="deleteUserSegment" var="deleteUserSegmentURL">
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>

<aui:form action="<%= deleteUserSegmentURL %>" cssClass="container-fluid-1280" name="fmUserSegment">
	<liferay-ui:search-container
		searchContainer="<%= contentTargetingViewUserSegmentDisplayContext.getUserSegmentSearchContainer() %>"
	>
		<liferay-ui:search-container-row
			className="com.liferay.content.targeting.model.UserSegment"
			keyProperty="userSegmentId"
			modelVar="userSegment"
		>
			<liferay-ui:search-container-column-text
				cssClass="text-strong"
				name="name"
				value="<%= userSegment.getName(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				name="description"
				value="<%= userSegment.getDescription(locale) %>"
			/>

			<liferay-ui:search-container-column-date
				name="modified-date"
				value="<%= userSegment.getModifiedDate() %>"
			/>

			<liferay-ui:search-container-column-jsp
				path="/user_segments_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
</aui:form>

<c:if test="<%= contentTargetingViewUserSegmentDisplayContext.showAddButton() %>">
	<portlet:renderURL var="addUserSegmentURL">
		<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_USER_SEGMENT %>" />
	</portlet:renderURL>

	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "add-user-segment") %>' url="<%= addUserSegmentURL.toString() %>" />
	</liferay-frontend:add-menu>
</c:if>

<c:if test="<%= contentTargetingViewUserSegmentDisplayContext.isIncludeCheckBox() %>">
	<aui:script>
		$('#<portlet:namespace />deleteUserSegments').on(
			'click',
			function(event) {
				if (confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this" />')) {
					submitForm(document.<portlet:namespace />fmUserSegment);
				}
			}
		);
	</aui:script>
</c:if>