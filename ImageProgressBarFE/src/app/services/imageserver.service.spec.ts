import { TestBed } from '@angular/core/testing';

import { ImageserverService } from './imageserver.service';

describe('ImageserverService', () => {
  let service: ImageserverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImageserverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
