package com.it.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.it.dto.UserDetailDto;
import com.it.service.UserDetailService;

@RestController
@RequestMapping("/v1/userdetails")
public class UserDetailController {
	
	@Autowired 
	private UserDetailService userdetailService;
	
	@GetMapping
	public ResponseEntity<Object> getUserDetailIds() {
		return ResponseEntity.ok(userdetailService.findUserdeAll());		
	}
	
	@GetMapping("/{userde_id}")
	public ResponseEntity<Object> getRoleByUserDetailId(@PathVariable(name = "userde_id") Integer userdeId) {
		return ResponseEntity.ok(userdetailService.findUserdeById(userdeId));		
	}
	
	@PostMapping
	public ResponseEntity<Object> saveUserDetail(@RequestBody UserDetailDto userdetailDto) {
		//roleRepository.save(null);
		return ResponseEntity.ok(userdetailService.saveUserDetail(userdetailDto));
	}
	
	@PutMapping("/{userde_id}")
	public ResponseEntity<Object> updateUserDetail(@PathVariable(name = "userde_id") Integer userdeId, @RequestBody  UserDetailDto userdetailDto) {
		return ResponseEntity.ok(userdetailService.updateUserDetail(userdeId, userdetailDto));		
	}
	
	@DeleteMapping("/{userde_id}")
	public ResponseEntity<Object> deleteUserDetailByUserId(@PathVariable(name = "userde_id") Integer userdeId) {
		return ResponseEntity.ok(userdetailService.deleteUserdeById(userdeId));		
	}

}


