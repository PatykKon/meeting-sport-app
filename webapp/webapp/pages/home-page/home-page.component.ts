import { Component } from '@angular/core';
import {EventCardComponent} from "../event-card/event-card.component";
import {TableRowComponent} from "../table-row/table-row.component";

@Component({
  selector: 'app-home-page',
  standalone: true,
  imports: [
    EventCardComponent,
    TableRowComponent
  ],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {

  events=[1]
}
