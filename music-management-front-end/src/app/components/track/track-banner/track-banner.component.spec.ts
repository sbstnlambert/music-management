import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackBannerComponent } from './track-banner.component';

describe('TrackBannerComponent', () => {
  let component: TrackBannerComponent;
  let fixture: ComponentFixture<TrackBannerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrackBannerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackBannerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
