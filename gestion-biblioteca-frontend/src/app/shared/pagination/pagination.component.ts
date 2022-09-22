import {
  Component,
  OnInit,
  OnChanges,
  Input,
  ChangeDetectionStrategy,
} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})

/*
 *   Para utilizarlo solo hay que pasarle la cantidad total de páginas deseadas (contando desde el 1)
 *   Centrado por defecto, para personalizar la posición hay que ubicarlo dentro de otra etiqueta y
 *   darle los estilos deseados
 */
export class PaginationComponent implements OnInit, OnChanges {
  @Input() numPages: number = 3;
  pages = new Array(this.numPages);

  getCurrentPage = () => {
    return parseInt(this.route.snapshot.queryParamMap.get('page') || '1');
  };

  prevPage = () => {
    const currentPage = this.getCurrentPage();
    if (currentPage > 1) {
      return currentPage - 1;
    } else {
      return 1;
    }
  };

  nextPage = () => {
    const currentPage = this.getCurrentPage();
    if (currentPage < this.numPages) {
      return currentPage + 1;
    } else {
      return this.numPages;
    }
  };

  constructor(protected route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.pages = new Array(this.numPages);
    this.router.navigate([], { queryParams: { page: this.getCurrentPage() } });
  }

  ngOnChanges() {}
}
