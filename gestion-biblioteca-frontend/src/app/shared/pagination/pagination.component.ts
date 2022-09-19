import {
  Component,
  OnInit,
  Input,
  ChangeDetectionStrategy,
} from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})

/*
 *   Para utilizarlo solo hay que pasarle la cantidad total de páginas deseadas (desde el 1)
 *   Centrado por defecto, para personalizar la posición hay que ubicarlo dentro de otra etiqueta y
 *   darle el estilo deseado
 */
export class PaginationComponent implements OnInit {
  @Input() numPages: number = 3;
  pages = new Array(this.numPages);
  activePage = 1;

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.pages = new Array(this.numPages);
    this.route.queryParams.subscribe((params) => {
      console.log(params);
      this.activePage = parseInt(params['page']) | 1;
      console.log(this.activePage);
    });
  }
}
