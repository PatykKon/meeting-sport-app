import {Inject, Injectable} from '@angular/core';
import {BehaviorSubject, catchError, Observable, tap, throwError} from "rxjs";
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";

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

  getEvent(eventId:number): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get(BASIC_URL + '/sport-event/event/' + eventId, {headers}).pipe(
      tap((events) => {
        const currentState = this.eventSubject.value;
        this.eventSubject.next({...currentState, events});
      })
    );
  }
  getEventUsers(eventId:number): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get(BASIC_URL + '/sport-event/users/' + eventId, {headers}).pipe(
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

  joinEvent(field: any): Observable<any> {
    const headers = this.getHeaders();
    return this.http.post<any>(BASIC_URL + "/sport-event/join", field, { headers }).pipe(
      tap((events) => {
        const currentState = this.eventSubject.value;
        this.eventSubject.next({ ...currentState, events });
      }),

      catchError(this.handleError)
    );
  }

  private getHeaders(): HttpHeaders {
    return new HttpHeaders({
      Authorization: 'Bearer &{localStorage.getItem("accessToken")}'
    })
  }

  handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }

}
