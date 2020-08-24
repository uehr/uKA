package co.uehr.uka.controller;

import java.nio.file.WatchEvent.Kind;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import co.uehr.uka.api.VersionApi;
import co.uehr.uka.entity.User;
import co.uehr.uka.repository.UserRepository;

@Controller
@RequestMapping("/api/v1")
public class VersionApiController implements VersionApi{
    @Value("${uka.version}")
    private String version;

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<String> getVersion() {
        User user = new User();
        user.setName("hoge name");
        user.setEmail("hoge email");
        userRepository.save(user);
        return new ResponseEntity<>(user.getId().toString(), HttpStatus.OK);
    }
}