import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ShipsListComponent } from './ships-list.component';
import { ConvertToSpacesPipe } from '../shared/convert-to-spaces.pipe';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  imports: [
    RouterModule.forChild([
      { path: 'ships', component: ShipsListComponent },
    ]),
    SharedModule
  ],
  declarations: [
    ShipsListComponent,
    ConvertToSpacesPipe
  ]
})
export class ShipsModule { }
