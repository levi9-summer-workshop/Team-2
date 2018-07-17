import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyServeysComponent } from './my-serveys.component';

describe('MyServeysComponent', () => {
  let component: MyServeysComponent;
  let fixture: ComponentFixture<MyServeysComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyServeysComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyServeysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
