import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { PlotLandFormComponent } from '../../components/form/plot-land-form.component';

@Component({
  selector: 'app-plot-land',
  templateUrl: './plot-land.component.html',
  styleUrls: ['./plot-land.component.scss']
})
export class PlotLandComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  addPlotLand() {
    const dialogRef = this.dialog.open(PlotLandFormComponent);

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }

  removePlotLand(): void{

  }
} 
