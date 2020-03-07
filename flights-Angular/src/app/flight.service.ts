import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders, HttpParams} from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  constructor(private http:HttpClient) { }


  getFlights1(){return this.http.get('http://localhost:9096/flights')}
  getFlights2(value:any){return this.http.get('http://localhost:9096/flightOD',{ params : value})}

  getFlight(value:any)
  {
  //  let param=new HttpParams().set('no',"2005")
    return this.http.get('http://localhost:9096/flight',{ params : value})
}
}
