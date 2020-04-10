import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './pages/home/home.component';
import {GraphComponent} from './pages/graph/graph.component';
import {CountryComponent} from './pages/country/country.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'graph', component: GraphComponent},
  {path: 'country/:country', component: CountryComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
