import { Component, OnInit } from '@angular/core';

import { IShip } from './ships';
import { ShipService } from './ship.service';

@Component({
  templateUrl: './ships-list.component.html',
  styleUrls: ['./ships-list.component.css']
})
export class ShipsListComponent implements OnInit {
  pageTitle = 'Ship List';
  errorMessage = '';

  _listFilter = '';
  get listFilter(): string {
    return this._listFilter;
  }
  set listFilter(value: string) {
    this._listFilter = value;
    this.setFilteredShips(this.listFilter ? this.performFilter(this.listFilter) : this.ships);
  }

  filteredShips: IShip[] = [];
  ships: IShip[] = [];

  constructor(private shipsService: ShipService) {

  }

  setFilteredShips(ships: IShip[]) {
    this.filteredShips = ships.sort((a, b) => a.name.localeCompare(b.name));
  }

  performFilter(filterBy: string): IShip[] {
    filterBy = filterBy.toLocaleLowerCase();
    return this.ships.filter((ships: IShip) =>
    ships.name.toLocaleLowerCase().indexOf(filterBy) !== -1);
  }

  ngOnInit(): void {
    this.shipsService.getShips().subscribe({
      next: ships => {
        this.ships = ships;
        this.setFilteredShips(this.ships);
      },
      error: err => this.errorMessage = err
    });
  }
}
