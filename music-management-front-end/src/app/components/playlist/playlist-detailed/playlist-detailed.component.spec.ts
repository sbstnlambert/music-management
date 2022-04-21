import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaylistDetailedComponent } from './playlist-detailed.component';

describe('PlaylistDetailedComponent', () => {
  let component: PlaylistDetailedComponent;
  let fixture: ComponentFixture<PlaylistDetailedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlaylistDetailedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlaylistDetailedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
