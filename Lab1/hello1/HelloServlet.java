import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

        
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello World</h1>");
		out.println("<h2>Recompilat</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}
}