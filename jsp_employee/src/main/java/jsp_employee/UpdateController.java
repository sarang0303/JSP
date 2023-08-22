package jsp_employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		
		EmployeeCRUD crud=new EmployeeCRUD();
		try {
			Employee employee=crud.getEmployee(id);
			if (employee!=null) {
				HttpSession httpSession=req.getSession();
			String name=(String)httpSession.getAttribute("name");
				if (name!=null) {
					req.setAttribute("emp", employee);
					RequestDispatcher dispatcher=req.getRequestDispatcher("edit.jsp");
					dispatcher.forward(req, resp);
					
				} else {
					req.setAttribute("message", "Please Login First");
					RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
					dispatcher.forward(req, resp);

				}
				
			} 

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
