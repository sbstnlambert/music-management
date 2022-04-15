import { Component, OnInit } from '@angular/core';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  searchInput!: string;

  constructor(private searchService: SearchService) { }

  ngOnInit(): void {
  }

  onChange(input: string): void {
    this.searchInput = input;
    this.searchService.inputSearch = this.searchInput;
  }

}
