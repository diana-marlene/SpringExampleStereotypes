package org.generation.MyFirstWebApp.controller;

import org.generation.MyFirstWebApp.model.User;
import org.generation.MyFirstWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController /*Intersecta las peticiones HTTP */
public class UserController
{
    final UserService userService;
    /*Autowired : describe la inyección de dependencia */
    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
        /* Instanciando un nuevo objeto */
        userService.add( new User( 1, "Santiago", "Carrillo" ) );
        userService.add( new User( 2, "Diana", "Sánchez" ) );
        userService.add( new User( 3, "Peddro", "Ortíz" ) );

    }

    @GetMapping( "/user" )
    public User getUser()
    {
        return userService.getUser( 0 ); /*Retorna la petición del metodo getUser */
    }
    @GetMapping( "/users/all" )
    public int totalUsers()
    {
        return userService.size();
    }
    @GetMapping( "/users/names" )
    public List<User> getAll()
    {
        return userService.getAll();
    }

}
