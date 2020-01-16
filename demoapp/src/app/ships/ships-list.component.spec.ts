import { Component, OnInit } from '@angular/core';
import {TestShip} from './ship.service.spec'
import { IShip } from './ships';
import { ShipsListComponent } from './ships-list.component';
import { of, Observable, throwError } from 'rxjs';


describe('ShipsListComponent', () => {
    let shipsListComponent: ShipsListComponent, mockShipsService;

        beforeEach(() => {
            mockShipsService = jasmine.createSpyObj('mockShipsService', ['getShips']) ;
            shipsListComponent = new ShipsListComponent(mockShipsService);
        });

        it('ngOnInit', () => {
            let ships : TestShip[] =[new TestShip('a', 'a', 'a', 5, 5), new TestShip('b', 'b', 'b', 5, 5)] ;
            mockShipsService.getShips.and.returnValue(of(ships));
            shipsListComponent.ngOnInit();

          expect(JSON.stringify(shipsListComponent.ships)).toEqual(JSON.stringify(ships));
          expect(JSON.stringify(shipsListComponent.filteredShips)).toEqual(JSON.stringify(ships));
        });

        it('performFilter', () => {
            let ships : TestShip[] =[new TestShip('a', 'a', 'a', 5, 5), new TestShip('b', 'b', 'b', 5, 5)]
            shipsListComponent.ships = ships;
            let  filteredList:IShip[] =  shipsListComponent.performFilter('a');
            expect(JSON.stringify(filteredList)).toEqual(JSON.stringify([new TestShip('a', 'a', 'a', 5, 5)]));
        });

        it('setFilteredShips', () => {
            let ships : TestShip[] =[new TestShip('c', 'c', 'c', 5, 5),
             new TestShip('a', 'a', 'a', 5, 5), new TestShip('b', 'b', 'b', 5, 5)];
            shipsListComponent.ships = ships;

            shipsListComponent.setFilteredShips(ships);
            expect(JSON.stringify(shipsListComponent.filteredShips)).toEqual(JSON.stringify([new TestShip('a', 'a', 'a', 5, 5),
             new TestShip('b', 'b', 'b', 5, 5),new TestShip('c', 'c', 'c', 5, 5)]));
        });

});
