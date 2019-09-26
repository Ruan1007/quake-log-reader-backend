import { Http, Request, RequestOptions, RequestOptionsArgs, Response, XHRBackend } from '@angular/http';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Injectable, Injector, Inject, forwardRef } from '@angular/core';

import { ToastrService } from 'ngx-toastr';

import { Observable } from 'rxjs/Rx';

import { Router } from '@angular/router';
import { Location } from '@angular/common';

// operators
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/map';

@Injectable()
export class AppInterceptor implements HttpInterceptor {

  constructor(
    private injector: Injector,
    private router: Router,
    private location: Location
  ) { }

  private get toastrService(): ToastrService {
    return this.injector.get(ToastrService);
  }

  /* Adiciona o token em todas requests */
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    return next.handle(req)
      .do((event) => {
        // success
        // if (event instanceof HttpResponse) {
        //   console.log(event)
        //   this.showSuccess('Sucesso: ' + event.statusText);
        // }
      })
      .catch(
        error => {

          if (error instanceof HttpErrorResponse) {

            switch (error.status) {
              /* BAD_REQUEST - 400 */
              case 400:
                this.showError('mensagem.error.formulario');
                break;

              /* AUTENTICAÇÃO - 401 */
              case 401:
                this.showError('mensagem.error.login', 'login');
                break;

              /* PERMISSÃO - 403 */
              case 403:
                this.showError('mensagem.error.permissao');
                this.location.back();
                break;

              /* NOT FOUND - 404*/
              case 404:
                this.showError('mensagem.error.not-found');
                break;

              /* DUPLICATED  - 409 */
              case 409:
                this.showError('mensagem.error.duplicaded');
                break;

              /* PRECONDITION - 412*/
              case 412:
                this.showError('mensagem.error.login');
                break;

              /* BAD_REQUEST - 500 */
              case 500: default:
                this.showError('mensagem.error.servidor');
                break;
            }
          }
          return Observable.throw(error);
        }
      );
  }

  showError(messageKey: string, redirect?: string) {

      if (redirect) {
        console.log('Redirect = ' + redirect);
      }

      this.toastrService.error(messageKey, 'Error', { closeButton: true });
  }
  
  showSuccess(messageKey: string, redirect?: string) {

      if (redirect) {
        console.log('Redirect = ' + redirect);
        this.router.navigate([redirect]);
      }

      this.toastrService.success(messageKey, 'Success', { closeButton: true });
    };
}
