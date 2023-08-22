package jsp_employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/edit")
public class EditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		long phone=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
	Employee employee=new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setPhone(phone);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(password);
		
		EmployeeCRUD crud=new EmployeeCRUD();
		try {
			int result=crud.updateEmployee(employee);
			if (result!=0) {
				Cookie[] cookies=req.getCookies();
				String value=null;
				for(Cookie cookie:cookies) {
					if (cookie.getName().equals("name")) {
						value=cookie.getValue();
						
					}
				}
				req.setAttribute("cookie", value);
				List<Employee> employees=crud.getAllEmoloyees();
				req.setAttribute("list", employees);
				RequestDispatcher dispatcher=req.getRequestDispatcher("successs.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
