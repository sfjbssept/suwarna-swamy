package com.student.app.controller;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import com.student.app.entity.Student;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServiceController {
	
	private static Map<String,List<Student>> schoolDB=new HashMap<String,List<Student>>();
		static {
			schoolDB=new HashMap<String,List<Student>>();
			
			List<Student> lst= new ArrayList<>();
			Student std=new Student("Suwarna","Class12");
			lst.add(std);
			Student std1=new Student("Vaibhav","Class1");
			lst.add(std1);
			schoolDB.put("School 1",lst);
			lst=new ArrayList<Student>();
			 std=new Student("Vinay","Class12");
			lst.add(std);
			 std1=new Student("Aaradhya","Class1");
			lst.add(std1);
			schoolDB.put("School 2",lst);
			lst=new ArrayList<Student>();
			 std=new Student("ABC","Class10");
			lst.add(std);
			 std1=new Student("XYZ","Class6");
			lst.add(std1);
			schoolDB.put("School 3",lst);
			lst=new ArrayList<Student>();
			 std=new Student("Twinkle","Class5");
			lst.add(std);
			 std1=new Student("Wonder","Class8");
			lst.add(std1);
			schoolDB.put("School 4",lst);
			
			
		}
		
		@RequestMapping(value= "/getStudentDetailsForSchool/{schoolname}",method= RequestMethod.GET)
			public List<Student>getStudents(@PathVariable String schoolname){
				System.out.println("Getting student details for "+schoolname);
				List<Student> studentList = schoolDB.get(schoolname);
				
				if(studentList == null) {
					
					studentList = new ArrayList<Student>();
					Student std=new Student("NotFound 404","NA");
					studentList.add(std);
				}
				return studentList;
				
				
	}
}

			
	


