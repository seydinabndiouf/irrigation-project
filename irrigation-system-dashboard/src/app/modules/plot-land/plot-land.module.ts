import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlotLandRoutingModule } from './plot-land-routing.module';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ListComponent } from './components/list/list.component';
import { PlotLandComponent } from './pages/plot-land/plot-land.component';
import { CoreModule } from 'src/app/core/core.module';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import { PlotLandFormComponent } from './components/form/plot-land-form.component';
import {MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';
import { MatIconModule } from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import { MatDivider, MatDividerModule } from '@angular/material/divider';

@NgModule({
  declarations: [
    ListComponent,
    PlotLandComponent,
    PlotLandFormComponent
  ],
  imports: [
    CommonModule,
    PlotLandRoutingModule,
    HttpClientModule,
    FormsModule,
    CoreModule,
    MatDividerModule,
    MatTableModule,
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatSelectModule,
    MatOptionModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class PlotLandModule { }
