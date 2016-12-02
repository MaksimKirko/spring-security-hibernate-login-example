package com.websystique.springsecurity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.websystique.springsecurity.model.Role;
import com.websystique.springsecurity.model.Ticket;
import com.websystique.springsecurity.model.action.ActionEnum;
import com.websystique.springsecurity.model.violation.ViolationEnum;
import com.websystique.springsecurity.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springsecurity.model.User;
import com.websystique.springsecurity.service.IRoleService;
import com.websystique.springsecurity.service.IUserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @Autowired
    IRoleService IRoleService;

    @Autowired
    IUserService IUserService;

    @Autowired
    ITicketService ticketService;

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView();
        /*model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is welcome page!");*/
        model.setViewName("hello");
        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {



        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Неверное имя пользователя или пароль!");
        }

        if (logout != null) {
            model.addObject("msg", "Вы успешно вышли из аккаунта.");
        }
        model.setViewName("login");

        return model;

    }

    @RequestMapping(value = "/app**", method = RequestMethod.GET)
    public ModelAndView appPage() {

        List<Ticket> inputTickets = ticketService.getAll();

        List<String> rusViolations = ViolationEnum.getRusViolationsList();

        List<String> rusActions = ActionEnum.getRusActionList();

        ModelAndView model = new ModelAndView();

        model.addObject("rusActions", rusActions);
        model.addObject("rusViolations", rusViolations);
        model.addObject("inputTickets",inputTickets);
        model.setViewName("app");

        return model;

    }


    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }
//
//
//
//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login?logout";
//    }


    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


    @ModelAttribute("roles")
    public List<Role> initializeProfiles() {
        return IRoleService.getAll();
    }

}