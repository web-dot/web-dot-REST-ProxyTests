import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Tests } from '../tests/tests.service';
import { FeeComponent } from '../tests/tests.component';

@Component({
  selector: 'app-angular-table-one',
  templateUrl: './angular-table-one.component.html',
  styleUrls: ['./angular-table-one.component.css']
})
export class AngularTableOneComponent implements OnInit {

  masterTemplates: MasterTemplate[] = [];
  data: MasterTemplate[];
  load: boolean;
  columnsToDisplay = ['index', 'template', 'degree', 'modifieddate', 'modifiedby'];


  constants = {
    SL_NUMBER:"Sl#",
    MASTER_TEMPLATE: "Master Template",
    DEGREE: "Degree",
    LAST_UPDATED: "Last Updated",
    LAST_UPDATED_BY: "Last Updated By"
  }


  constructor(public router: Router, public service: Tests) { }

  ngOnInit() {
    this.loadTable();
    this.load = true;
  }


  loadTable(){
    this.load = true;
    this.service.findAllMasterTemplate().subscribe(response => {
      console.log(response);
      this.masterTemplates = response as MasterTemplate[];
      this.data = this.masterTemplates;
    })
  }


}

export class MasterTemplate {
	id: string;
	name: string;
	degreeId: string;
	degreeYear: number;
	modeOfEntry: string;
	totalAmount: number;
	totalAmountInWords: string;
	feeComponents: FeeComponent[];
	// feeComponentDto: FeeComponentDtoForEditAndDelete[];
	deleteDisable: boolean;
	modifiedAt: Date;
}
