package bdbt_project.SpringApplication;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.FORBIDDEN.value()) {
                return "errors/403";
            } else if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "errors/404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "errors/500";
            } else if (statusCode == HttpStatus.GATEWAY_TIMEOUT.value()) {
                return "errors/504";
            } else {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                if (authentication != null && authentication.isAuthenticated()) {
                    String userRole = authentication.getAuthorities().isEmpty() ? "" : authentication.getAuthorities().iterator().next().getAuthority();

                    if ("ADMIN".equals(userRole)) {
                        return "redirect:/main_admin";
                    } else if ("USER".equals(userRole)) {
                        return "redirect:/main_user";
                    }
                }

                return "redirect:/";
            }
        }

        return "redirect:/";
    }


    @RequestMapping ("/logout")
    public String logout(HttpServletRequest request, Model model) {
        // Your existing logout logic

        // Check if the timeout parameter is present
        String timeoutParam = request.getParameter("timeout");
        if ("true".equals(timeoutParam)) {
            model.addAttribute("timeoutMessage", "Zostałeś wylogowany z powodu zbyt długiego czasu bezczynności.");
        }

        return "redirect:/login"; // Redirect to the login page or any other page
    }


}
