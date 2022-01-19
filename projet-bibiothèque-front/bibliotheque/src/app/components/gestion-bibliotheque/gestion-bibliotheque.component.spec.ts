import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionBibliothequeComponent } from './gestion-bibliotheque.component';

describe('GestionBibliothequeComponent', () => {
  let component: GestionBibliothequeComponent;
  let fixture: ComponentFixture<GestionBibliothequeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestionBibliothequeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionBibliothequeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
