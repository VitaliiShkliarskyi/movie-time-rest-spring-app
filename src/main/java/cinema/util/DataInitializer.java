package cinema.util;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;

    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void inject() {
        Role admin = new Role();
        admin.setRoleName(Role.RoleName.ADMIN);
        roleService.add(admin);
        Role user = new Role();
        user.setRoleName(Role.RoleName.USER);
        roleService.add(user);
        User master = new User();
        master.setEmail("master@gmail.com");
        master.setPassword("12345678");
        master.setRoles(Set.of(admin));
        userService.add(master);
        User slave = new User();
        slave.setEmail("slave@gmail.com");
        slave.setPassword("87654321");
        slave.setRoles(Set.of(user));
        userService.add(slave);
    }
}
