import { TestBed } from '@angular/core/testing';

import { HeaderSettersInterceptor } from './header-setters.interceptor';

describe('HeaderSettersInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      HeaderSettersInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: HeaderSettersInterceptor = TestBed.inject(HeaderSettersInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
