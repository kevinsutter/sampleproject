import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap, map } from 'rxjs/operators';

import { IShip } from './ships';

@Injectable({
  providedIn: 'root'
})
export class ShipService {
  private shipUrl = 'http://localhost:8080/SpaceShips';

  constructor(private http: HttpClient) { }

  public getShips(): Observable<IShip[]> {
    return this.http.get<IShip[]>(this.shipUrl, )
      .pipe(
        tap(data => console.log('All: ' + JSON.stringify(data))),
        catchError(this.handleError)
      );
  }

  private handleError(err: HttpErrorResponse) {
    let errorMessage = '';
    if (err.error instanceof ErrorEvent) {
      errorMessage = `An error occurred: ${err.error.message}`;
    } else {
      errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }

}
