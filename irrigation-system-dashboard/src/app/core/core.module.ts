import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { MatDividerModule } from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatIconModule} from '@angular/material/icon';
import { AppRoutingModule } from '../app-routing.module';

@NgModule({
  declarations: [
    HeaderComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    MatDividerModule,
    MatButtonModule,   
    MatToolbarModule,
    MatListModule,
    MatButtonModule,
    MatIconModule,
  ],

  exports:[HeaderComponent]
})
export class CoreModule { }
