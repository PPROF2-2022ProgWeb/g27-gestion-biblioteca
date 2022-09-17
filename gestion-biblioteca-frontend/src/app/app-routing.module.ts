import { NotFoundComponent } from './pages/not-found/not-found.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: NotFoundComponent },
  { path: 'libros', component: NotFoundComponent },
  { path: 'prestamos', component: NotFoundComponent },
  { path: 'perfil', component: NotFoundComponent },
  { path: 'perfil/opciones', component: NotFoundComponent },
  { path: 'condiciones-de-uso', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
