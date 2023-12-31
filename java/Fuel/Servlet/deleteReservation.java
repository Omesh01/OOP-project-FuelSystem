package Fuel.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Fuel.Service.ReservationService;

/**
 * Servlet implementation class deleteReservation
 */
@WebServlet("/deleteReservation")
public class deleteReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationService service = new ReservationService();
		int res=service.deleteReservation(Integer.parseInt(request.getParameter("deleteId")));
		
		if(res==1) {
			request.setAttribute("results", 1);
		}else {
			request.setAttribute("results", 0);
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewReservation.jsp");
		dispatcher.forward(request, response);
	}

}
