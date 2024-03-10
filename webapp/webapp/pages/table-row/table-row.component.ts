import { Component } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-table-row',
  standalone: true,
  imports: [MatButtonModule, MatDividerModule, MatIconModule],
  templateUrl: './table-row.component.html',
  styleUrl: './table-row.component.css'
})
export class TableRowComponent {



  deleteRow(rowId: number): void {
    // Tutaj możesz dodać logikę usuwania wiersza
    console.log(`Usuwanie wiersza o ID: ${rowId}`);
  }


  items = [
    { id: 1, name: 'Przycisk 1' },
    { id: 2, name: 'Przycisk 2' },
    { id: 3, name: 'Przycisk 3' },
    // Dodaj więcej elementów według potrzeb
  ];

  buttonClick(item: any) {
    alert(`Kliknięto przycisk ${item.name}`);
  }
}
