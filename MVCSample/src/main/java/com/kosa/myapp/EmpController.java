package com.kosa.myapp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {

	@Autowired
	IEmpService empService;
	
	//http://localhost:8080/myapp/hr/count가 요청되면 empCount() 메서드가 실행
	@RequestMapping(value="/hr/count")
	public String empCount(@RequestParam(value="deptid", required=false, 
	defaultValue="0") int deptid, Model model) {
		if(deptid==0) {
			model.addAttribute("count", empService.getEmpCount());
		}else {
			model.addAttribute("count", empService.getEmpCount(deptid));
			int empCount = empService.getEmpCount(deptid);
//			model.addAttribute("count", empCount);			
		}
//		System.out.println("/hr/count 요청됨");
//		int empCount=empService.getEmpCount();
		
		return "hr/count"; //web-inf/views/hr/count.jsp 파일을 실행함(이 파일이 없으면 에러남)
	}
	
	@RequestMapping(value= {"/hr", "/hr/list"})
	public String getAllEmps(Model model) {
		List<EmpVO> empList = empService.getEmpList();
		model.addAttribute("empList", empList);
		System.out.println(empList);
		return "hr/list";
	}
	
	
	@RequestMapping(value="/hr/{employeeId}")
	public String getEmpInfo(@PathVariable int employeeId, Model model) {
		EmpVO emp = empService.getEmpInfo(employeeId);
		model.addAttribute("emp",emp);
		return "hr/view";
	}
	
	@RequestMapping(value="/hr/insert", method=RequestMethod.GET)
	public String insertEmp(Model model) {
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManagerId());
		return "hr/insertform";
	}
	
	@RequestMapping(value="/hr/insert", method=RequestMethod.POST)
	public String insertEmp(EmpVO emp) {
		empService.insertEmp(emp);
		return "redirect:/hr";
	}
	
	@RequestMapping(value="/hr/update", method=RequestMethod.GET)
	public String updateEmp(int empid, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empid));
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManagerId());
		return "hr/updateform";
	}
	
	@RequestMapping(value="/hr/update", method=RequestMethod.POST)
	public String updateEmp(EmpVO emp, Model model) {
		empService.updateEmp(emp);
		return "redirect:/hr/" + emp.getEmployeeId();
	}
	
	@RequestMapping(value="/hr/delete", method=RequestMethod.GET)
	public String deleteEmp(int empid, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empid));
		return "hr/deleteform";
	}
	
	@RequestMapping(value="/hr/delete", method=RequestMethod.POST)
	public String deleteEmp(int empid, String email, Model model) {
		try {
			empService.deleteEmp(empid, email);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/hr";
	}
	
	@ExceptionHandler({RuntimeException.class})
	public ModelAndView runtimeException(HttpServletRequest request, Exception ex) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("url", request.getRequestURI());
		mav.addObject("exception", ex);
		mav.setViewName("error/runtime");
		return mav;
	}
	
	
}
