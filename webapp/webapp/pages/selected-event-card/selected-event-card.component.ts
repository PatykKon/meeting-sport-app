import {Component, OnInit} from '@angular/core';
import {EventInterface} from "../event-card/event.interface";
import {EventCardService} from "../event-card/event-card.service";
import {ActivatedRoute, Router, RouterLinkActive} from "@angular/router";
import {MatButton, MatButtonModule} from "@angular/material/button";
import {NgForOf} from "@angular/common";
import {EventRoleInterface} from "../event-card/event-role.interface";
import {FormsModule} from "@angular/forms";
import {AuthService} from "../services/auth/auth.service";
import {SportFieldService} from "../services/sport-field.service";
import {SportFieldInterface} from "../event-card/sport-field.interface";
import {catchError, throwError} from "rxjs";

@Component({
  selector: 'app-selected-event-card',
  standalone: true,
  imports: [
    MatButton,
    NgForOf,
    RouterLinkActive,
    MatButtonModule,
    FormsModule
  ],
  templateUrl: './selected-event-card.component.html',
  styleUrl: './selected-event-card.component.css'
})
export class SelectedEventCardComponent implements OnInit{

  public event: EventInterface;
  public roleSummaries: { gameRole: string, availableCount: number, occupiedCount: number }[] = [];
  public eventId: number = this.route.snapshot.params['eventId'];

  public field = {
    eventId: this.eventId,
    gameRole: null,
    userEmail: null
  };
  public sportField: SportFieldInterface;

  constructor(
    private eventSportService: EventCardService,
    private route: ActivatedRoute,
    private router: Router,
    private eventService: EventCardService,
    private fieldService: SportFieldService,
    private authService : AuthService
  ) {
  }

  public ngOnInit(): void {
    this.authService.authSubject.subscribe(
      (auth) => this.field.userEmail = auth.user.email
    )
    this.eventId = this.route.snapshot.params['eventId'];
    console.log(this.eventId)
    this.getEvent(this.eventId);
    this.getField(this.eventId)
  }

  public getEvent(eventId: number) {
    return this.eventSportService.getEvent(eventId).subscribe(event => {
      console.log(event)
      this.event = event;
      this.calculateRoleSummaries();
    })
  }

  public getField(eventId: number) {
    return this.fieldService.getSportFieldForEvent(eventId).subscribe(sportField => {
      console.log("sportField" + sportField)
      this.sportField = sportField;
      console.log("sportField" + this.sportField.city)
    })
  }
  calculateRoleSummaries(): void {
    if (this.event && this.event.eventRoleResponse) {
      const roleMap = new Map<string, { availableCount: number, occupiedCount: number }>();

      this.event.eventRoleResponse.forEach(role => {
        const roleSummary = roleMap.get(role.gameRole) || { availableCount: 0, occupiedCount: 0 };
        if (role.isAvailable) {
          roleSummary.availableCount++;
        } else {
          roleSummary.occupiedCount++;
        }
        roleMap.set(role.gameRole, roleSummary);
      });

      this.roleSummaries = Array.from(roleMap).map(([gameRole, { availableCount, occupiedCount }]) => ({ gameRole, availableCount, occupiedCount }));
    }
  }

  handleJoinEvent(gameRole: string) {
    this.field.gameRole = gameRole
    this.eventService.joinEvent(this.field).subscribe(() => {
      this.router.navigateByUrl("event/" + this.eventId);
    });
  }
}
