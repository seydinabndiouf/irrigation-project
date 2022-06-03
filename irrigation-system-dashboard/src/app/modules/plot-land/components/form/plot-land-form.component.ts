import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { MatDialogRef } from '@angular/material/dialog';
import { Data } from 'src/app/core/model/data.model';
import { PlotLand } from 'src/app/core/model/plot-land.model';
import { AgriculturalCrop } from 'src/app/core/model/plot-land/agricultural-crop.model';
import { PlotLandService } from '../../services/plot-land.service';

@Component({
  selector: 'app-plot-land-form',
  templateUrl: './plot-land-form.component.html',
  styleUrls: ['./plot-land-form.component.scss']
})
export class PlotLandFormComponent implements OnInit {

  agriculturalCrops: AgriculturalCrop[] = [];
  constructor(public plotLandService: PlotLandService, public dialogRef: MatDialogRef<PlotLandFormComponent>) { }

  ngOnInit(): void {
    this.plotLandService.getAgriculturalCrop().subscribe((data: AgriculturalCrop[]) => { 
      this.agriculturalCrops = data;
    }) 
  }

   /*Form validations*/
   plotlandForm = new FormGroup({

   name : new FormControl('', [
    Validators.required,   
    ]),
    area : new FormControl('', [
      Validators.required,
    ]),
    water : new FormControl('', [
      Validators.required,   
    ]), 

    time : new FormControl('', [
      Validators.required,   
    ]),

    crop : new FormControl(null, [
      Validators.required,   
    ]),
    });


    onNoClick(): void {
      this.dialogRef.close();
    }

    submit(): void {
    let plotLand: PlotLand = {
      plotLandId: null,
      plotLandName: this.plotlandForm.value.name,
      plotLandArea: this.plotlandForm.value.area,
      plotLandConfiguration: {
        plotLandId: null,
        waterAmount : this.plotlandForm.value.water, 
        irrigationTimeSlot: this.plotlandForm.value.time 
      },
      agriculturalCrop:{agriculturalCropId: +this.plotlandForm.value.crop}
    }
    

    this.plotLandService.createPlotLand(plotLand).subscribe((data: PlotLand) => { 
      this.dialogRef.close();
    }) 
  }
  

}
