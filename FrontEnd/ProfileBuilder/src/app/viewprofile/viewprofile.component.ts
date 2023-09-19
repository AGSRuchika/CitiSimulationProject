import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-viewprofile',
  templateUrl: './viewprofile.component.html',
  styleUrls: ['./viewprofile.component.scss'],
})
export class ViewprofileComponent implements OnInit {
  profileNames: string[] = [];
  profileEmails: string[] = [];
  isDialogOpen = false;
  profiles: { name: string; email: string }[] = [];

  constructor(
    private router: Router,
    private dialog: MatDialog,
    private profileService: ProfileService
  ) {}

  ngOnInit() {
    this.profileService.getAllProfiles().subscribe((profiles) => {
      this.profiles = profiles;
    });
  }

  openDialog(profileEmail: string) {
    console.log(profileEmail);
    this.router.navigate(['/dialog', profileEmail]);
  }

  deleteProfileDaialog(profileEmail: string) {
    this.profileService.deleteProfileByEmail(profileEmail).subscribe(
      () => {
        console.log(`Profile "${profileEmail}" deleted.`);
        this.profileEmails = this.profileEmails.filter(
          (email) => email !== profileEmail
        );
        this.profiles = this.profiles.filter(
          (profile) => profile.email !== profileEmail
        );
      },
      (error) => {
        console.error(`Error deleting profile "${profileEmail}":`, error);
      }
    );
  }

  back() {
    this.router.navigateByUrl('/home');
  }
}
