export enum TypeConference {
  COMMERCIALE = 'COMMERCIALE',
  ACADEMIQUE = 'ACADEMIQUE'
}

export interface Review {
  id: number;
  date: Date;
  text: string;
  note: number;
}

export interface Conference {
  id: number;
  titre: string;
  typeConference: TypeConference;
  date: Date;
  duree: number;
  nombreInscrits: number;
  score: number;
  reviews: Review[];
}
