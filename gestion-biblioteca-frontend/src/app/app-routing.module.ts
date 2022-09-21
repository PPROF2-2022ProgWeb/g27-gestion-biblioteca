import { LibrosComponent } from './pages/libros/libros.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './pages/inicio/inicio.component';

const routes: Routes = [
  { path: '', component: InicioComponent },
  { path: 'notfound', component: NotFoundComponent},
  { path: 'libros', component: LibrosComponent },
  { path: 'prestamos', component: NotFoundComponent },
  { path: 'perfil', component: NotFoundComponent },
  { path: 'perfil/opciones', component: NotFoundComponent },
  { path: 'condiciones-de-uso', component: NotFoundComponent },
  { path: '**', component: InicioComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
