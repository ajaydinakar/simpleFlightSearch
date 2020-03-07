import { Component, ViewChild } from '@angular/core';
import {FlightService} from './flight.service';
import { Flights } from './flights';
import { NgForm } from '@angular/forms';
import { formArrayNameProvider } from '@angular/forms/src/directives/reactive_directives/form_group_name';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[FlightService]
})
export class AppComponent {

  @ViewChild('f') form:NgForm;

data:Flights[];

data1: Flights;
show:boolean=false;
number:boolean=true;
origin:boolean=false;
public buttonName:any = 'Show all Flights';
public formName:any = 'Find by Origin ';

headline="Flights Search App";

params={
  no:'',
  date:'',
  origin:'',
  destination:'',

};


  
  constructor(public flightService:FlightService){}

  ngOnInit()
  {
  this.callFlights();
 // this.callFlight(value:NgForm);

  }

  toggle() {
    this.show = !this.show;

    // CHANGE THE NAME OF THE BUTTON.
    if(this.show)  
      this.buttonName = "Hide";
    else
      this.buttonName = "Show all flights";
  }

  toggleform() {
    this.number = !this.number;
    this.origin = !this.origin;

    // CHANGE THE NAME OF THE BUTTON.
    if(this.number && !this.origin)  
      this.formName = "Find by Flight NO";
    else
      this.formName = "Find by Origin and destination";
  }
  callFlights()
  {

  try
  {
  this.flightService.getFlights1().subscribe((resp:Flights [])=>{console.log(resp ,"res");this.data=resp},error=>{console.log(error ,"error");})}catch (e){console.log(e);
  }
  }


  onSubmit(value:NgForm) {
   
    this.params.no=this.form.value.flightno;
    this.params.date=this.form.value.date;
    this.callFlight(this.params)
  console.log(this.params);
 }
 
 onSubmit2(value:NgForm) {
   
  this.params.origin=this.form.value.flightno;
  this.params.destination=this.form.value.date;
  this.callFlight(this.params)
console.log(this.params);
}
  callFlight(value)
  {

  try
  {
  this.flightService.getFlight(value).subscribe((resp:Flights)=>{console.log(resp ,"res");this.data1=resp},error=>{console.log(error ,"error");})}catch (e){console.log(e);
  }
  }
}
