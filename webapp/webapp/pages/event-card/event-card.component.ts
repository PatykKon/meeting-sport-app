import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {EventCardService} from "./event-card.service";
import {EventInterface} from "./event.interface";
import {of} from "rxjs";

@Component({
    selector: 'app-event-card',
    standalone: true,
    imports: [
        MatCardModule,
        MatButtonModule
    ],
    templateUrl: './event-card.component.html',
    styleUrl: './event-card.component.css'
})
export class EventCardComponent {

    public events: EventInterface[] = [];

    constructor(
        private eventSportService: EventCardService
    ) {
    }

    public ngOnInit(): void {
        this.getEvents();
    }

    public getEvents() {
        return this.eventSportService.getEvents().subscribe(ss => {
            console.log(ss)
            this.events = ss
        })
    }
}
