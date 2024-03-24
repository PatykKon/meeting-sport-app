import {Component} from '@angular/core';
import {EventCardService} from "../event-card/event-card.service";
import {FormBuilder, FormGroup, FormsModule} from "@angular/forms";
import {Route, Router} from "@angular/router";
import {AuthService} from "../services/auth/auth.service";

@Component({
  selector: 'app-add-event',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-event.component.html',
  styleUrl: './add-event.component.css'
})
export class AddEventComponent {

  public field = {
    gameTime: 0,
    title: null,
    description: null,
    players: null,
    minAge: null,
    startTime: null,
    userEmail: null
  };
  constructor(
    private eventService: EventCardService,
    private route:Router,
    private authService: AuthService) {
  }

  user: any = null;

  ngOnInit() {
    this.authService.authSubject.subscribe(
      (auth) => this.field.userEmail = auth.user.email
    )
  }

  onSubmit(): void {
    console.log("kliklo sie")
    this.handleCreateEvent();
  }

  handleCreateEvent() {
    this.eventService.createEvent(this.field).subscribe({
      next: (response) => {
        console.log('cos sie wydarzyło: '+ response);
        this.route.navigateByUrl("");
      }
    })
  }
}
