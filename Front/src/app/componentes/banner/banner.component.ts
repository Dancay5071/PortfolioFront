import { Component, OnInit } from '@angular/core';
import { Banner } from 'src/app/model/banner';
import { BannerService } from 'src/app/service/banner.service';
import { TokenService } from 'src/app/service/token.service';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent implements OnInit {
  persona: persona = new persona("","","");

  constructor(public personaService: PersonaService, private bannerS: BannerService, private tokenService: TokenService) { }

  ngOnInit(): void {
    this.personaService.getPersona().subscribe(data => {this.persona = data})

    this.cargarBanner();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  banner: Banner[] = [];

  isLogged = false;

  cargarBanner(): void{
    this.bannerS.lista().subscribe(
      data =>{
        this.banner = data;
      }
    )
  }

  delete(id?: number){
    if( id != undefined){
      this.bannerS.delete(id).subscribe(
        data => {
          this.cargarBanner();
        }, err => {
          alert("No se pudo eliminar");
        }
      )
    }
  }
}