package jsp_employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCRUD {

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
		return connection;
	}

	public int saveEmployee(Employee employee) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3, employee.getPhone());
		preparedStatement.setString(4, employee.getAddress());
		preparedStatement.setString(5, employee.getEmail());
		preparedStatement.setString(6, employee.getPassword());

		int count = preparedStatement.executeUpdate();

		connection.close();
		return count;

	}

	public Employee loginEmployeeInfo(String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMAIL=?");
		preparedStatement.setString(1, email);

		ResultSet resultSet = preparedStatement.executeQuery();
		Employee employee =new Employee();
		while (resultSet.next()) {
			employee.setName(resultSet.getString("name"));
			employee.setPassword(resultSet.getString("password"));

		}
		connection.close();
		return employee;

	}

	public List<Employee> getAllEmoloyees() throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE");
		List<Employee> employees = new ArrayList<Employee>();
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Employee employee = new Employee();
			employee.setId(resultSet.getInt("id"));
			employee.setName(resultSet.getString("name"));
			employee.setPhone(resultSet.getLong("phone"));
			employee.setAddress(resultSet.getString("address"));
			employee.setEmail(resultSet.getString("email"));
			employee.setPassword(resultSet.getString("password"));
			employees.add(employee);
		}
		connection.close();
		return employees;
	}

	public int deleteEmployee(int id) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
		preparedStatement.setInt(1, id);
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;

	}

	public Employee getEmployee(int id) throws Exception {
	Connection connection=getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID=?");
	preparedStatement.setInt(1, id);
	ResultSet resultSet= preparedStatement.executeQuery();
		Employee employee=new Employee();
		while (resultSet.next()) {
			employee.setId(resultSet.getInt("id"));
			employee.setName(resultSet.getString("name"));
			employee.setPhone(resultSet.getLong("phone"));
			employee.setEmail(resultSet.getString("email"));
			employee.setAddress(resultSet.getString("address"));
			employee.setPassword(resultSet.getString("password"));
			
		}
		connection.close();
		return employee;
	}

	public int updateEmployee(Employee employee) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE EMPLOYEE SET NAME=?,EMAIL=?,PHONE=?,ADDRESS=?,EMAIL=?,PASSWORD=? WHERE ID=?");

		preparedStatement.setString(1, employee.getName());
		preparedStatement.setLong(2, employee.getPhone());
		preparedStatement.setString(3, employee.getAddress());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.setString(5, employee.getPassword());
		preparedStatement.setInt(6, employee.getId());

		int count = preparedStatement.executeUpdate();
		connection.close();
		return count;
		
	}
}
