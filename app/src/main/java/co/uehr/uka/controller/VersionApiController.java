package co.uehr.uka.controller;

import java.nio.file.WatchEvent.Kind;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;

import co.uehr.uka.api.VersionApi;

@Controller
@RequestMapping("/api/v1")
public class VersionApiController implements VersionApi{
    @Value("${uka.version}")
    private String version;

    @Override
    public ResponseEntity<String> getVersion() {
        return new ResponseEntity<>(version, HttpStatus.OK);
    }
}