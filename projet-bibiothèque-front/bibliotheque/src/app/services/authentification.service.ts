import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  public users=[
    {prenom:'dallel',motPasse:'dddd'},
    {prenom:'yesmine',motPasse:'yyyy'},
    {prenom:'mohamed',motPasse:'mmmm'},
    {prenom:'anis',motPasse:'aaaa'}

  ];
  constructor() { }
}
