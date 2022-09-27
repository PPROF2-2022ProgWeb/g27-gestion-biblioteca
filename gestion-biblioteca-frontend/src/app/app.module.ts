import { PagesModule } from './pages/pages.module';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutModule } from './layout/layout.module';

// Import the module from the SDK
import { AuthModule } from '@auth0/auth0-angular';

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, AppRoutingModule, LayoutModule, HttpClientModule, CommonModule, PagesModule, 
      // Import the module into the application, with configuration
      AuthModule.forRoot({
        domain: 'dev-teuamxoo.us.auth0.com',
        clientId: '4P3UAxGKdBppbYbwHX73UHOEOWEfK1dg'
      }),],
  providers: [],
  bootstrap: [AppComponent],
})

export class AppModule {}
