import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackDetailedComponent } from './track-detailed.component';

describe('TrackDetailedComponent', () => {
  let component: TrackDetailedComponent;
  let fixture: ComponentFixture<TrackDetailedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrackDetailedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackDetailedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
