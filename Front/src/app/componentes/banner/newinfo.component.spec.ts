import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewinfoComponent } from './newinfo.component';

describe('NewinfoComponent', () => {
  let component: NewinfoComponent;
  let fixture: ComponentFixture<NewinfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewinfoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
