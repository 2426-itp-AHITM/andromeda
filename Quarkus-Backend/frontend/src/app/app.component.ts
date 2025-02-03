import { Component } from '@angular/core';
import {Router, RouterOutlet} from '@angular/router';
import {PromptModel, PromptService} from './prompt.service';
import {NgForOf} from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [NgForOf, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

}
