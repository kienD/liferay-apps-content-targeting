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

package com.liferay.content.targeting.web.portlet.action;

import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.content.targeting.util.PortletKeys;
import com.liferay.content.targeting.web.display.context.ContentTargetingViewCampaignDisplayContext;
import com.liferay.content.targeting.web.portlet.ContentTargetingMVCCommand;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jürgen Kappler
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + PortletKeys.CT_ADMIN,
		"mvc.command.name=" + ContentTargetingMVCCommand.VIEW_CAMPAIGN
	},
	service = MVCRenderCommand.class
)
public class ViewCampaignMVCRenderCommand extends BaseMVCRenderCommand {

	@Override
	public String doRender(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		ContentTargetingViewCampaignDisplayContext
			contentTargetingViewCampaignDisplayContext =
				new ContentTargetingViewCampaignDisplayContext(
					(LiferayPortletRequest)renderRequest,
					(LiferayPortletResponse)renderResponse,
					_userSegmentLocalService);

		renderRequest.setAttribute(
			"contentTargetingViewCampaignDisplayContext",
			contentTargetingViewCampaignDisplayContext);

		return "/view_campaign.jsp";
	}

	@Reference(unbind = "-")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ViewCampaignMVCRenderCommand.class);

	private UserSegmentLocalService _userSegmentLocalService;

}