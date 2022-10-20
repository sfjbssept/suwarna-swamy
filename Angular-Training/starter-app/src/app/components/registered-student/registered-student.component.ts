import { Component, OnInit } from '@angular/core';
import Student from '../../entity/Student';
import { StudentsService } from 'src/app/Services/students.service';

@Component({
  selector: 'app-registeredstudent',
  templateUrl: './registered-student.component.html',
  styleUrls: ['./registered-student.component.css'],
})
export class RegisteredstudentComponent implements OnInit {
  students: Student[] = [];

  deleteStudent(students,index){
    const observable=this.studentService.deleteStudent(students);
    observable.subscribe((response: any)=>{
      console.log(response);
    this.students.splice(index,1);})
  }

  constructor(private studentService: StudentsService) {}

  ngOnInit(): void {
    const data = this.studentService.getStudents();
    data.subscribe((response) => {
      console.log(response);
      this.students = response as Student[];
    });
  }
}