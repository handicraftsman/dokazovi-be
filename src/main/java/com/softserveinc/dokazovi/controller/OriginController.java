package com.softserveinc.dokazovi.controller;

import com.softserveinc.dokazovi.dto.origin.OriginDTO;
import com.softserveinc.dokazovi.service.OriginService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static com.softserveinc.dokazovi.controller.EndPoints.ORIGIN;

/**
 * The Origin controller responsible for handling requests for getting all origins.
 */
@RestController
@RequestMapping(ORIGIN)
@RequiredArgsConstructor
public class OriginController {
	private final OriginService originService;

	/**
	 * This method will get all origins from database.
	 *
	 * @return list of all origins and 'OK' HttpStatus
	 */
	@GetMapping
	@ApiOperation(value = "Get all origins")
	public ResponseEntity<List<OriginDTO>> getAllOrigins() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(originService.findAllOrigins());
	}
}