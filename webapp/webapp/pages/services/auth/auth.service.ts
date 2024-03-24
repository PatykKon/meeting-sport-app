import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable, tap} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";

const BASIC_URL =  "http://localhost:8080/api/auth"

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http:HttpClient
  )
  {}

  authSubject= new BehaviorSubject<any>({
    user:null
  })

  login(userData:any):Observable<any>{
    return this.http.post<any>(BASIC_URL + "/authenticate",userData);
  }
  public logout(){
    localStorage.clear();
    this.authSubject.next({})
  }

  register(signupRequest:any): Observable<any> {
    return this.http.post(BASIC_URL + "/register", signupRequest);
  }
  getUserProfile(): Observable<any> {
    const headers = new HttpHeaders({
      Authorization: `Bearer ${localStorage.getItem("accessToken")}`
    });
    console.log("token: " + localStorage.getItem("accessToken"))
    console.log("token: " + headers)
    return this.http.get<any>(BASIC_URL + "/profile", { headers }).pipe(
      tap((user) => {
        const currentState = this.authSubject.value;
        this.authSubject.next({...currentState, user});
      })
    );
  }



  // getUserProfile():Observable<any>{
  //   const haders = new HttpHeaders({
  //     Authorization:'Bearer ${localStorage.getItem("jwt")}'
  //   })
  //   return this.http.post<any>(BASIC_URL + "/register",{haders}).pipe(
  //     tap((user) => {
  //       const currentState = this.authSubject.value;
  //       this.authSubject.next({...currentState,user})
  //     })
  //   );
  // }
  // logut(){
  //   localStorage.clear()
  //   this.authSubject.next()
  // }
  private getHeaders():HttpHeaders{
    const token =localStorage.getItem("jwt")
    return new HttpHeaders({
      Authorization:'Bearer &{localStorage.getItem("jwt")}'
    })
  }
}
