package br.com.fiap;

import br.com.fiap.domain.entity.Advogado;
import br.com.fiap.domain.entity.Estado;
import br.com.fiap.domain.entity.Processo;
import br.com.fiap.domain.entity.TipoDeAcao;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
        EntityManager manager = factory.createEntityManager();

        Estado estado = new Estado();
        Estado estado2 = new Estado();

        estado.setNome("SÃO PAULO").setSigla("SP");
        estado.setNome("Rio de janeiro").setSigla("RJ");

        Advogado advogado = new Advogado();
        Advogado advogado2 = new Advogado();
        advogado.setNome("Matheus Martins").setNumeroOAB("29082003").setEstado(estado);
        advogado2.setNome("Augusto Santana").setNumeroOAB("20032000").setEstado(estado2);

        TipoDeAcao tipoDeAcao = new TipoDeAcao();
        TipoDeAcao tipoDeAcao2 = new TipoDeAcao();
        tipoDeAcao.setNome("Divorcio");
        tipoDeAcao2.setNome("Familia");

        Processo processo = new Processo();
        Processo processo2 = new Processo();

        processo.setAdvogado(advogado).setNumero("5").setProBono(true).setTipoDeAcao(tipoDeAcao);
        processo2.setAdvogado(advogado).setNumero("6").setProBono(false).setTipoDeAcao(tipoDeAcao);

        manager.getTransaction().begin();

        manager.persist(estado);
        manager.persist(estado2);
        manager.persist(advogado);
        manager.persist(advogado2);
        manager.persist(tipoDeAcao);
        manager.persist(tipoDeAcao2);
        manager.persist(processo);
        manager.persist(processo2);
        manager.getTransaction().commit();

        Long id = Long.parseLong(JOptionPane.showInputDialog("Pesquise um processo pelo seu id"));

        Processo processoById = manager.find(Processo.class, id);
        System.out.println("Processo selecionado: " + processoById);

        List<Processo> processos = manager.createQuery("FROM processo").getResultList();
        System.out.println("Todos os processos: " + processos);


        manager.close();
        factory.close();




    }
}