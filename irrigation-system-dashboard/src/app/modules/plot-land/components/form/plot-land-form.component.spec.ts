import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlotLandFormComponent } from './plot-land-form.component';

describe('PlotLandFormComponent', () => {
  let component: PlotLandFormComponent;
  let fixture: ComponentFixture<PlotLandFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlotLandFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlotLandFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
