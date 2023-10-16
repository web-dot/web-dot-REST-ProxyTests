import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TestsComponent } from './test/tests/tests.component';
import { FeatureAndApiComponent } from './test/feature-and-api/feature-and-api.component';
import { AngularTableOneComponent } from './test/angular-table-one/angular-table-one.component';

const routes: Routes = [
  {
    path: '',
    component: TestsComponent
  },
  {
    path: 'feature-and-api',
    component: FeatureAndApiComponent
  },
  {
    path: 'angular-table-one',
    component: AngularTableOneComponent
    
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
