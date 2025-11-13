import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Keynote } from '../model/keynote.model';

@Injectable({
  providedIn: 'root'
})
export class KeynoteService {

  private apiUrl = 'http://localhost:8888/keynote-service';

  constructor(private http : HttpClient) { }

  getKeynotes() : Observable<Keynote[]> {
    return this.http.get<Keynote[]>(`${this.apiUrl}/keynotes`);
  }
}
