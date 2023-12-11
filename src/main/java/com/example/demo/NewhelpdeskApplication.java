package com.example.demo;

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
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class NewhelpdeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(NewhelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "29491729543", "valdir@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Tecnico tec2 = new Tecnico(null, "Roberto Junior", "91463426216", "robertex@mail.com", "780");

		Cliente cli1 = new Cliente(null, "Linus Torvalds", "75207787624", "torvalds@mail.com", "123");
		Cliente cli2 = new Cliente(null, "Mauro Vidal", "10679379940", "mauro@gmail.com", "abc");
		Cliente cli3 = new Cliente(null, "Eloize", "73675763056", "elo@mail.com", "eloA");
		Cliente cli4 = new Cliente(null, "Creuzili", "86669342047", "creu@mail.com", "croca");
		Cliente cli5 = new Cliente(null, "Mauro Jose", "88213292910", "maurovidal1397@mail.com", "mauroJ");
		Cliente cli6 = new Cliente(null, "Ademilson", "21264508565", "ade@mail.com", "12345");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		Chamado c2 = new Chamado(null,Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 02", "Segundo chamado", tec2, cli6);

		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));
		chamadoRepository.saveAll(Arrays.asList(c1, c2));

	}
}
