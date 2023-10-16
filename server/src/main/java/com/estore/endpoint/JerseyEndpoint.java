package com.estore.endpoint;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estore.builder.SuccessMessage;
import com.estore.builder.SuccessMessageBuilder;
import com.estore.domain.DegreeWiseAcademicYear;
import com.estore.domain.LeaveApprover;
import com.estore.domain.LeaveCategoryDetail;
import com.estore.domain.MasterTemplate;
import com.estore.domain.StudentDataConfiguration;
import com.estore.dto.CustomerDto;
import com.estore.dto.MasterTemplateDto;
import com.estore.service.AnnualLeaveRuleService;
import com.estore.service.DegreeWiseAcademicYearService;
import com.estore.service.MasterTemplateService;
import com.estore.service.PrimaryService;
import com.estore.service.StudentDataConfigurationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@Component
@Path("/tests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JerseyEndpoint {
	
	@Autowired
	PrimaryService primaryService;
	
	@Autowired
	StudentDataConfigurationService studentDataConfigurationService;
	
	@Autowired
	MasterTemplateService masterTemplateService;
	
	@Autowired
	DegreeWiseAcademicYearService degreeWiseAcademicYearService;
	
	@Autowired
	AnnualLeaveRuleService annualLeaveRuleService;

	@POST
	@Produces("application/vnd.pdf")
	@Path("/pdf")
	public void downloadStudentPdf(@QueryParam("id") @NotBlank(message = "Student id cannot be blank") String studentId) {
		String response = primaryService.downloadStudentPdfFile(studentId);
		System.err.println(response);
	}
	
	
	@GET
	@Path("/getCustomer")
	@ApiOperation(value = "Find Customer object from db based on customerId", notes = "Get CustomerDto Object by customerId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Customer Object is fetched successfully"),
				@ApiResponse(code = 400, message = "Bad Request"),
				@ApiResponse(code = 500, message = "Internal Server Error")})
	public CustomerDto getDataListBasedOnId(@QueryParam("customerId") @NotBlank(message = "CustomerId cannot be blank") String customerId){
		CustomerDto customer = primaryService.returnOrderListBasedOnId(customerId);
		return customer;
	}
	
	
	@GET
	@Path("/getstudentdataconfiguration")
	@ApiOperation(value = "Get StudentDataConfiguration", notes = "An Api to get the StudentDataConfiguration")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "StudentDataConfiguration fetched successfully"),
			@ApiResponse(code = 404, message = "StudentDataConfiguration not found"),
			@ApiResponse(code = 500, message = "Internal server error")})
	public StudentDataConfiguration getConfiguration() {
		return studentDataConfigurationService.getStudentDataConfiguration();
	}
	
	@GET
	@Path("/findall")
	@ApiOperation(value = "Finds all master templates", notes = "Gets all master templates from DB")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully fetched all master templates", response = MasterTemplate.class),
			@ApiResponse(code = 404, message = "Exception occured while fetching all master templates"),
			@ApiResponse(code = 500, message = "Internal server error") })
	public List<MasterTemplateDto> findAll(){
		return masterTemplateService.findAllMasterTemplates();
	}
	
	
	@GET
	@Path("/delete-component-by-id")
	@ApiOperation(value = "Test API to delete a object by id", notes = "Deletes a master template object by id")
	public SuccessMessage deleteComponentById(@QueryParam("feetemplateId") String feeTemplateId,
			@QueryParam("feecomponentname") String feeComponent) {
		return SuccessMessageBuilder.statusCode(Status.OK)
				.message(masterTemplateService.deleteComponentById(feeTemplateId, feeComponent))
				.build();
	}
	
	
	@GET
	@Path("/getdegreeWiseacademicyearbydegreeid")
	@ApiOperation(value = "Find DegreeWiseAcademicYear object based on degreeiD", notes = "Get DegreewiseAcademicYear object")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "DegreeWiseAcademicYear is fetched successfully"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public DegreeWiseAcademicYear findDegreeWiseAcademicYear(@QueryParam("degreeId") String degreeId) {
		return degreeWiseAcademicYearService.findDegreeWiseAcademicYear(degreeId);
	}
	
	
	
	/**
	 * api to get all the LeaveCategoryDetails
	 * */
	@GET
	@Path("/leavecategories")
	public List<LeaveCategoryDetail> fetchAllLeaveCategories(@QueryParam("userType") String userType, 
			@QueryParam("employmentType") String employmentType){
		return annualLeaveRuleService.fetchAllLeaveCategoryDetails(userType, employmentType);
	}
	
	/**
	 * api to save the leave approvers
	 * */
	public List<LeaveApprover> saveLeaveApprovers(
			@PathParam("userType") String userType, 
			@PathParam("employmentType") String employmentType, 
			List<LeaveApprover> leaveApprovers){
		return annualLeaveRuleService.saveLeaveApprovers(userType, employmentType, leaveApprovers);
	}
	
	
}
