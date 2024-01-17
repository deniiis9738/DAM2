package com.paracasa.spring.app.restControllers;

import com.paracasa.spring.app.service.menuService.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/api")
@RestController
public class MenuRestController {
    @Autowired
    private MenuService menuService;

    @DeleteMapping("/menu/delete/{id}")
    @ResponseBody
    public RestResponse deleteMenu(@PathVariable Long id){
        menuService.delete(id);
        return new RestResponse().isOk("El menú "+id+" ha sido borrado",
                HttpStatus.ACCEPTED);
    }
}
