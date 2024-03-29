/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package murcia.fernando.proyectoJDBC.example;

import java.math.*;
import java.util.Date;
import java.util.Collection;
import murcia.fernando.proyectoJDBC.dao.EmployeesDao;
import murcia.fernando.proyectoJDBC.dto.Employees;
import murcia.fernando.proyectoJDBC.exceptions.EmployeesDaoException;
import murcia.fernando.proyectoJDBC.factory.EmployeesDaoFactory;

public class EmployeesDaoSample
{
	/**
	 * Method 'main'
	 * 
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String[] arg) throws Exception
	{
		// Uncomment one of the lines below to test the generated code
		
		// findAll();
		// findByEmployees(0);
		// findWhereEmployeeIdEquals(0);
		// findWhereFirstNameEquals("");
		// findWhereLastNameEquals("");
		// findWhereEmailEquals("");
		// findWherePhoneNumberEquals("");
		// findWhereHireDateEquals(null);
		// findWhereJobIdEquals("");
		// findWhereSalaryEquals(0);
		// findWhereCommissionPctEquals(0);
		// findWhereManagerIdEquals(0);
		// findWhereDepartmentIdEquals(0);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			EmployeesDao _dao = getEmployeesDao();
			Employees _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByEmployees'
	 * 
	 * @param managerId
	 */
	public static void findByEmployees(int managerId)
	{
		try {
			EmployeesDao _dao = getEmployeesDao();
			Employees _result[] = _dao.findByEmployees(managerId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereEmployeeIdEquals'
	 * 
	 * @param employeeId
	 */
	public static void findWhereEmployeeIdEquals(int employeeId)
	{
		try {
			EmployeesDao _dao = getEmployeesDao();
			Employees _result[] = _dao.findWhereEmployeeIdEquals(employeeId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereFirstNameEquals'
	 * 
	 * @param firstName
	 */
	public static void findWhereFirstNameEquals(String firstName)
	{
		try {
			EmployeesDao _dao = getEmployeesDao();
			Employees _result[] = _dao.findWhereFirstNameEquals(firstName);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereLastNameEquals'
	 * 
	 * @param lastName
	 */
	public static void findWhereLastNameEquals(String lastName)
	{
		try {
			EmployeesDao _dao = getEmployeesDao();
			Employees _result[] = _dao.findWhereLastNameEquals(lastName);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereEmailEquals'
	 * 
	 * @param email
	 */
	public static void findWhereEmailEquals(String email)
	{
		try {
			EmployeesDao _dao = getEmployeesDao();
			Employees _result[] = _dao.findWhereEmailEquals(email);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWherePhoneNumberEquals'
	 * 
	 * @param phoneNumber
	 */
	public static void findWherePhoneNumberEquals(String phoneNumber)
	{
		try {
			EmployeesDao _dao = getEmployeesDao();
			Employees _result[] = _dao.findWherePhoneNumberEquals(phoneNumber);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereHireDateEquals'
	 * 
	 * @param hireDate
	 */
	public static void findWhereHireDateEquals(Date hireDate)
	{
		try {
			EmployeesDao _dao = getEmployeesDao();
			Employees _result[] = _dao.findWhereHireDateEquals(hireDate);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereJobIdEquals'
	 * 
	 * @param jobId
	 */
	public static void findWhereJobIdEquals(String jobId)
	{
		try {
			EmployeesDao _dao = getEmployeesDao();
			Employees _result[] = _dao.findWhereJobIdEquals(jobId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereSalaryEquals'
	 * 
	 * @param salary
	 */
	public static void findWhereSalaryEquals(float salary)
	{
		try {
			EmployeesDao _dao = getEmployeesDao();
			Employees _result[] = _dao.findWhereSalaryEquals(salary);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereCommissionPctEquals'
	 * 
	 * @param commissionPct
	 */
	public static void findWhereCommissionPctEquals(float commissionPct)
	{
		try {
			EmployeesDao _dao = getEmployeesDao();
			Employees _result[] = _dao.findWhereCommissionPctEquals(commissionPct);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereManagerIdEquals'
	 * 
	 * @param managerId
	 */
	public static void findWhereManagerIdEquals(int managerId)
	{
		try {
			EmployeesDao _dao = getEmployeesDao();
			Employees _result[] = _dao.findWhereManagerIdEquals(managerId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereDepartmentIdEquals'
	 * 
	 * @param departmentId
	 */
	public static void findWhereDepartmentIdEquals(int departmentId)
	{
		try {
			EmployeesDao _dao = getEmployeesDao();
			Employees _result[] = _dao.findWhereDepartmentIdEquals(departmentId);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getEmployeesDao'
	 * 
	 * @return EmployeesDao
	 */
	public static EmployeesDao getEmployeesDao()
	{
		return EmployeesDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Employees dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getEmployeeId() );
		buf.append( ", " );
		buf.append( dto.getFirstName() );
		buf.append( ", " );
		buf.append( dto.getLastName() );
		buf.append( ", " );
		buf.append( dto.getEmail() );
		buf.append( ", " );
		buf.append( dto.getPhoneNumber() );
		buf.append( ", " );
		buf.append( dto.getHireDate() );
		buf.append( ", " );
		buf.append( dto.getJobId() );
		buf.append( ", " );
		buf.append( dto.getSalary() );
		buf.append( ", " );
		buf.append( dto.getCommissionPct() );
		buf.append( ", " );
		buf.append( dto.getManagerId() );
		buf.append( ", " );
		buf.append( dto.getDepartmentId() );
		System.out.println( buf.toString() );
	}

}
