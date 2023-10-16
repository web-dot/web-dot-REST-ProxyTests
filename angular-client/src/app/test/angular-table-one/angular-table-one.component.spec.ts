import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularTableOneComponent } from './angular-table-one.component';

describe('AngularTableOneComponent', () => {
  let component: AngularTableOneComponent;
  let fixture: ComponentFixture<AngularTableOneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AngularTableOneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularTableOneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
