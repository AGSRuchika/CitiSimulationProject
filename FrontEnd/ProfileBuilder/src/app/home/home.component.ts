import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ViewprofileComponent } from '../viewprofile/viewprofile.component';
import { ProfileService } from '../profile.service';
import { CreateProgram } from 'typescript';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent {
  constructor(
    private router: Router,
    public dialog: MatDialog,
    private profileService: ProfileService
  ) {}

  create() {
    this.router.navigateByUrl('/create');
  }

  viewprofile() {
    this.router.navigateByUrl('/viewprofile');
  }
}
