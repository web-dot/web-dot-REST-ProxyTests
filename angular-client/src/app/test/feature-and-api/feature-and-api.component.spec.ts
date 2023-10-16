import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeatureAndApiComponent } from './feature-and-api.component';

describe('FeatureAndApiComponent', () => {
  let component: FeatureAndApiComponent;
  let fixture: ComponentFixture<FeatureAndApiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeatureAndApiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeatureAndApiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
