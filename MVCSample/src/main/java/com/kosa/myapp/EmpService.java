package com.kosa.myapp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpService implements IEmpService {

	
	@Autowired
	IEmpRepository empRepository;
	
	@Override
	public int getEmpCount() {
		return empRepository.getEmpCount();
	}

	@Override
	public int getEmpCount(int deptid) {
		return empRepository.getEmpCount(deptid);
	}

	@Override
	public List<EmpVO> getEmpList() {
		return empRepository.getEmpList();
	}

	@Override
	public EmpVO getEmpInfo(int empid) {
		return empRepository.getEmpInfo(empid);
	}

	@Override
	public void updateEmp(EmpVO emp) {
		empRepository.updateEmp(emp);

	}

	@Override
	public void insertEmp(EmpVO emp) {
		empRepository.insertEmp(emp);

	}

	@Override
	@Transactional
	public void deleteEmp(int empid, String email) {
		empRepository.deleteJobHistory(empid);
		empRepository.deleteEmp(empid, email);
		// 두 개 트랜잭션 처리 가능
	}

	@Override
	public List<Map<String, Object>> getAllDeptId() {
		return empRepository.getAllDeptId();
	}

	@Override
	public List<Map<String, Object>> getAllJobId() {
		return empRepository.getAllJobId();
	}

	@Override
	public List<Map<String, Object>> getAllManagerId() {
		return empRepository.getAllManagerId();
	}

}