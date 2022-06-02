import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlotLandComponent } from './pages/plot-land/plot-land.component';

const routes: Routes = [
  { path: '', component: PlotLandComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PlotLandRoutingModule { }
