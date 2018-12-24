import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private uri: string) {
  }

  getAllUser(): Promise<any> {
    return Promise.resolve();
  }


}
