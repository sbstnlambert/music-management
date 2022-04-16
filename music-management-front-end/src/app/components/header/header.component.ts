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
  ) { }

  ngOnInit(): void {
  }

  onChange(input: string): void {
    this.searchInput = input;
    this.searchService.inputSearch = this.searchInput;
  }

  onClick(event: any): void {
    this.onChange('');
    this.filter = '';
    this.router.navigate([event.target.id]);
  }

}
