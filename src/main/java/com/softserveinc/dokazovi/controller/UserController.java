package com.softserveinc.dokazovi.controller;

import com.softserveinc.dokazovi.annotations.ApiPageable;
import com.softserveinc.dokazovi.dto.user.UserDTO;
import com.softserveinc.dokazovi.pojo.UserSearchCriteria;
import com.softserveinc.dokazovi.security.UserPrincipal;
import com.softserveinc.dokazovi.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static com.softserveinc.dokazovi.controller.EndPoints.USER;
import static com.softserveinc.dokazovi.controller.EndPoints.USER_ALL_EXPERTS;
import static com.softserveinc.dokazovi.controller.EndPoints.USER_GET_CURRENT_USER;
import static com.softserveinc.dokazovi.controller.EndPoints.USER_GET_USER_BY_ID;
import static com.softserveinc.dokazovi.controller.EndPoints.USER_RANDOM_EXPERTS;

/**
 * The User controller is responsible for handling requests for users.
 */

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	/**
	 * Gets preview of random experts,
	 * filtered by directions.
	 * Default 12 max per page.
	 *
	 * @param pageable interface for pagination information
	 * @param directions direction id
	 * @return page with found posts and 'OK' httpStatus
	 */
	@GetMapping(USER_RANDOM_EXPERTS)
	@ApiPageable
	@ApiOperation(value = "Get preview of random experts, filtered by directions. Default 12 max per page.")
	public ResponseEntity<Page<UserDTO>> getRandomExpertPreview(
			@PageableDefault(size = 12) Pageable pageable,
			@ApiParam(value = "Multiple comma-separated direction IDs, e.g. ?directions=1,2,3,4", type = "string")
			@RequestParam(required = false) Set<Integer> directions) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.findRandomExpertPreview(directions, pageable));
	}

	/**
	 * Gets all experts depending on the parameters coming through the request,
	 * ordered by relevance.
	 * Default 6 max per page.
	 *
	 * @param pageable interface for pagination information
	 * @param userSearchCriteria binds request parameters to an object
	 * @return page with found experts and 'OK' httpStatus
	 */
	@GetMapping(USER_ALL_EXPERTS)
	@ApiPageable
	@ApiOperation(value = "Get experts ordered by name, then filtered by directions and/or regions."
			+ " Default 6 per page.")
	public ResponseEntity<Page<UserDTO>> getAllExpertsByDirectionsAndByRegionsOrderedByRelevance(
			@PageableDefault(size = 6) Pageable pageable, UserSearchCriteria userSearchCriteria) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.findAllExperts(userSearchCriteria, pageable));
	}

	/**
	 * Gets the user by its id.
	 * Checks if the user exists. If no - returns HttpStatus 'NOT FOUND'.
	 *
	 * @param userId id of user that we want to get
	 * @return found user and HttpStatus 'OK'
	 */
	@GetMapping(USER_GET_USER_BY_ID)
	@ApiOperation(value = "Get expert by Id, as a path variable.")
	public ResponseEntity<UserDTO> getExpertById(@PathVariable("userId") Integer userId) {
		UserDTO userDTO = userService.findExpertById(userId);
		return ResponseEntity
				.status((userDTO != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND)
				.body(userDTO);
	}

	/**
	 * Gets current user.
	 * Checks if userPrincipal exists via findExpertById method.
	 * If no - returns HttpStatus 'NOT FOUND'.
	 *
	 * @param userPrincipal id of user that we want to get
	 * @return found user and HttpStatus 'OK'
	 */
	@GetMapping(USER_GET_CURRENT_USER)
	@ApiOperation(value = "Get current user",
			authorizations = {@Authorization(value = "Authorization")})
	public ResponseEntity<UserDTO> getCurrentUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
		UserDTO userDTO = userService.findExpertById(userPrincipal.getId());
		return ResponseEntity
				.status((userDTO != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND)
				.body(userDTO);
	}
}
