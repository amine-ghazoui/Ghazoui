import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Conference } from '../model/conference.model';

@Injectable({
  providedIn: 'root'
})
export class ConferenceService {

  private apiUrl = 'http://localhost:8888/conference-service';


  constructor(private http : HttpClient) { }

  getConferences() : Observable<Conference[]> {
    return this.http.get<Conference[]>(`${this.apiUrl}/conferences`);
  }
  
  getConferenceById(id : number) : Observable<Conference>{
    return this.http.get<Conference>(`${this.apiUrl}/conferences/${id}`);
  }

  searchConferences(keyword : string) : Observable<Array<Conference>> {
    return this.http.get<Array<Conference>>(`${this.apiUrl}/conferences/search?keyword=${keyword}`);
  }


}
