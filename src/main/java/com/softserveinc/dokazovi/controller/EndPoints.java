package com.softserveinc.dokazovi.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Endpoints for all controllers that point the route to certain method or class.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EndPoints {

	public static final String VERSION = "/version";
	public static final String POST = "/post";
	public static final String POST_TYPE = "/type";
	public static final String POST_LATEST = "/latest-all";
	public static final String POST_LATEST_BY_POST_TYPES_AND_ORIGINS = "/latest";
	public static final String POST_IMPORTANT = "/important";
	public static final String POST_SET_IMPORTANT = "/set-important";
	public static final String POST_GET_POST_BY_ID = "/{postId}";
	public static final String POST_GET_POST_BY_AUTHOR_ID_AND_DIRECTIONS = "/by-authorid-and-directions";
	public static final String POST_ALL_POSTS = "/all-posts";
	public static final String USER = "/user";
	public static final String USER_RANDOM_EXPERTS = "/random-experts";
	public static final String USER_ALL_EXPERTS = "/all-experts";
	public static final String USER_GET_USER_BY_ID = "/{userId}";
	public static final String POST_GET_USER_BY_ID = "/{userId}";
	public static final String USER_GET_CURRENT_USER = "/me";
	public static final String TAG = "/tag";
	public static final String TAG_FIND_BY_VALUE = "/find-by-value";
	public static final String POST_LATEST_BY_DIRECTION = "/latest-by-direction";
	public static final String POST_LATEST_BY_EXPERT = "/latest-by-expert";
	public static final String POST_VIEW_COUNT = "/post-view-count";
	public static final String DIRECTION = "/direction";
	public static final String ORIGIN = "/origin";
	public static final String REGION = "/region";
	public static final String AUTH = "/auth";
	public static final String AUTH_VERIFICATION = "/verification";
	public static final String AUTH_LOGIN = "/login";
	public static final String AUTH_SIGNUP = "/signup";
	public static final String POST_TYPES = "/post-types";
	public static final String POST_TYPES_ALL_TYPES_BY_USER = "/{userId}";
	public static final String PLATFORM_INFORMATION = "/platform-information";
	public static final String PLATFORM_INFORMATION_BY_ID = "/{infoId}";
	public static final String POST_GET_BY_IMPORTANT_IMAGE = "/get-by-important-image";

	/**
	 * Method that adds slash after each endpoint while calling
	 *
	 * @param api endpoint route
	 * @return full endpoint route
	 */
	public static String openApi(String api) {
		return api + "/**";
	}
}
