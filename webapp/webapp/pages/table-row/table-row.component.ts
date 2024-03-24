import { Component } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';
import {RouterLink, RouterLinkActive} from "@angular/router";

@Component({
  selector: 'app-table-row',
  standalone: true,
    imports: [MatButtonModule, MatDividerModule, MatIconModule, RouterLink, RouterLinkActive],
  templateUrl: './table-row.component.html',
  styleUrl: './table-row.component.css'
})
export class TableRowComponent {

}
