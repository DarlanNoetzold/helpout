package tech.noetzold.helpout.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;
import tech.noetzold.helpout.model.User;
import tech.noetzold.helpout.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder encoder;
    public UserController(UserService userService, PasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<User>> listarTodos() {
        return ResponseEntity.ok(userService.findAllUsuarios());
    }

    @PostMapping("/save")
    public ResponseEntity<User> salvar(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return ResponseEntity.ok(userService.saveUsuario(user));
    }

    @GetMapping("/validatePass")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
                                                @RequestParam String password) {

        Optional<User> optUsuario = userService.validateLogin(login);
        if (!optUsuario.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        User user = optUsuario.get();
        boolean valid = encoder.matches(password, user.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}
