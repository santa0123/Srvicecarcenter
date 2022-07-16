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

import com.it.dto.WorkDto;
import com.it.service.WorkService;

@RestController
@RequestMapping("/v1/works")
public class WorkController {
	
	
	@Autowired 
	private WorkService workService;
	
	@GetMapping
	public ResponseEntity<Object> getWorks() {
		return ResponseEntity.ok(workService.findWorkAll());		
	}
	
	@GetMapping("/{work_id}")
	public ResponseEntity<Object> getWorkId(@PathVariable(name = "work_id") Integer workId) {
		return ResponseEntity.ok(workService.findWorkByWorkId(workId));		
	}
	
	@PostMapping
	public ResponseEntity<Object> saveWorks(@RequestBody WorkDto workDto) {
		//roleRepository.save(null);
		return ResponseEntity.ok(workService.saveWork(workDto));
	}
	
	@PutMapping("/{work_id}")
	public ResponseEntity<Object> updateWorkId(@PathVariable(name = "work_id") Integer workId, @RequestBody WorkDto workDto) {
		return ResponseEntity.ok(workService.updateWorkId(workId, workDto));		
	}
	
	@DeleteMapping("/{work_id}")
	public ResponseEntity<Object> deleteWorkId(@PathVariable(name = "work_id") Integer workId) {
		return ResponseEntity.ok(workService.deleteWorkById(workId));		
	}

}
