import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {NavbarComponent} from "../../pages/navbar/navbar.component";
import {FooterComponent} from "../../pages/footer/footer.component";
import {HomePageComponent} from "../../pages/home-page/home-page.component";
import {TableRowComponent} from "../../pages/table-row/table-row.component";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    NavbarComponent,
    FooterComponent,
    HomePageComponent,
    TableRowComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'webapp';
}
