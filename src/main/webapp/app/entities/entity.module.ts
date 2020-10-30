import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'user-account',
        loadChildren: () => import('./user-account/user-account.module').then(m => m.Exam1802753130UserAccountModule),
      },
      {
        path: 'course-info',
        loadChildren: () => import('./course-info/course-info.module').then(m => m.Exam1802753130CourseInfoModule),
      },
      {
        path: 'course-outline',
        loadChildren: () => import('./course-outline/course-outline.module').then(m => m.Exam1802753130CourseOutlineModule),
      },
      {
        path: 'course-resources',
        loadChildren: () => import('./course-resources/course-resources.module').then(m => m.Exam1802753130CourseResourcesModule),
      },
      {
        path: 'course-my',
        loadChildren: () => import('./course-my/course-my.module').then(m => m.Exam1802753130CourseMyModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class Exam1802753130EntityModule {}
