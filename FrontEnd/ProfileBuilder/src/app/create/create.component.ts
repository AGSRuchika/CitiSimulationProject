import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import { Component} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss'],
})
export class CreateComponent {
  profile = {
    name: '',
    email: '',
    phone: '',
    address: '',
    education: [
      {
        college: '',
        studyFrom: '',
        studyTo: '',
        department: '',
        percentage: '',
      },
    ],
    experience: [
      {
        company: '',
        occupation: '',
        workFrom: '',
        workTo: '',
        jobDescription: '',
      },
    ],
    skill: '',
    activity: '',
  };

  addEducation() {
    this.profile.education.push({
      college: '',
      studyFrom: '',
      studyTo: '',
      department: '',
      percentage: '',
    });
  }

  removeEducation(index: number) {
    this.profile.education.splice(index, 1);
  }

  addExperience() {
    this.profile.experience.push({
      company: '',
      occupation: '',
      workFrom: '',
      workTo: '',
      jobDescription: '',
    });
  }

  removeExperience(index: number) {
    this.profile.experience.splice(index, 1);
  }

  constructor(private http: HttpClient, private router: Router) {}

  profileNames: string[] = [];
  profileEmails: string[] = [];

  onSubmit() {
    this.profileNames.push(this.profile.name);
    this.profileEmails.push(this.profile.email);
    localStorage.setItem('profileNames', JSON.stringify(this.profileNames));
    localStorage.setItem('profileEmails', JSON.stringify(this.profileEmails));
    
    const apiUrl = 'http://localhost:8084/api/profiles';
    this.http.post(apiUrl, this.profile).subscribe(
      (response) => {
        console.log('Profile created successfully!', response);
        localStorage.setItem('name', this.profile.name);
        const name = localStorage.getItem('name');
        console.log(name);
        localStorage.setItem('email', this.profile.email);
        const email = localStorage.getItem('email');
        console.log(email);
        this.router.navigateByUrl('/home');
      },

      (error: HttpErrorResponse) => {
        if (
          error.status === 400 &&
          error.error.type === 'ProfileAlreadyExistsException'
        ) {
          console.error(this.profile.email + ':', error.error.message);
          alert(this.profile.email + ':' + error.error.message);
        } else if (
          error.status === 429 &&
          error.error.type === 'NumberOfProfilesExceedsTen'
        ) {
          console.error(error.error.message);
          alert(error.error.message);
        } else {
          console.error('Error creating profile:', error);
          alert('Error creating profile. Please try again later.');
        }
      }
    );
  }

  Back() {
    this.router.navigateByUrl('/home');
  }
}
