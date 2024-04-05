import {Component, Inject} from '@angular/core';
import {GameRoleInterface} from "./game-role-interface";
import {MatIcon} from "@angular/material/icon";
import {MatButton, MatIconButton} from "@angular/material/button";
import {FormsModule} from "@angular/forms";
import {ActivatedRoute, Route, Router, Routes} from "@angular/router";
import {NgForOf} from "@angular/common";
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell, MatHeaderCellDef,
  MatHeaderRow, MatHeaderRowDef,
  MatRow, MatRowDef,
  MatTable
} from "@angular/material/table";
import {CdkTableDataSourceInput} from "@angular/cdk/table";
import {SportFieldService} from "../services/sport-field.service";


@Component({
  selector: 'app-add-field',
  standalone: true,
  imports: [
    MatIcon,
    MatIconButton,
    MatButton,
    FormsModule,
    NgForOf,
    MatRow,
    MatHeaderRow,
    MatCell,
    MatHeaderCell,
    MatTable,
    MatColumnDef,
    MatCellDef,
    MatHeaderCellDef,
    MatHeaderRowDef,
    MatRowDef,
  ],
  templateUrl: './add-field.component.html',
  styleUrl: './add-field.component.css'
})
export class AddFieldComponent {

  public field = {
    sportEventId: this.route.snapshot.params['eventId'],
    eventRoleDataList: null
  };

  gameRoles: GameRoleInterface[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private sportFieldService: SportFieldService
  ) {
  }

  addGameRole(form: any): void {
    if (form.valid) {
      const {gameRole, quantity} = form.value;
      this.gameRoles.push({gameRole: gameRole.toUpperCase(), numberOfPlayers: quantity});
      form.reset(); // Czyścimy formularz po dodaniu roli gry
    }
  }

  deleteGameRole(index: number): void {
    this.gameRoles.splice(index, 1); // Usuwamy rolę gry na podstawie indeksu
  }

  saveGameRole() {
    this.field.eventRoleDataList = this.gameRoles;
    console.log(this.gameRoles)
    console.log(this.field.eventRoleDataList)
    console.log(this.field)
    this.sportFieldService.createEventRoles(this.field).subscribe(() => {
      this.router.navigateByUrl("event/" + this.field.sportEventId);
    });
  }
}
