import {Inject, Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class EventCardService {

  constructor(
    private http: HttpClient) { }

    getEvents():Observable<any>{
      return this.http.get("localhost:8080/api/sport-event")
    }
}
