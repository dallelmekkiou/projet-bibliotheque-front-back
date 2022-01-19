import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  public users=[
    {nom:'dallel',motPasse:'dddd'},
    {nom:'yesmine',motPasse:'yyyy'},
    {nom:'mohamed',motPasse:'mmmm'},
    {nom:'anis',motPasse:'aaaa'}

  ];
  constructor() { }
}
