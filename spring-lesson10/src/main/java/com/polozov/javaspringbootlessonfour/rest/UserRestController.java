package com.polozov.javaspringbootlessonfour.rest;

import com.polozov.javaspringbootlessonfour.dto.ProductDTO;
import com.polozov.javaspringbootlessonfour.dto.UserDTO;

import com.polozov.javaspringbootlessonfour.entities.User;
import com.polozov.javaspringbootlessonfour.mappers.ProductMapper;
import com.polozov.javaspringbootlessonfour.mappers.UserMapper;
import com.polozov.javaspringbootlessonfour.services.UserService;
import com.polozov.javaspringbootlessonfour.services.exceptions.NotFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User API", description = "API to manipulate user resources")
@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {

	private UserService service;

	@Autowired
	public void setService(UserService service) {
		this.service = service;
	}

	@GetMapping(path = "/{id}/id", produces = "application/json")
	public UserDTO findById(@PathVariable("id") Long id) {
		User user = service.findById(id).orElseThrow(NotFoundException::new);
		return saveUserDTO(user);
	}

	@GetMapping(path = "/list", produces = "application/json")
	public List<User> findAll() {
		return service.findAll();
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public User createUser(@RequestBody User user) {
		service.createOrUpdate(user);
		return user;
	}

	@PutMapping(consumes = "application/json", produces = "application/json")
	public User updateUser(@RequestBody User user) {
		service.createOrUpdate(user);
		return user;
	}

	@DeleteMapping("/{id}/id")
	public void deleteById(@PathVariable("id") Long id) {
		service.deleteById(id);
	}

	@ExceptionHandler
	public ResponseEntity<String> notFoundExceptionHandler(NotFoundException e) {
		return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
	}

	public UserDTO saveUserDTO (User user){
		UserDTO userDTO = UserMapper.MAPPER.fromUser(user);
		List<ProductDTO> productDTOList = ProductMapper.MAPPER.fromProductList(user.getProducts());
		userDTO.setProductDTOS(productDTOList);
		userDTO.setNickname("Little - " + user.getLogin());
		return userDTO;
	}
}
