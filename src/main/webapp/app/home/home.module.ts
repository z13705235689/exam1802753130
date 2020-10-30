import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { Exam1802753130SharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
import { HomeComponent } from './home.component';

@NgModule({
  imports: [Exam1802753130SharedModule, RouterModule.forChild([HOME_ROUTE])],
  declarations: [HomeComponent],
})
export class Exam1802753130HomeModule {}
