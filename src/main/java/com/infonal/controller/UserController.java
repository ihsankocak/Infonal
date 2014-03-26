package com.infonal.controller;

import com.infonal.model.User;
import com.infonal.service.UserService;
import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller

public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/user"}, method = RequestMethod.GET)
    public String getUserList(ModelMap model) {
        model.addAttribute("userList", userService.listUser());
        return "output";

    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)

    public View createUser(@ModelAttribute User user, ModelMap model, HttpServletRequest request/*,@RequestParam("recaptcha_response_field") String recaptcha_response_field,@RequestParam("recaptcha_challenge_field") String recaptcha_challenge_field*/) {
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phoneNumber = request.getParameter("phoneNumber");
        if (StringUtils.hasText(userId)) {

            userService.updateUserById(userId);

        } else {

            User newUser = new User();
            newUser.setName(name);
            newUser.setSurname(surname);
            newUser.setPhoneNumber(phoneNumber);

            userService.addUser(newUser);

        }
        return new RedirectView("/usermanage/user");
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public View deleteUser(HttpServletRequest request, @ModelAttribute User user, ModelMap model) {
        System.out.println("geldihahiddesu: " + request.getParameter("id"));
        String userId = request.getParameter("id");
        userService.deleteUserById(userId);

        return new RedirectView("/usermanage/user");
    }

    @RequestMapping(value = "/user/validate", method = RequestMethod.POST)

    public @ResponseBody
    Boolean validate(HttpServletRequest request, @RequestParam("jcaptcha") String jcaptcha) {

      //String remoteAddress=      request.getRemoteAddr();
      // System.out.println(captchaPair.getRecaptcha_response_field()+" -fsdfdsfsdfdfs "+captchaPair.getRecaptcha_challenge_field()+"qqqqqqq"+remoteAddress);
        //  return userService.isCaptchaValid(remoteAddress, captchaPair);
        String userCaptchaResponse = request.getParameter("jcaptcha");
        System.out.println("ahabu response:" + userCaptchaResponse);
        boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, userCaptchaResponse);
        return captchaPassed;

    }
}
