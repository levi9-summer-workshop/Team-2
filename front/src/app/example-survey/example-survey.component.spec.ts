import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExampleSurveyComponent } from './example-survey.component';

describe('ExampleSurveyComponent', () => {
  let component: ExampleSurveyComponent;
  let fixture: ComponentFixture<ExampleSurveyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExampleSurveyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExampleSurveyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
