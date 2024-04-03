import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {EventInterface} from "../event-card/event.interface";
import {SportFieldInterface} from "../event-card/sport-field.interface";
import {SportFieldService} from "../services/sport-field.service";
import {MatTableDataSource, MatTableModule} from "@angular/material/table";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatSort, MatSortModule} from "@angular/material/sort";
import {MatPaginator, MatPaginatorModule} from "@angular/material/paginator";
import {ActivatedRoute, Route, Router} from "@angular/router";

@Component({
  selector: 'app-add-event-role',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatTableModule, MatSortModule, MatPaginatorModule],
  templateUrl: './add-event-role.component.html',
  styleUrl: './add-event-role.component.css'
})
export class AddEventRoleComponent implements AfterViewInit, OnInit {

  displayedColumns: string[] = ['id', 'fieldSpace', 'fieldType', 'city', 'street', 'number', 'action'];
  dataSource: MatTableDataSource<SportFieldInterface>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  public field = {
    sportEventId: this.route.snapshot.params['eventId'],
    sportFieldId: null,
    userEmail: null
  };


  public sportFields: SportFieldInterface[] = [];

  constructor(
    private sportFieldService: SportFieldService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  public ngOnInit(): void {
    this.handleSportFields();
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  public handleSportFields() {
    return this.sportFieldService.getSportFields().subscribe(sportFields => {
      this.sportFields = sportFields;
      this.dataSource = new MatTableDataSource(this.sportFields);
      console.log("sport fields: " + sportFields.city)
      console.log("data source : " + this.dataSource)
    })
  }

  handleAssignToEvent(sportFieldId: number) {
    this.field.sportFieldId = sportFieldId;
    console.log("sportfield: " + sportFieldId + "evreneID " + this.field.sportEventId);
    this.sportFieldService.assignToEvent(this.field).subscribe()
    this.router.navigateByUrl("event/" + this.field.sportEventId + "/add-field")
  }
}
