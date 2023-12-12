package com.example.demo.services;

import com.example.demo.domain.enums.Perfil;
import com.example.demo.domain.enums.Prioridade;
import com.example.demo.domain.enums.Status;
import com.example.demo.dominio.Chamado;
import com.example.demo.dominio.Cliente;
import com.example.demo.dominio.Tecnico;
import com.example.demo.repositories.ChamadoRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB(){
        Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "29491729543", "valdir@mail.com", "123");
        tec1.addPerfil(Perfil.ADMIN);

        Tecnico tec2 = new Tecnico(null, "Roberto Junior", "91463426216", "robertex@mail.com", "780");
        tec2.addPerfil(Perfil.TECNICO);

        Tecnico tec3 = new Tecnico(null, "Mauro João", "152.712.655-28", "joaomauro@mail.com", "h12234a");
        tec3.addPerfil(Perfil.ADMIN);

        Tecnico tec4 = new Tecnico(null, "Ayrton Lucas", "885.516.117-20", "ayrton@mail.com", "ayrtão" );
        tec4.addPerfil(Perfil.TECNICO);



        Cliente cli1 = new Cliente(null, "Linus Torvalds", "752.077.876-24", "torvalds@mail.com", "123");
        Cliente cli2 = new Cliente(null, "Mauro Vidal", "106.793.799-40", "mauro@gmail.com", "abc");
        Cliente cli3 = new Cliente(null, "Eloize", "736.757.630-56", "elo@mail.com", "eloA");
        Cliente cli4 = new Cliente(null, "Creuzili", "866.693.420-47", "creu@mail.com", "croca");
        Cliente cli5 = new Cliente(null, "Mauro Jose", "882.132.929-10", "maurovidal1397@mail.com", "mauroJ");
        Cliente cli6 = new Cliente(null, "Ademilson", "212.645.085-65", "ade@mail.com", "12345");

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
        Chamado c2 = new Chamado(null,Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 02", "Segundo chamado", tec2, cli6);
        Chamado c3 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 03", "Chamado urgente", tec3, cli2);
        Chamado c4 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 04", "Quarto chamado", tec4, cli6);
        Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 05", "Quinto chamado", tec2, cli3);

        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));

    }

}
