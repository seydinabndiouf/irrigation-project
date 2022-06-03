import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { Data } from 'src/app/core/model/data.model';
import { PlotLand } from 'src/app/core/model/plot-land.model';
import { PlotLandFormComponent } from '../../components/form/plot-land-form.component';
import { PlotLandService } from '../../services/plot-land.service';

@Component({
  selector: 'app-plot-land',
  templateUrl: './plot-land.component.html',
  styleUrls: ['./plot-land.component.scss']
})
export class PlotLandComponent implements OnInit {
  plotLands!: PlotLand[];

  constructor(public plotLandService: PlotLandService, public dialog: MatDialog) {
    this.plotLandService.getAll().subscribe((data: Data<PlotLand>)=>{
      this.plotLands = data.content;
      console.log( this.plotLands);
      
    }) 
   }


  ngOnInit(): void {

  }

  addPlotLand() {
    const dialogRef = this.dialog.open(PlotLandFormComponent);

    dialogRef.afterClosed().subscribe(result => {
      
      this.plotLandService.getAll().subscribe((data: Data<PlotLand>)=>{
        this.plotLands = data.content;
        
      }) 
    });
  }
} 
