import { LeaveDetails } from './leavedetails';
import {Component, NgModule, Pipe, PipeTransform  } from '@angular/core';

@Pipe({
    name: "sort"
})
export class SortPipe implements PipeTransform {
  transform(array: Array<LeaveDetails[]>, args: string): Array<LeaveDetails[]> {
    array.sort((a: any, b: any) => {
      if ( a[args] > b[args] ){
        return -1;
      }else if( a[args] < b[args] ){
          return 1;
      }else{
        return 0; 
      }
    });
    return array;
  }
}