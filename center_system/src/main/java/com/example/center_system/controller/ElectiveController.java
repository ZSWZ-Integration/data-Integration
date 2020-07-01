package com.example.center_system.controller;

import com.example.center_system.Service.ElectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.TransformerException;

@RestController
@RequestMapping("/elective")
public class ElectiveController {

    @Autowired
    ElectiveService electiveService;

    @PostMapping(path = "/A_choose_B", consumes = "application/xml")
    public String AChooseB(@RequestBody String string) throws TransformerException {
        return electiveService.A_choose_B(string);
    }

    @PostMapping(path = "/A_choose_C", consumes = "application/xml")
    public String AChooseC(@RequestBody String string) throws TransformerException {
        return electiveService.A_choose_C(string);
    }

    @PostMapping(path = "/B_choose_A", consumes = "application/xml")
    public String BChooseA(@RequestBody String string) throws TransformerException {
        return electiveService.B_choose_A(string);
    }

    @PostMapping(path = "/B_choose_C", consumes = "application/xml")
    public String BChooseC(@RequestBody String string) throws TransformerException {
        return electiveService.B_choose_C(string);
    }

    @PostMapping(path = "/C_choose_A", consumes = "application/xml")
    public String CChooseA(@RequestBody String string) throws TransformerException {
        return electiveService.C_choose_A(string);
    }

    @PostMapping(path = "/C_choose_B", consumes = "application/xml")
    public String CChooseB(@RequestBody String string) throws TransformerException {
        return electiveService.C_choose_B(string);
    }

    @PostMapping(path = "/A_drop_B", consumes = "application/xml")
    public String ADropB(@RequestBody String string) throws TransformerException {
        return electiveService.A_drop_B(string);
    }

    @PostMapping(path = "/A_drop_C", consumes = "application/xml")
    public String ADropC(@RequestBody String string) throws TransformerException {
        return electiveService.A_drop_C(string);
    }
    @PostMapping(path = "/B_drop_A", consumes = "application/xml")
    public String BDropA(@RequestBody String string) throws TransformerException {
        return electiveService.B_drop_A(string);
    }
    @PostMapping(path = "/B_drop_C", consumes = "application/xml")
    public String BDropC(@RequestBody String string) throws TransformerException {
        return electiveService.B_drop_C(string);
    }
    @PostMapping(path = "/C_drop_A", consumes = "application/xml")
    public String CDropA(@RequestBody String string) throws TransformerException {
        return electiveService.C_drop_A(string);
    }
    @PostMapping(path = "/C_drop_B", consumes = "application/xml")
    public String CDropB(@RequestBody String string) throws TransformerException {
        return electiveService.C_drop_B(string);
    }
}
