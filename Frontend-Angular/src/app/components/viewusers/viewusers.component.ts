import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from 'src/app/app.service';
import { User } from 'src/app/User';
import { FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-viewusers',
  templateUrl: './viewusers.component.html',
  styleUrls: ['./viewusers.component.css']
})
export class ViewusersComponent implements OnInit {

  users: User[] =[];
  user:User | undefined;
  url: string = "http://localhost:8080/";

  dataAdd: any
  dataUpdate:any

  formAdd = new FormGroup({
    name: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required]),
    pNo: new FormControl('', [Validators.required]),
    address: new FormControl('', [Validators.required])
  })

  formUpdate = new FormGroup({
    email: new FormControl('', [Validators.required]),
    pNo: new FormControl('', [Validators.required]),
    address: new FormControl('', [Validators.required])
  })

  constructor(private service: AppService, private router: Router) {
  }

  ngOnInit() {
    this.getAllUsers();
  }

  addUser(){
    this.dataAdd = this.formAdd.value

    this.service.adduser(this.dataAdd).subscribe(data => {
      this.formAdd.reset();
      this.getAllUsers();
    })

  }
  selectUser(user:User){
    this.user=user;

    this.formUpdate = new FormGroup({
      email: new FormControl(this.user.email, [Validators.required]),
      pNo: new FormControl(this.user.pNo, [Validators.required]),
      address: new FormControl(this.user.address, [Validators.required])
    })
  }
  updateUser(){

    this.dataUpdate = this.formUpdate.value

    this.service.updateUser(this.user?.id, this.dataUpdate).subscribe(data => {
      this.getAllUsers();
    })
  }

  getAllUsers(){
    this.service.getUsers().subscribe(data => {
      this.users = data;
    })
  }

  deleteUser(id: number){
    this.service.deleteUser(id).subscribe((data:any) => {
      this.getAllUsers();
    })
  }

}
