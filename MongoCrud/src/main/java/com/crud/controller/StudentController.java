package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;

@RestController
public class StudentController {
	@Autowired
	private com.crud.repo.iStudentRepo iStudentRepo;
	@PostMapping("/addStudent")
	public ResponseEntity<?>addStudent(@RequestBody Student student)
	{
		Student save=this.iStudentRepo.save(student);
		return ResponseEntity.ok(save);
	}
	
	
	@GetMapping("/getStudents")
		public ResponseEntity<?>getStudents(){
			return ResponseEntity.ok(this.iStudentRepo.findAll());
		}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<?>updateStudent(@PathVariable Integer id,@RequestBody Student student)
	{
		Student save=this.iStudentRepo.save(student);
		return ResponseEntity.ok(save);
	}
	@GetMapping("/deleteStudents/{id}")
	public void deleteStudents(@PathVariable Integer id){
		this.iStudentRepo.deleteById(id);
		 
		
	}
}
	
	

