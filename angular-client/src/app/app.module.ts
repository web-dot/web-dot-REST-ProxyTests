import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestsComponent } from './test/tests/tests.component';
import { HttpClientModule } from '@angular/common/http';
import { FeatureAndApiComponent } from './test/feature-and-api/feature-and-api.component';
import { AngularTableOneComponent } from './test/angular-table-one/angular-table-one.component';
import { MatTableModule } from '@angular/material/table'

@NgModule({
  declarations: [
    AppComponent,
    TestsComponent,
    FeatureAndApiComponent,
    AngularTableOneComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
