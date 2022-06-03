import { Component, Input, OnInit } from '@angular/core';
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
  @Input() plotLands!: PlotLand[];

  displayedColumns: string[] = ['ID', 'Name', 'Area', 'Status', 'IrrigationTimeSlot', 'NextIrrigationDate'];

  public dataSource = new MatTableDataSource<PlotLand>();

  constructor(public plotLandService: PlotLandService) {
    
   }

  ngOnInit(): void {
  
  }

  ngAfterViewChecked(){
    this.dataSource.data = this.plotLands;
  }

}
