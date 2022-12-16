package cinema.controller;


import cinema.model.Role;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private final RoleService roleService;
    private final UserService userService;

    private final AuthenticationService authenticationService;

    public InjectController(RoleService roleService,
                            UserService userService,
                            AuthenticationService authenticationService) {
        this.roleService = roleService;
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String injectData() {
        Role user = new Role();
        user.setRoleName(Role.RoleName.USER);
        Role admin = new Role();
        admin.setRoleName(Role.RoleName.ADMIN);
        roleService.add(user);
        roleService.add(admin);
        authenticationService.register("slave@gmail.com", "12345678");
        User master = new User();
        master.setEmail("master@gmail.com");
        master.setPassword("12345678");
        master.setRoles(Set.of(roleService.getByName("ADMIN")));
        userService.add(master);
        return "Done!";
    }
}
