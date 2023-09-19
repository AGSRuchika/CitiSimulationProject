import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent {

  showPassword: boolean = false;
  username: string = "";
  password: string = "";

  constructor(private router: Router, private authService: AuthService) {}

  Login() {
    console.log(this.username);
    console.log(this.password);

    const isAuthenticated = this.authService.login(this.username, this.password);

    if (isAuthenticated) {
      console.log("Success");
      localStorage.setItem('username', this.username);
      this.router.navigateByUrl('/home');
    } else {
      alert("Incorrect Email and Password not match");
    }
  }

  Register() {
    this.router.navigateByUrl('/register');
  }

  togglePassword() {
    this.showPassword = !this.showPassword;
  }
}
