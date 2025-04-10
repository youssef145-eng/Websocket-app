package org.example.websocketapp.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.example.websocketapp.model.ActiveUser;
import org.example.websocketapp.model.Storage;

@RestController
@CrossOrigin("http://localhost:63342")
public class UserController {

    @GetMapping("/active")
    public List<ActiveUser> list(){
        return Storage.activeUserList;
    }
}
