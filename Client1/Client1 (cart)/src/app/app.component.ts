import { Component } from '@angular/core';

import{EventEmitter} from 'protractor';
import { UserService } from './user.service';
import {EmitterserviceService} from '../app/emitterservice.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
  
})
export class AppComponent {

  constructor() {
  }
  ngOnInit(){   
    document.body.classList.add('image');
  }
  



}
