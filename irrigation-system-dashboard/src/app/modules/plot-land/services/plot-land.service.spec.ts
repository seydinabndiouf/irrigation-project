import { TestBed } from '@angular/core/testing';

import { PlotLandService } from './plot-land.service';

describe('PlotLandService', () => {
  let service: PlotLandService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlotLandService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
