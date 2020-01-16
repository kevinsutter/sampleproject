import { IShip } from './ships';
import {ShipService} from './ship.service';
import { of, Observable, throwError } from 'rxjs';
import { catchError, tap, map } from 'rxjs/operators';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';



describe('ShipService', () => {
    let shipService : ShipService, mockHttpClient;


    beforeEach(() => {
        mockHttpClient = jasmine.createSpyObj('mockHttpClient', ['get'])
        shipService = new ShipService(mockHttpClient);
    });

    it('getShips', () => {
        let ships : TestShip[] =[new TestShip('a', 'a', 'a', 5, 5), new TestShip('b', 'b', 'b', 5, 5)] ;

        mockHttpClient.get.and.returnValue(of(ships));

        let actual :Observable<IShip[]> = shipService.getShips();
        expect(mockHttpClient.get).toHaveBeenCalledWith('http://localhost:8080/SpaceShips');
        let actualShips :TestShip[];

      actual.subscribe({
        next: ships => {
          actualShips = ships;
       },
        error: err => this.errorMessage = err
      });
      expect(JSON.stringify(actualShips)).toEqual(JSON.stringify(ships));
    });

    it('getShips throws errors', () => {
      let ships : TestShip[] =[new TestShip('a', 'a', 'a', 5, 5), new TestShip('b', 'b', 'b', 5, 5)] ;

      mockHttpClient.get.and.callFake(() => {
        return throwError(new Error('Fake error'));
      });

      let actual :Observable<IShip[]> = shipService.getShips();
      expect(mockHttpClient.get).toHaveBeenCalledWith('http://localhost:8080/SpaceShips');
      let actualShips :TestShip[], errorMessage;
      expect(actual.subscribe).toThrow;
      actual.subscribe({
        next: ships => {
          actualShips = ships;
       },
        error: err => console.log(err)
      });
    });
  });


export class TestShip implements IShip {

    name: string;
    model: string;
    manufacturer: string;
    cost_in_credits: number;
    hyperdrive_rating: number;

    constructor(name: string,
        model: string,
        manufacturer: string,
        cost_in_credits: number,
        hyperdrive_rating: number) {
            this.name = name;
            this.model = model;
            this.manufacturer = manufacturer;
            this.cost_in_credits = cost_in_credits;
            this.hyperdrive_rating = hyperdrive_rating;
    }
  }
