package filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        long start = System.currentTimeMillis();

        System.out.println("➡️ [BEFORE] " + req.getMethod() + " " + req.getRequestURI());

        chain.doFilter(request, response); // continue processing

        long duration = System.currentTimeMillis() - start;
        System.out.println("⬅️ [AFTER] " + req.getMethod() + " " + req.getRequestURI()
                + " (took " + duration + " ms)");
    }
}
