import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {UserInterface} from "../selected-event-card/user-interface";
import {EventInterface} from "../event-card/event.interface";
import {EventCardService} from "../event-card/event-card.service";
import {UserService} from "../services/user.service";
import {AuthService} from "../services/auth/auth.service";
import {EventRoleInterface} from "../event-card/event-role.interface";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-profile',
  standalone: true,
  imports: [],
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.css'
})
export class UserProfileComponent implements OnInit {

  public userInterface: UserInterface
  public sportEvents: EventInterface[] = []
  public eventRoles: EventRoleInterface[] = []
  public userId: number

  constructor(
    private sportEventService: EventCardService,
    private userService: UserService,
    private authService: AuthService,
    private route: Router
  ) {
  }

  public ngOnInit(): void {
    this.authService.authSubject.subscribe(
      (auth) => this.userId = auth.user.id
    )
    this.getUser(this.userId)
    this.getUserEvent(this.userId)
  }


  public getUserEvent(userId: number) {
    return this.sportEventService.getEventsForUser(userId).subscribe(events => {
      this.eventRoles = events;
    })
  }

  public redirectToSportEvent(eventId: number) {
    this.route.navigateByUrl("event/" +eventId)
  }

  public getUser(userId: number) {
    return this.userService.getUserInfo(userId).subscribe(events => {
      this.sportEvents = events;
    })
  }

}
