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
String displayStyle = ParamUtil.getString(request, "displayStyle", "list");
String orderByCol = ParamUtil.getString(request, "orderByCol", "modified-date");
String orderByType = ParamUtil.getString(request, "orderByType", "asc");

boolean includeCheckBox = ContentTargetingPermission.contains(permissionChecker, scopeGroupId, ActionKeys.DELETE_USER_SEGMENT);

String keywords = ParamUtil.getString(request, "keywords");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", ContentTargetingPath.VIEW);
portletURL.setParameter("tabs1", "user-segments");

if (Validator.isNotNull(keywords)) {
	portletURL.setParameter("keywords", keywords);
}

SearchContainer userSegmentSearchContainer = new SearchContainer(renderRequest, PortletURLUtil.clone(portletURL, renderResponse), null, "no-user-segments-were-found");

userSegmentSearchContainer.setId("userSegments");
userSegmentSearchContainer.setRowChecker(new EmptyOnClickRowChecker(renderResponse));
userSegmentSearchContainer.setSearch(Validator.isNotNull(keywords));

boolean orderByAsc = false;

if (orderByType.equals("asc")) {
	orderByAsc = true;
}

OrderByComparator<UserSegment> orderByComparator = new UserSegmentModifiedDateComparator(orderByAsc);

userSegmentSearchContainer.setOrderByCol(orderByCol);
userSegmentSearchContainer.setOrderByComparator(orderByComparator);
userSegmentSearchContainer.setOrderByType(orderByType);

if (Validator.isNotNull(keywords)) {
	Sort sort = new Sort(Field.MODIFIED_DATE, Sort.LONG_TYPE, orderByAsc);

	BaseModelSearchResult<UserSegment> searchResults = UserSegmentLocalServiceUtil.searchUserSegments(scopeGroupId, keywords, userSegmentSearchContainer.getStart(), userSegmentSearchContainer.getEnd(), sort);

	userSegmentSearchContainer.setTotal(searchResults.getLength());
	userSegmentSearchContainer.setResults(searchResults.getBaseModels());
}
else {
	int total = UserSegmentLocalServiceUtil.getUserSegmentsCount(scopeGroupId);

	userSegmentSearchContainer.setTotal(total);

	List results = UserSegmentLocalServiceUtil.getUserSegments(scopeGroupId, userSegmentSearchContainer.getStart(), userSegmentSearchContainer.getEnd(), userSegmentSearchContainer.getOrderByComparator());

	userSegmentSearchContainer.setResults(results);
}

boolean isDisabledManagementBar = (userSegmentSearchContainer.getTotal() <= 0) && Validator.isNull(keywords);
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

<liferay-util:include page="/content_targeting/navigation_bar.jsp" servletContext="<%= application %>">
	<liferay-util:param name="searchEnabled" value="<%= String.valueOf(!isDisabledManagementBar) %>" />
</liferay-util:include>

<liferay-frontend:management-bar
	disabled="<%= isDisabledManagementBar %>"
	includeCheckBox="<%= includeCheckBox %>"
	searchContainerId="userSegments"
>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"list"} %>'
			portletURL="<%= PortletURLUtil.clone(portletURL, renderResponse) %>"
			selectedDisplayStyle="<%= displayStyle %>"
		/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%= new String[] {"all"} %>'
			portletURL="<%= PortletURLUtil.clone(portletURL, renderResponse) %>"
		/>

		<liferay-frontend:management-bar-sort
			orderByCol="<%= orderByCol %>"
			orderByType="<%= orderByType %>"
			orderColumns='<%= new String[] {"modified-date"} %>'
			portletURL="<%= PortletURLUtil.clone(portletURL, renderResponse) %>"
		/>
	</liferay-frontend:management-bar-filters>

	<c:if test="<%= includeCheckBox %>">
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
		searchContainer="<%= userSegmentSearchContainer %>"
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
				path="/content_targeting/user_segments_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
</aui:form>

<c:if test="<%= ContentTargetingPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_USER_SEGMENT) %>">
	<portlet:renderURL var="addUserSegmentURL">
		<portlet:param name="mvcRenderCommandName" value="<%= ContentTargetingMVCCommand.EDIT_USER_SEGMENT %>" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:renderURL>

	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(portletConfig.getResourceBundle(locale), "add-user-segment") %>' url="<%= addUserSegmentURL.toString() %>" />
	</liferay-frontend:add-menu>
</c:if>

<c:if test="<%= includeCheckBox %>">
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