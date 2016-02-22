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

<%@ include file="/html/init.jsp" %>

<%
RuleCategoriesRegistry ruleCategoriesRegistry = (RuleCategoriesRegistry)request.getAttribute("ruleCategoriesRegistry");

List<RuleTemplate> addedRuleTemplates = (List<RuleTemplate>)request.getAttribute("addedRuleTemplates");
List<RuleTemplate> ruleTemplates = (List<RuleTemplate>)request.getAttribute("ruleTemplates");

String cssHasItemsClass = "";

if (addedRuleTemplates.size() > 0) {
	cssHasItemsClass = "has-items";
}
%>

<liferay-ui:error
	key="com.liferay.content.targeting.exception.InvalidRulesException"
	message="there-is-an-error-in-one-of-your-rules"
/>

<liferay-portlet:actionURL
	name="updateUserSegment"
	var="addUserSegmentURL"
/>

<aui:form action="<%= addUserSegmentURL %>" method="post" name="fm" onSubmit="event.preventDefault(); saveFields();">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="userSegmentId" type="hidden" value="<%= String.valueOf(userSegmentId) %>" />
	<aui:input name="userSegmentRules" type="hidden" />
	<aui:input name="saveAndContinue" type="hidden" />

	<aui:model-context bean="<%= userSegment %>" model="<%= UserSegment.class %>" />

	<liferay-ui:error key="com.liferay.content.targeting.exception.InvalidNameException">
		<c:choose>
			<c:when test="<%= ((InvalidNameException)errorException).isEmpty() %>">
				<liferay-ui:message key="the-name-can-not-be-empty" />
			</c:when>
			<c:when test="<%= ((InvalidNameException)errorException).isDuplicated() %>">
				<liferay-ui:message key="this-name-is-already-in-use-please-choose-a-different-one" />
			</c:when>
			<c:otherwise>
				<liferay-ui:message key="please-enter-a-valid-name" />
			</c:otherwise>
		</c:choose>
	</liferay-ui:error>

	<aui:input name="name" />

	<aui:input name="description" />

	<aui:field-wrapper label="rules">
		<div class="component form-builder liferayctformbuilder property-builder yui3-widget" id="formBuilderBB">
			<div class="form-builder-content property-builder-content" id="formBuilderCB">
				<div class="tabbable">
					<div class="tabbable-content">
						<ul class="nav nav-tabs">
							<li class="active"><a href="javascript:;">Add node</a></li>
							<li><a href="javascript:;">Settings</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane">
								<div class="hide panel-page-menu" id="formBuilderSB">
									<div class="form-builder-search-panels">
										<i class="icon-search"></i>

										<div class="search-panels-bar">
											<aui:input
												cssClass="search-panels-input search-query"
												label=""
												name="searchPanel"
												type="text"
											/>
										</div>
									</div>
								</div>

								<ul class="clearfix form-builder-fields-container property-builder-fields-container">

									<%
									for (RuleTemplate template : ruleTemplates) {
										Rule rule = template.getRule();
										String templateKey = template.getTemplateKey();
										RuleCategory ruleCategory = ruleCategoriesRegistry.getRuleCategory(rule.getRuleCategoryKey());
									%>

										<li class="form-builder-field hide property-builder-field" data-categorydescription="<%= ruleCategory.getDescription(locale) %>" data-categoryicon="<%= ruleCategory.getIcon() %>" data-categorykey="<%= ruleCategory.getCategoryKey() %>" data-categoryname="<%= ruleCategory.getName(locale) %>" data-icon="<%= rule.getIcon() %>" data-key="<%= templateKey %>" data-template="<%= template.getTemplate() %>" data-unique="<%= !rule.isInstantiable() %>">
											<span class="property-builder-field-icon icon <%= rule.getIcon() %>"></span>
											<div class="property-builder-field-label">
												<div class="row">
													<div class="field-title"><%= rule.getName(locale) %></div>
													<div class="field-description"><%= rule.getDescription(locale) %></div>
													<div class="field-short-description"><%= rule.getShortDescription(locale) %></div>
												</div>
											</div>
										</li>

									<%
									}
									%>

								</ul>
							</div>
							<div class="tab-pane"></div>
						</div>
					</div>
				</div>

				<div class="form-builder-content-container property-builder-content-container">
					<div class="property-builder-canvas form-builder-canvas <%= cssHasItemsClass %>">
						<div class="alert alert-info alert-no-items">
							<liferay-ui:message key="drag-rules-here-to-configure-this-user-segment" />
						</div>

						<div class="form-builder-drop-container property-builder-drop-container">

							<%
							for (RuleTemplate template : addedRuleTemplates) {
								Rule rule = template.getRule();
								String templateKey = template.getTemplateKey();
							%>

								<div class="component form-builder-field hide widget yui3-widget" data-icon="<%= rule.getIcon() %>" data-key="<%= templateKey %>" data-template="<%= template.getTemplate() %>" data-unique="<%= !rule.isInstantiable() %>">
									<div>
										<div>
											<div class="field-header">
												<div class="field-icon"><i class="<%= rule.getIcon() %>"></i></div>
												<div class="field-info row">
													<div class="field-title"><%= rule.getName(locale) %></div>
													<div class="field-description"><%= rule.getDescription(locale) %></div>
													<div class="field-short-description"><%= rule.getShortDescription(locale) %></div>
												</div>
											</div>
											<div class="field-editor">
											</div>
										</div>
									</div>
								</div>

							<%
							}
							%>

						</div>
					</div>
				</div>

			</div>
		</div>
	</aui:field-wrapper>

	<aui:button-row>
		<aui:button
			cssClass="control-button"
			type="submit"
		/>

		<aui:button
			cssClass="control-button"
			onClick="saveAndContinue();"
			value="save-and-continue"
		/>

		<aui:button
			cssClass="control-button"
			href="<%= redirect %>"
			type="cancel"
		/>
	</aui:button-row>
</aui:form>

<aui:script use="aui-toggler,liferay-ct-form-builder">
	var userSegmentBuilder = new A.LiferayCTFormBuilder(
		{
			boundingBox: '#formBuilderBB',
			contentBox: '#formBuilderCB',
			searchBox: '#formBuilderSB'
		}
	).render();

	saveAndContinue = function() {
		document.<portlet:namespace />fm.<portlet:namespace />userSegmentRules.value = userSegmentBuilder.exportAsJSON();

		A.one('#<portlet:namespace />saveAndContinue').val('true');

		submitForm(document.<portlet:namespace />fm);
	};

	saveFields = function() {
		document.<portlet:namespace />fm.<portlet:namespace />userSegmentRules.value = userSegmentBuilder.exportAsJSON();

		A.one('#<portlet:namespace />saveAndContinue').val('false');

		submitForm(document.<portlet:namespace />fm);
	};
</aui:script>

<liferay-util:include page="/html/macros/close_confirm.jsp" servletContext="<%= application %>">
	<liferay-util:param name="confirmMessage" value="leaving-this-window-deletes-all-unsaved-data" />
	<liferay-util:param name="controlCssClasses" value="control-button,tab" />
</liferay-util:include>