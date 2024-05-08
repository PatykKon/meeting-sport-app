import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {NgModule} from "@angular/core";
import {SignupComponent} from "./signup/signup.component";
import {HomePageComponent} from "../../pages/home-page/home-page.component";
import {EventCardComponent} from "../../pages/event-card/event-card.component";
import {AddEventComponent} from "../../pages/add-event/add-event.component";
import {SelectedEventCardComponent} from "../../pages/selected-event-card/selected-event-card.component";
import {AddEventRoleComponent} from "../../pages/add-event-role/add-event-role.component";
import {AddFieldComponent} from "../../pages/add-field/add-field.component";
import {UserProfileComponent} from "../../pages/user-profile/user-profile.component";

export const routes: Routes = [
  {path: "login", component: LoginComponent},
  {path: "signup", component: SignupComponent},
  {path: "", component: HomePageComponent},
  {path: "events", component: EventCardComponent},
  {path: "add-event", component: AddEventComponent},
  {path: "event/:eventId", component: SelectedEventCardComponent},
  {path: "event/:eventId/add-event-role", component: AddEventRoleComponent},
  {path: "event/:eventId/add-field", component: AddFieldComponent},
  {path: "profile", component: UserProfileComponent}
];
@NgModule({
  imports:[RouterModule.forRoot(routes)],
  exports:[RouterModule]
})
export class AppRoutes{}
