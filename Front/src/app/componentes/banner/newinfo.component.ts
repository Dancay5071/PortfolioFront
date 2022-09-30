import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Banner } from 'src/app/model/banner';
import { BannerService } from 'src/app/service/banner.service';

@Component({
  selector: 'app-neweinfo',
  templateUrl: './newinfo.component.html',
  styleUrls: ['./newinfo.component.css']
})
export class NewinfoComponent implements OnInit {
  nombreE: string;
  descripcionE: string;

  constructor(private bannerS: BannerService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const banner = new Banner(this.nombreE, this.descripcionE);
    this.bannerS.save(banner).subscribe(
      data =>{
        alert("Información añadida correctamente");
        this.router.navigate(['']);
      }, err =>{
        alert("falló");
        this.router.navigate(['']);
      }
    )
  }

}