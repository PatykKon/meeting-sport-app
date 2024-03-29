import {Inject, Injectable} from '@angular/core';
import {BehaviorSubject, catchError, Observable, tap, throwError} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";

const BASIC_URL = "http://localhost:8080/api/auth"

@Injectable({
  providedIn: 'root'
})
export class EventCardService {

  constructor(
    private http: HttpClient) {
  }

  eventSubject = new BehaviorSubject<any>({
    events: [],
    loading: false,
    newEvent: null
  });


  getEvents(): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get(BASIC_URL + "/sport-event", {headers}).pipe(
      tap((events) => {
        const currentState = this.eventSubject.value;
        this.eventSubject.next({...currentState, events});
      })
    );
  }

  createEvent(field: any): Observable<any> {
    const headers = this.getHeaders();
    return this.http.post<any>(BASIC_URL + "/sport-event/create", field, { headers }).pipe(
      tap((events) => {
        const currentState = this.eventSubject.value;
        this.eventSubject.next({ ...currentState, events });
      }),
      catchError(error => {
        console.error('An error occurred:', error);
        return throwError(error);
      })
    );
  }

  private getHeaders(): HttpHeaders {
    return new HttpHeaders({
      Authorization: 'Bearer &{localStorage.getItem("accessToken")}'
    })
  }


}
