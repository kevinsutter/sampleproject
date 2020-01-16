import { ConvertToSpacesPipe } from './convert-to-spaces.pipe'
import { pipe } from '../../../node_modules/rxjs';
import { Pipe, PipeTransform } from '@angular/core';

describe('ConvertToSpacesPipe', ()=>{
    const pipe: ConvertToSpacesPipe = new ConvertToSpacesPipe();


    it('convert dash to space', ()=>{
        expect(pipe.transform('as-fd','-')).toEqual('as fd');
    })

});