import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../profile.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss'],
})
export class DialogComponent implements OnInit {
  profile: any = {};
  profileEmail!: string;

  constructor(
    private profileService: ProfileService,
    private router: Router,
    private http: HttpClient,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.profileEmail = params['profileEmail'];
      console.log(this.profileEmail);
      if (this.profileEmail) {
        this.profileService.getProfileByEmail(this.profileEmail).subscribe(
          (response) => {
            this.profile = response;
          },
          (error) => {
            console.error('Error fetching profile:', error);
          }
        );
      } else {
        this.profile = {};
      }
    });
  }

  close(): void {
    this.router.navigateByUrl('/viewprofile');
  }
}
