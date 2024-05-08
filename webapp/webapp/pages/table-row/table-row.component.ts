import { Component } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';
import {RouterLink, RouterLinkActive} from "@angular/router";
import {UserInterface} from "../selected-event-card/user-interface";
import {EventInterface} from "../event-card/event.interface";
import {EventCardService} from "../event-card/event-card.service";
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-table-row',
  standalone: true,
    imports: [MatButtonModule, MatDividerModule, MatIconModule, RouterLink, RouterLinkActive],
  templateUrl: './table-row.component.html',
  styleUrl: './table-row.component.css'
})
export class TableRowComponent {
}
