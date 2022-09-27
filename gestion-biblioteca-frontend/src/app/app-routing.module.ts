import { LibrosComponent } from './pages/libros/libros.component';
import { DashboardComponent } from './pages/usuarios/dashboard/dashboard.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { Component, NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { PrestamosComponent } from './pages/prestamos/prestamos.component';
import { InicioComponent } from './pages/inicio/inicio.component';

const routes: Routes = [
  { path: '', redirectTo: 'inicio', pathMatch: 'full' },
  { path: 'notfound', component: NotFoundComponent},
  { path: 'dashboard', component: DashboardComponent},
  { path: 'libros', component: LibrosComponent },
  { path: 'prestamos', component: PrestamosComponent },
  { path: 'perfil', component: NotFoundComponent },
  { path: 'perfil/opciones', component: NotFoundComponent },
  { path: 'condiciones-de-uso', component: NotFoundComponent },
  { path: '**', component: InicioComponent },
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
