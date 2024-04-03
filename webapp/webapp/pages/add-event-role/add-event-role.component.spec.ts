import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEventRoleComponent } from './add-event-role.component';

describe('AddEventRoleComponent', () => {
  let component: AddEventRoleComponent;
  let fixture: ComponentFixture<AddEventRoleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddEventRoleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddEventRoleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
