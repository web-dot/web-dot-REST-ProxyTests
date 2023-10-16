import { Component, OnInit } from '@angular/core';
import { Tests } from './tests.service';
import { Router } from '@angular/router';
import { MasterTemplate } from '../angular-table-one/angular-table-one.component';


@Component({
  selector: 'app-tests',
  templateUrl: './tests.component.html',
  styleUrls: ['./tests.component.css']
})
export class TestsComponent implements OnInit {

  name = 'sudipto'
  customerId = 'd8e61c92-1e60-4aa7-9db3-839b7c8fcd52'
  load: boolean;
  masterTemplates: MasterTemplate[] = [];
  data: MasterTemplate[];
  feeComponents: FeeComponent[] = [];
  degreeId = 'BE'

  selectedUserType  = "TEACHING";
  selectedUserTypeForLeaveApprovers  = "NON_TEACHING";
  selectedEmploymentType = "PERMANENT"
  leaveApprovers: LeaveApprover[];



  constructor(public service: Tests, public router: Router) { }

  ngOnInit() {
  }

  sendRequest(param: string){
    this.service.firstRequest(param).subscribe(res => {
      console.log(res)
    })
  }

  downloadDocument(id: string){
    this.service.downloadDocumentPdf(id).subscribe(response => {
      console.log(response)
    })
  }

  getCustomer(id: string){
    this.service.getCustomerObject(id).subscribe(response => {
      console.log(response);
    })
  }

  studentDataConfiguration(){
    this.service.getStudentDataConfiguration().subscribe(response => {
      console.log(response);
    })
  }

  getFeeComponents(){
    this.load = true;
    this.service.findAllMasterTemplate().subscribe(response => {
      this.masterTemplates = response as MasterTemplate[];
      this.feeComponents = this.masterTemplates[0].feeComponents;
      console.log("master" , this.masterTemplates)
    })
  }

  deleteComponentById(){
    let feeTemplateId = this.masterTemplates[2].id;
    let feeComponent = this.masterTemplates[2].feeComponents[0].componentName;
    console.log(feeTemplateId, feeComponent);
    this.service.deleteFeeTemplateById(feeTemplateId, feeComponent).subscribe(response => {
      console.log(response); 
    })
  }


  getdegreeeWiseAcademicYear(degreeId: string){
    this.service.getdegreeeWiseAcademicYear(degreeId).subscribe(resposne => {
      console.log(resposne)
    });
  }


  // GET list of LeaveCatagoryDetail objects
  getAllLeaveCatagories(){
    this.service.getAllLeaveCatagories(this.selectedUserType, this.selectedEmploymentType).subscribe(res => {
      console.log(res);
    });
  }


  // POST to save approvers
  saveApprovers(){
    this.service.saveLeaveApprovers(this.selectedUserTypeForLeaveApprovers, this.selectedEmploymentType, this.leaveApprovers).subscribe(response => {
      console.log(response);
    })
  }



  // for feature with api
  featureWithApi(){
    this.router.navigate(['feature-and-api'])
  }

}

export class FeeComponent {
  id: string;
  componentName: string;
  componentAmount: number;
 // isIncluded: boolean;
  feeItems: FeeItem[];
  includeComponent: boolean;
  considerItAsOtherFee: boolean;
  editAndDeleteDisable: boolean;
  updated: boolean;
  hideComponent: boolean;
}

export class FeeItem {
  id: string;
  itemName: string;
  itemAmount: number;
}

export class LeaveApprover {
  id: string;
  priority: number;
  approver: string;
}

