import { Component, OnInit } from '@angular/core';
import { Keynote } from '../../model/keynote.model';
import { KeynoteService } from '../../services/keynote.service';

@Component({
  selector: 'app-keynotes',
  standalone: false,
  templateUrl: './keynotes.component.html',
  styleUrl: './keynotes.component.css'
})
export class KeynotesComponent {

  keynotes : Keynote[] = [];

  constructor(private keynoteService : KeynoteService){}

  ngOnInit(): void {
    this.getKeynotes();
  }

  getKeynotes() : void {
    this.keynoteService.getKeynotes().subscribe({
      next : (data) =>{
        this.keynotes = data;
      },
      error : (error) => {
        console.log(error);
      }
    })
  }




}
