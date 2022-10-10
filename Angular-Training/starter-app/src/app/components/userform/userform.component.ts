import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {
  username :String= "";
  salary:number=0;
  title = 'Hello World';
  desc: String="AngularJS is an open-source web application framework. It was originally developed in 2009 by Misko Hevery and Adam Abrons. It is now maintained by Google. Its latest version is 1.2.21. AngularJS is a structural framework for dynamic web applications."


  save(){
    console.log("The user name is "+
    this.username  + " who's salary is "+ this.salary);
  }
  constructor() { }

  ngOnInit(): void {
  }

}
