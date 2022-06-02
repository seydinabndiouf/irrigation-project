import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlotLandComponent } from './plot-land.component';

describe('PlotLandComponent', () => {
  let component: PlotLandComponent;
  let fixture: ComponentFixture<PlotLandComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlotLandComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlotLandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
