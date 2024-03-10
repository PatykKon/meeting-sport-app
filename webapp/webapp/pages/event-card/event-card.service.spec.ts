import { TestBed } from '@angular/core/testing';

import { EventCardService } from './event-card.service';

describe('EventCardService', () => {
  let service: EventCardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EventCardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
