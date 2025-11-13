import { Conference } from './../../model/conference.model';
import { Component, OnInit } from '@angular/core';
import { ConferenceService } from '../../services/conference.service';

@Component({
  selector: 'app-conference-list',
  standalone: false,
  templateUrl: './conference-list.component.html',
  styleUrl: './conference-list.component.css'
})
export class ConferenceListComponent {

  conference : Conference[] = [];

  constructor(private conferenceService : ConferenceService){}


  ngOnInit(): void {
    this.getAllConferences();
  }

  getAllConferences() : void {
    this.conferenceService.getConferences().subscribe({
      next : (data) =>{
        this.conference = data;
      },
      error : (error) => {
        console.log(error);
      }
    })
  }



}
