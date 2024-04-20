import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {EventCardService} from "./event-card.service";
import {EventInterface} from "./event.interface";

import {Router} from "@angular/router";
import {
  MatTableDataSource, MatTableModule
} from "@angular/material/table";
import {MatPaginator, MatPaginatorModule} from "@angular/material/paginator";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatSort,MatSortModule} from "@angular/material/sort";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-event-card',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    MatButton
  ],
  templateUrl: './event-card.component.html',
  styleUrl: './event-card.component.css'
})
export class EventCardComponent implements OnInit,AfterViewInit{

  public events: EventInterface[] = []
  public dataSource: MatTableDataSource<EventInterface>;
  public displayedColumns: string[] = ['id', 'title','city', 'startDate', 'gameTime', 'minAge','action'];

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private eventSportService: EventCardService,
    private router: Router
  ) {
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }

  public ngOnInit(): void {
    this.getEvents();
    console.log(this.events)
  }

  public getEvents() {
    return this.eventSportService.getEvents().subscribe(events => {
      this.events = events;
      this.dataSource = new MatTableDataSource(this.events);
      console.log(this.events)

    })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  public redirectToEvent(eventId: number){
    this.router.navigate(['/event',eventId])

  }
}
