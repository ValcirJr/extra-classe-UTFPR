import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes, RouterModule} from '@angular/router';
import { IndexComponent } from './index/index.component';
import { GeneroComponent } from './genero/genero.component';
import { ProdutoraComponent } from './produtora/produtora.component';
import { SerieComponent } from './serie/serie.component';
import { LoginService } from './login/login.service';
import { LoginComponent } from './login/login.component';
import { UsuarioCadastroComponent } from './pages/usuario/usuario-cadastro/usuario-cadastro.component';

const routes: Routes = [
  {
    path: '', canActivate: [LoginService], children: [
      { path: '', component: IndexComponent },
      { path: 'genero', component: GeneroComponent },
      { path: 'produtora', component: ProdutoraComponent },
      { path: 'serie', component: SerieComponent },
      { path: 'novo_usuario', component: UsuarioCadastroComponent}
    ]
  },
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports : [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
