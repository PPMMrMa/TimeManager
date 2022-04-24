package filter;

import javax.servlet.*;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        /*HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        Users user = (Users)session.getAttribute("user");
        if(user != null){
            chain.doFilter(request,response);
        } else{
          out.println("您还未登陆，三秒钟后跳转至登录页面");
          response.setHeader("refresh","3;../Login.jsp");
        }*/
    }

    public void init(FilterConfig config) throws ServletException {

    }

}