import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {NgModule} from "@angular/core";
import {SignupComponent} from "./signup/signup.component";
import {HomePageComponent} from "../../pages/home-page/home-page.component";
import {EventCardComponent} from "../../pages/event-card/event-card.component";
import {AddEventComponent} from "../../pages/add-event/add-event.component";

export const routes: Routes = [
  {path: "login", component: LoginComponent},
  {path: "signup", component: SignupComponent},
  {path: "", component: HomePageComponent},
  {path: "events", component: EventCardComponent},
  {path: "add-event", component: AddEventComponent}
];
@NgModule({
  imports:[RouterModule.forRoot(routes)],
  exports:[RouterModule]
})
export class AppRoutes{}
