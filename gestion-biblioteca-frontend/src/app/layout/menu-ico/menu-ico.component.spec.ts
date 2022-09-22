import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuIcoComponent } from './menu-ico.component';

describe('MenuIcoComponent', () => {
  let component: MenuIcoComponent;
  let fixture: ComponentFixture<MenuIcoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuIcoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MenuIcoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
