import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http'
import { LeaveApprover } from './tests.component';


@Injectable({
  providedIn: 'root'
})

export class Tests {

  baseUrl : string = "http://localhost:8080" 

  constructor(private httpClient : HttpClient) { }


  options: {
    headers?: HttpHeaders | {[header: string]: string | string[]},
    //observe?: 'body' | 'events' | 'response',
    //params?: HttpParams|{[param: string]: string | number | boolean | ReadonlyArray<string | number | boolean>},
    //reportProgress?: boolean,
    responseType?: 'json';
    //withCredentials?: boolean,
  }

  firstRequest(someParam: string) {
    // return this.http.post(this.baseUrl + "/api/saveProduct/"+someParam, this.options);
    return this.httpClient.post(`${this.baseUrl}/api/saveProduct/${someParam}`, this.options);
  }

  downloadDocumentPdf(customerId: string){
    console.log("in service")
    // return this.http.post(`${this.baseUrl}/api2/pdf?id=${studentId}`, this.options);
    return this.httpClient.post(this.baseUrl + '/jersey/tests/pdf?id=' + customerId, this.options);
  }

  
  getCustomerObject(id: string){
    let params: HttpParams = new HttpParams();
    params = params.append("customerId", id);
    return this.getObjectById(this.baseUrl + '/jersey/tests/getCustomer', params)
  }



  // get student data configuration
  getStudentDataConfiguration(){
    return this.getObjectById(this.baseUrl + '/jersey/tests/getstudentdataconfiguration');
  }

  // get list of master template
  findAllMasterTemplate(){
    return this.getObjectById(this.baseUrl + '/jersey/tests/findall');
  }


  // delete object by id
  deleteFeeTemplateById(feetemplateId: string, feecomponentname: string){
    let params: HttpParams = new HttpParams();
    console.log(feetemplateId, feecomponentname);
    params = params.append('feetemplateId', feetemplateId);
      params = params.append('feecomponentname', feecomponentname);
    return this.getObjectById(this.baseUrl + '/jersey/tests/delete-component-by-id', params);
  }

  // get academic years based on degreeId
  getdegreeeWiseAcademicYear(degreeId: string){
    let params: HttpParams = new HttpParams();
    params = params.append('degreeId', degreeId)
    return this.getObjectById(this.baseUrl + '/jersey/tests/getdegreeWiseacademicyearbydegreeid', params);
  }

    
  getAllLeaveCatagories(userType: string, employmentType: string){
    let params: HttpParams = new HttpParams();
    params = params.append("userType", userType);
    params = params.append("employmentType", employmentType)
    return this.getObjectById(this.baseUrl + '/jersey/tests/leavecategories', params)
  }


  saveLeaveApprovers(userType: string, employmentType: string, leaveApprovers: LeaveApprover[]){
    return this.addObject(this.baseUrl + '/jersey/tests/leavecategories/' + userType + '/' + employmentType, JSON.stringify(leaveApprovers))
  }



  simplestPostRequest(name: string) {
    const url = `${this.baseUrl}/api/saveProduct/${name}`;
    return this.httpClient.post(url, null);
  }

  getObjectById(url: string, params?:HttpParams): Observable<Object>{
    const headers = this.getHeader();
    const options = {headers: headers, params: params}
    return this.httpClient.get(url, options);
  }

  addObject(url: string, body: string, load?:string){
    const headers = this.getHeader();
    const options = {headers: headers}
    return this.httpClient.post(url, body, options);
  }


  getHeader(): HttpHeaders {
    return new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
}
