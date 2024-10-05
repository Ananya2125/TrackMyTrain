package abc;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;

public class ReservationStatusInformationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String pnr = request.getParameter("pnr");
        Ticket t = null;
        String status = "";

        out.println("<body style='background-color:bisque; color:black;'>");

        if (pnr != null) {
            t = DBManager.getTicketInfo(pnr);

            if (t != null && !t.PNR.equals("null")) {
                switch (t.StatusCode) {
                    case "C":
                        status = HTMLComposer.composeForConfirmed(t);
                        break;
                    case "R":
                        status = HTMLComposer.composeForRAC(t);
                        break;
                    case "W":
                        status = HTMLComposer.composeForWL(t);
                        break;
                }
                out.println(status);
            } else {
                out.println("<center><b><i>Specified Account Number and Pin Number does not exist.</i></b></center>");
            }
        } else {
            out.println("<center><h1>Welcome</h1></center>");
        }
        
        out.println("</body>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
