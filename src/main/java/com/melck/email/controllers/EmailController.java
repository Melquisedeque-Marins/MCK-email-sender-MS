package com.melck.email.controllers;

import com.melck.email.dtos.EmailDTO;
import com.melck.email.models.Email;
import com.melck.email.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping("/send")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDTO emailDTO){
            Email email = service.sendEmail(emailDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(email.getId()).toUri();
            return ResponseEntity.ok().body(email);
    }
}
