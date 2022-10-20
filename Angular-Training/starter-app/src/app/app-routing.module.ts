import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { HomeComponent } from './components/home/home.component';
import { UserformComponent } from './components/userform/userform.component';
import { RegisteredstudentComponent } from './components/registered-student/registered-student.component';

const routes: Routes = [{path:"home",component: HomeComponent},
{path:"register",component:UserformComponent},{path:"contact",component: ContactComponent},{
path:"about",component: AboutComponent},{path:"RegisteredStudentComponent",component: RegisteredstudentComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
