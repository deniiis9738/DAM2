package com.example.springmvc.models.services;

import com.example.springmvc.models.entity.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> findAll();
}
