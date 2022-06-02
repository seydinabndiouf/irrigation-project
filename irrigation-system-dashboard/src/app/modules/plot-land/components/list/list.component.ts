import { Component, OnInit } from '@angular/core';
import { Data } from 'src/app/core/model/data.model';
import { PlotLand } from 'src/app/core/model/plot-land.model';
import { PlotLandService } from '../../services/plot-land.service';
import {MatTableDataSource} from "@angular/material/table";
import {DataSource} from '@angular/cdk/collections';

@Component({
  selector: 'plot-land-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  plotLands: PlotLand[] = [];

  displayedColumns: string[] = ['ID', 'Name', 'Area', 'Status', 'IrrigationTimeSlot', 'NextIrrigationDate'];

  public dataSource = new MatTableDataSource<PlotLand>();

  constructor(public plotLandService: PlotLandService) {
    
   }

  ngOnInit(): void {

    this.plotLandService.getAll().subscribe((data: Data<PlotLand>)=>{
      console.log(data);
      this.dataSource.data = data.content;
    }) 
  }

  addData() {

  }

  removeData() {
  }

}
