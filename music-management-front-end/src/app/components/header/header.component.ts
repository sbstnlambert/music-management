import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  searchInput!: string;
  filter: string = '';

  constructor(
    private searchService: SearchService,
    private router: Router
  ) {
    this.searchService.resetSubject.subscribe({
      next: any => this.onReset(),
      error: () => console.log("Subscription to SearchService failed")
    });
  }

  ngOnInit(): void {
  }

  onChange(input: string): void {
    this.searchInput = input;
    this.searchService.inputSearch = this.searchInput;
  }

  onClick(event: any): void {
    this.onReset();
    this.router.navigate([event.target.id]);
  }

  onReset(): void {
    this.filter = '';
    this.onChange('');
  }

}
