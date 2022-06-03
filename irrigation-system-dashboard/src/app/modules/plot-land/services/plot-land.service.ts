import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Data } from 'src/app/core/model/data.model';
import { PlotLand } from 'src/app/core/model/plot-land.model';
import { AgriculturalCrop } from 'src/app/core/model/plot-land/agricultural-crop.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PlotLandService {

  private apiServer = environment.API_BASE_URL;
  
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })  
  }
  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Data<PlotLand>> {
    return this.httpClient.get<Data<PlotLand>>(this.apiServer + '/plotlands')
  }

  getAgriculturalCrop(): Observable<AgriculturalCrop[]>{
    return this.httpClient.get<AgriculturalCrop[]>(this.apiServer + '/agriculturalcrops')
  }

  createPlotLand(plotLand:PlotLand): Observable<PlotLand>{
    return this.httpClient.post<PlotLand>(this.apiServer + '/plotlands', plotLand)
  }

}
