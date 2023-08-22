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
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		EmployeeCRUD crud = new EmployeeCRUD();

		try {
			Employee employee = crud.loginEmployeeInfo(email);
			if (password.equals(employee.getPassword())) {
				HttpSession httpSession = req.getSession();
				httpSession.setAttribute("name", employee.getName());

				Cookie cookie = new Cookie("name", employee.getName());
				resp.addCookie(cookie);
				List<Employee> employees = crud.getAllEmoloyees();
				req.setAttribute("list", employees);
				RequestDispatcher dispatcher = req.getRequestDispatcher("successs.jsp");
				dispatcher.forward(req, resp);

			} else {
				req.setAttribute("message", "Invalid credentials");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
